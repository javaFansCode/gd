package com.airmcl.air.beautician.service.impl;

import com.airmcl.air.beautician.dao.BeauticianExperienceMapper;
import com.airmcl.air.beautician.dao.BeauticianExtendMapper;
import com.airmcl.air.beautician.dao.BeauticianMapper;
import com.airmcl.air.beautician.entity.Beautician;
import com.airmcl.air.beautician.entity.BeauticianExample;
import com.airmcl.air.beautician.entity.BeauticianExperience;
import com.airmcl.air.beautician.entity.BeauticianExtend;
import com.airmcl.air.beautician.service.BeauticianService;
import com.airmcl.air.beauty.dao.BeautyExtendMapper;
import com.airmcl.air.beauty.dao.BeautyMapper;
import com.airmcl.air.beauty.entity.Beauty;
import com.airmcl.air.beauty.entity.BeautyExtend;
import com.airmcl.air.beauty.entity.BeautyExtendExample;
import com.airmcl.basae.utils.UserCenterHelper;
import com.airmcl.uc.token.UCTokenApiServiceImpl;
import com.alibaba.dubbo.common.json.JSONArray;
import com.alibaba.dubbo.common.json.JSONObject;
import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("defaultBeauticianService")
public class BeauticianServiceImpl implements BeauticianService {
    @Resource
    protected BeauticianMapper beauticianMapper;
    @Resource
    protected BeauticianExperienceMapper beauticianExperienceMapper;
    @Resource
    protected BeauticianExtendMapper beauticianExtendMapper;
    @Resource
    protected BeautyMapper beautyMapper;
    @Resource
    protected BeautyExtendMapper beautyExtendMapper;

    @Autowired
    protected UCTokenApiServiceImpl ucTokenApiService;


    @CacheEvict(value={"beautician"}, allEntries=true)
    @Override
    public void addObj(Beautician t) {
    	BeauticianExample example = new BeauticianExample();
    	//校验是否已经创建过一次美容师
    	if (t.getMobile()!=null) {
        	example.createCriteria().andMobileEqualTo(t.getMobile());
		}
        List<Beautician> selectByExample = beauticianMapper.selectByExample(example);
        if (selectByExample.size()>0) {
        	throw new CommonException("该手机号已经注册过美容师！创建失败");
		}
        //校验这个手机号码是不是用户中心注册过的
        JSONArray data =null;
        JSONObject userCoreByMobile = UserCenterHelper.getUserInfoByMobile(t.getMobile(), ucTokenApiService.getToken());
        if(userCoreByMobile==null){
            throw new CommonException("该手机号未在用户中心注册，创建失败");
        }else {
        	Object data1 = userCoreByMobile.get("data");
        	if(null == data1){
                throw new CommonException("该手机号未在用户中心注册，创建失败");
            }
        	String string = ((JSONObject) data1).getString("openId");
            t.setOpenId(string);
            Integer createtime =Double.valueOf((System.currentTimeMillis()/1000)).intValue();
            t.setStoreScore(0);
            t.setCommunicateScore(0);
            t.setProfessionalScore(0);
            t.setPunctualityScore(0);
            t.setStoreScore(0);
            t.setServiceTotal((short)0);
            t.setGoodTotal(0);
            t.setCommentTotal((short)0);
            t.setCreatetime(createtime.toString());
            this.beauticianMapper.insert(t);
            if(t.getBeauticianExperience()!=null){
                t.getBeauticianExperience().setBtId(t.getId());
                t.getBeauticianExperience().setCreatetime(createtime);
                beauticianExperienceMapper.insert(t.getBeauticianExperience());
            }
            if(t.getBeauticianExtend()!=null){
                t.getBeauticianExtend().setBtId(t.getId());
                beauticianExtendMapper.insert(t.getBeauticianExtend());
            }
        }
    }

