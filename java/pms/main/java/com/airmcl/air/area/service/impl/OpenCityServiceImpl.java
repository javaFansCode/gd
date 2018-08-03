package com.airmcl.air.area.service.impl;

import com.airmcl.air.area.dao.AreasMapper;
import com.airmcl.air.area.dao.OpenCityMapper;
import com.airmcl.air.area.entity.Areas;
import com.airmcl.air.area.entity.AreasExample;
import com.airmcl.air.area.entity.OpenCity;
import com.airmcl.air.area.entity.OpenCityExample;
import com.airmcl.air.area.service.OpenCityService;
import com.airmcl.air.area.vo.AddStreetVO;
import com.airmcl.air.area.vo.CreateOpenCityVO;
import com.airmcl.air.beauty.dao.BeautyMapper;
import com.airmcl.air.beauty.entity.Beauty;
import com.airmcl.air.beauty.entity.BeautyExample;
import com.alibaba.druid.sql.dialect.mysql.ast.MysqlForeignKey;
import com.els.base.core.entity.PageView;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import com.els.base.core.exception.CommonException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("defaultOpenCityService")
public class OpenCityServiceImpl implements OpenCityService {

    private static Logger logger = LoggerFactory.getLogger(OpenCityServiceImpl.class);

    @Resource
    protected OpenCityMapper openCityMapper;

    @Resource
    protected AreasMapper areasMapper;

    @Resource
    protected BeautyMapper beautyMapper;

    @CacheEvict(value={"openCity"}, allEntries=true)
    @Override
    public void addObj(OpenCity t) {
        this.openCityMapper.insertSelective(t);
    }

    @CacheEvict(value={"openCity"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.openCityMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"openCity"}, allEntries=true)
    @Override
    public void modifyObj(OpenCity t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.openCityMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="openCity", keyGenerator="redisKeyGenerator")
    @Override
    public OpenCity queryObjById(Integer id) {
        return this.openCityMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="openCity", key="'OpenCityService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<OpenCity> queryAllObjByExample(OpenCityExample example) {
        return this.openCityMapper.selectByExample(example);
    }

    @Cacheable(value="openCity", key="'OpenCityService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<OpenCity> queryObjByPage(OpenCityExample example) {
        PageView<OpenCity> pageView = example.getPageView();
        pageView.setQueryResult(this.openCityMapper.selectByExampleByPage(example));
        return pageView;
    }

    @Override
    @Transactional
    public OpenCity createOpenCity(CreateOpenCityVO createOpenCityVO) {
        /*
        1、页面从Areas获取省列表
        2、根据省ID获取市列表（不用过滤掉isopen为1的数据）
        3、后台根据上面的数据获取对应的区数据
        4、将数据写入到opencity表中
         */

        int provinceId = createOpenCityVO.getProvinceId();
        int cityId = createOpenCityVO.getCityId();

        //1、先判断前端传过来的参数是否有效
        AreasExample checkCityExample = new AreasExample();
        AreasExample.Criteria checkCityExampleCriteria = checkCityExample.createCriteria();
        checkCityExampleCriteria.andParent_idEqualTo(provinceId);
        checkCityExampleCriteria.andIdEqualTo(cityId);
        List<Areas> checkCityList = this.areasMapper.selectByExample(checkCityExample);
        if (checkCityList.size() <= 0){
            throw new CommonException("没有查找到对应的地区数据，请检查参数");
        }
        //查询得到有效的城市数据
        Areas checkCity = checkCityList.get(0);

        //2、判断当前选择的城市是否已开通
        OpenCityExample openCityExample = new OpenCityExample();
        openCityExample.createCriteria().andArea_idEqualTo(checkCity.getId()).andArea_parent_idEqualTo(checkCity.getParent_id());
        List<OpenCity> checkOpenCityList = this.openCityMapper.selectByExample(openCityExample);
        if (checkOpenCityList.size() > 0){
            throw new CommonException("当前城市已开通");
        }

        //3、根据城市id和级别，查询对应的区数据
        AreasExample areasExample = new AreasExample();
        AreasExample.Criteria criteria = areasExample.createCriteria();
        criteria.andParent_idEqualTo(checkCity.getId());
        criteria.andLevelEqualTo((byte)3);
        List<Areas> areasList = this.areasMapper.selectByExample(areasExample);

        if (areasList.size() <= 0){
            //根据城市id获取对应的区数据为空（level=3）
            throw new CommonException("根据城市id="+checkCity.getId()+"没有找到地区数据");
        }

        //4、将数据插入到opencity表中

        //查询省数据
        Areas areas = this.areasMapper.selectByPrimaryKey(provinceId);
        if (areas == null){
            throw new CommonException("查询省数据失败");
        }
        int parent_id = 0;

        //查询数据是否已经存在开通城市表中，如果存在则不处理
        OpenCityExample areasEx = new OpenCityExample();
        areasEx.createCriteria().andLevelEqualTo((byte) 1).andArea_idEqualTo(areas.getId());
        List<OpenCity> list =  this.openCityMapper.selectByExample(areasEx);
        if (list.isEmpty()) {
            //插入省数据
            OpenCity areasCity = new OpenCity();
            areasCity.setName(areas.getName());
            areasCity.setLevel(areas.getLevel());
            areasCity.setSort((short)999);
            areasCity.setParent_id(areas.getParent_id());
            areasCity.setArea_id(areas.getId());
            areasCity.setArea_parent_id(areas.getParent_id());
            //默认开放预约
            areasCity.setOpen_reserve((byte)1);
            areasCity.setLongitude("");
            areasCity.setLatitude("");
            //1表示正常
            areasCity.setState((byte)1);
            this.openCityMapper.insert(areasCity);
            parent_id = areasCity.getId();
        }else {
            parent_id = list.get(0).getId();
        }

        //先插入城市数据
        OpenCity city = new OpenCity();
        city.setName(checkCity.getName());
        city.setLevel(checkCity.getLevel());
        city.setSort((short)999);
        city.setParent_id(parent_id);
        city.setArea_id(checkCity.getId());
        city.setArea_parent_id(checkCity.getParent_id());
        //默认开放预约
        city.setOpen_reserve((byte)1);
        city.setLongitude("");
        city.setLatitude("");
        //1表示正常
        city.setState((byte)1);
        this.openCityMapper.insert(city);

        //然后插入地区数据
        for (Areas obj: areasList){
            OpenCity area = new OpenCity();
            area.setName(obj.getName());
            area.setLevel(obj.getLevel());
            area.setSort((short)999);
            area.setParent_id(city.getId());
            area.setArea_id(obj.getId());
            area.setArea_parent_id(obj.getParent_id());
            //默认开放预约
            area.setOpen_reserve((byte)1);
            area.setLongitude("");
            area.setLatitude("");
            //1表示正常
            area.setState((byte)1);
            this.openCityMapper.insert(area);
        }

        //修改省市区级联表的数据状态
        AreasExample updateAreasExample = new AreasExample();
        AreasExample.Criteria updateCriteriaOne = updateAreasExample.createCriteria();
        updateCriteriaOne.andIdEqualTo(checkCity.getId());
        AreasExample.Criteria updateCriteriaTwo = updateAreasExample.createCriteria();
        updateCriteriaTwo.andParent_idEqualTo(checkCity.getId());
        updateAreasExample.or(updateCriteriaOne);
        updateAreasExample.or(updateCriteriaTwo);

        Areas updateAreas = new Areas();
        updateAreas.setIs_open((byte)1);
        this.areasMapper.updateByExampleSelective(updateAreas, updateAreasExample);

        return city;
    }