    @CacheEvict(value={"beautician"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        List<Integer> list = new ArrayList<>();
        list.add(id);
        beauticianExperienceMapper.deleteByIds(list);
        beauticianExtendMapper.deleteByIds(list);
        this.beauticianMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beautician"}, allEntries=true)
    @Override
    public void modifyObj(Beautician t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        t.setStoreScore(null);
        t.setCommunicateScore(null);
        t.setProfessionalScore(null);
        t.setPunctualityScore(null);
        t.setStoreScore(null);
        t.setServiceTotal(null);
        t.setGoodTotal(null);
        t.setCommentTotal(null);
        t.setCreatetime(null);
        this.beauticianMapper.updateByPrimaryKeySelective(t);
//编辑美容师时候在这段代码报错   发现这段代码没 有意义 暂时先注释
//        Beauty beauty = this.beautyMapper.selectByPrimaryKey(t.getBeautyId());
//        BeautyExtendExample beautyExtendExample = new BeautyExtendExample();
//        beautyExtendExample.createCriteria().andBeautyIdEqualTo(t.getBeautyId());
//        List<BeautyExtend> beautyExtends = this.beautyExtendMapper.selectByExample(beautyExtendExample);
//        List<String> strList = new ArrayList<String>();
//        if(beautyExtends != null && beautyExtends.size() > 0) {
//            String[] str = beautyExtends.get(0).getOpenTime().split("-");
//            strList.add(str[0]);
//            strList.add(str[1]);
//        }

        // TODO:去除美容师工作经历操作
        /*if(t.getBeauticianExperience()!=null){
            BeauticianExperience beauticianExperience =beauticianExperienceMapper.findBeauticianExperienceByBtId(t.getId());
            if(beauticianExperience==null){
                Integer createtime =Double.valueOf((System.currentTimeMillis()/1000)).intValue();
                t.getBeauticianExperience().setBtId(t.getId());
                // 工作开始时间和结束时间这个怎么处理
                t.getBeauticianExperience().setStarttime();
                t.getBeauticianExperience().setEndtime();
                t.getBeauticianExperience().setCreatetime(createtime);
                t.getBeauticianExperience().setBeautyName(beauty.getBeautyName());
                // 这里默认为技师
                t.getBeauticianExperience().setJobTitleId(4);
                beauticianExperienceMapper.insert(t.getBeauticianExperience());
            }else {
                t.getBeauticianExperience().setId( beauticianExperience.getId());
                beauticianExperienceMapper.updateByPrimaryKeySelective(t.getBeauticianExperience());
            }
        }*/
        if(t.getBeauticianExtend()!=null){
            BeauticianExtend beauticianExtend =beauticianExtendMapper.findBeauticianExtendByBtId(t.getId());
            if(beauticianExtend==null){
                t.getBeauticianExtend().setBtId(t.getId());
                beauticianExtendMapper.insert(t.getBeauticianExtend());
            }else{
                t.getBeauticianExtend().setId(beauticianExtend.getId());
                beauticianExtendMapper.updateByPrimaryKeySelective(t.getBeauticianExtend());
            }
        }
    }

    @Cacheable(value="beautician", keyGenerator="redisKeyGenerator")
    @Override
    public Beautician queryObjById(Integer id) {
        Beautician beautician = this.beauticianMapper.selectByPrimaryKey(id);
        if(beautician==null){
            return null;
        }
        beautician.setBeauticianExtend(beauticianExtendMapper.findBeauticianExtendByBtId(beautician.getId()));
        beautician.setBeauticianExperience(beauticianExperienceMapper.findBeauticianExperienceByBtId(beautician.getId()));
        return beautician;
    }

    @Cacheable(value="beautician", key="'BeauticianService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Beautician> queryAllObjByExample(BeauticianExample example) {
        return this.beauticianMapper.selectByExample(example);
    }

    @Cacheable(value="beautician", key="'BeauticianService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Beautician> queryObjByPage(BeauticianExample example) {
        PageView<Beautician> pageView = example.getPageView();
        pageView.setQueryResult(this.beauticianMapper.selectByExampleByPage(example));
        return pageView;
    }

    @Override
    public int deleteByIds(int[] ids) {

        if(ids!=null){
            List<Integer> list=new ArrayList();
            for (int i:ids){
                list.add(i);
            }
            beauticianExperienceMapper.deleteByIds(list);
            beauticianExtendMapper.deleteByIds(list);
            return beauticianMapper.deleteByIds(list);
        }
        throw new CommonException("id 为空，操作失败！");
    }


    /**
     * 批量修改状态
     * @param ids
     * @param state
     */
    @Override
    public void updateState(int[] ids, Integer state) {

        this.beauticianMapper.updateState(ids,state);

    }

}