    @Override
    @Transactional
    public OpenCity addStreetToArea(AddStreetVO addStreetVO) {

        //判断数据有效性
        OpenCityExample example = new OpenCityExample();
        example.createCriteria().andIdEqualTo(addStreetVO.getAreaId());
        List<OpenCity> list = this.openCityMapper.selectByExample(example);
        if (list.size() <= 0){
            throw new CommonException("没有找到对应的数据");
        }

        for (String streetName : addStreetVO.getStreets()) {
            if (StringUtils.isBlank(streetName)){
                continue;
            }
            OpenCity openCity = new OpenCity();
            openCity.setName(streetName);
            // `level` tinyint(4) DEFAULT NULL COMMENT '1=省，2=市，3=区,4=街道',
            openCity.setLevel((byte)4);
            openCity.setSort((short)999);
            openCity.setParent_id(addStreetVO.getAreaId());
            openCity.setArea_id(0);
            openCity.setArea_parent_id(list.get(0).getArea_id());
            // 默认开放预约 `open_reserve` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否开放预约1开放预约 2此城市所有美容师都不可以被预约',
            openCity.setOpen_reserve((byte)1);
            openCity.setLongitude("");
            openCity.setLatitude("");
            // 1表示正常 `state` tinyint(1) DEFAULT '1' COMMENT '0=删除，1=正常',
            openCity.setState((byte)1);
            this.openCityMapper.insert(openCity);
        }

        return null;
    }

    @Override
    public void deleteStreetById(int id) {
        // 检查门店表中是否有使用到街道字段，如果有则不允许删除，这里只允许删除街道数据
        // 检查门店中是否有使用街道数据
        BeautyExample beautyExample = new BeautyExample();
        //状态不等于0，表示没有删除的
        beautyExample.createCriteria().andStreetEqualTo(id).andStateNotEqualTo((byte)0);
        List<Beauty> list = this.beautyMapper.selectByExample(beautyExample);
        if (list != null && !list.isEmpty()){
            throw new CommonException("街道数据已使用，不能删除");
        }

        //检查id数据是否存在
        OpenCityExample ocExample = new OpenCityExample();
        OpenCityExample.Criteria ocCriteria = ocExample.createCriteria();
        ocCriteria.andIdEqualTo(id);
        ocCriteria.andLevelEqualTo((byte)4);
        List<OpenCity> openCityList = this.openCityMapper.selectByExample(ocExample);
        if (openCityList == null || openCityList.isEmpty()){
            throw new CommonException("id数据不存在");
        }

        //删除open_city表中的街道数据
        OpenCityExample openCityExample = new OpenCityExample();
        OpenCityExample.Criteria criteria = openCityExample.createCriteria();
        criteria.andIdEqualTo(id);
        // `level` tinyint(4) DEFAULT NULL COMMENT '1=省，2=市，3=区,4=街道',
        criteria.andLevelEqualTo((byte)4);

        OpenCity openCity = new OpenCity();
        // `state` tinyint(1) DEFAULT '1' COMMENT '0=删除，1=正常',
        openCity.setState((byte)0);
        this.openCityMapper.updateByExampleSelective(openCity, openCityExample);

    }


}