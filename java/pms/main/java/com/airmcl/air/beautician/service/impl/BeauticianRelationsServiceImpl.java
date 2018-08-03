package com.airmcl.air.beautician.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.air.beautician.dao.BeauticianRelationsMapper;
import com.airmcl.air.beautician.dao.BeauticianServiceMapper;
import com.airmcl.air.beautician.dao.ext.BeauticianRelationsExtMapper;
import com.airmcl.air.beautician.enter.BeauticianServiceEnterParams;
import com.airmcl.air.beautician.entity.BeauticianRelations;
import com.airmcl.air.beautician.entity.BeauticianRelationsExample;
import com.airmcl.air.beautician.out.BeauitcianRelationService;
import com.airmcl.air.beautician.out.BeauticianRelationsServiceOut;
import com.airmcl.air.beautician.service.BeauticianRelationsService;
import com.airmcl.air.service.dao.ServiceMapper;
import com.airmcl.air.service.entity.ServiceExample;
import com.els.base.auth.entity.User;
import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;

@Service("defaultBeauticianRelationsService")
public class BeauticianRelationsServiceImpl implements BeauticianRelationsService {
    @Resource
    protected BeauticianRelationsMapper beauticianRelationsMapper;
    @Resource
    protected ServiceMapper serviceMapper;
    @Resource 
    protected BeauticianServiceMapper beauticianServiceMapper; 
    @Resource
    protected BeauticianRelationsExtMapper beauticianRelationsExtMapper;
    

    @CacheEvict(value={"beauticianRelations"}, allEntries=true)
    @Override
    public void addObj(BeauticianRelations t) {
        this.beauticianRelationsMapper.insertSelective(t);
    }

    @CacheEvict(value={"beauticianRelations"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.beauticianRelationsMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beauticianRelations"}, allEntries=true)
    @Override
    public void modifyObj(BeauticianRelations t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.beauticianRelationsMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="beauticianRelations", keyGenerator="redisKeyGenerator")
    @Override
    public BeauticianRelations queryObjById(Integer id) {
        return this.beauticianRelationsMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="beauticianRelations", key="'BeauticianRelationsService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BeauticianRelations> queryAllObjByExample(BeauticianRelationsExample example) {
        return this.beauticianRelationsMapper.selectByExample(example);
    }

    @Cacheable(value="beauticianRelations", key="'BeauticianRelationsService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BeauticianRelations> queryObjByPage(BeauticianRelationsExample example) {
        PageView<BeauticianRelations> pageView = example.getPageView();
        pageView.setQueryResult(this.beauticianRelationsMapper.selectByExampleByPage(example));
        return pageView;
    }

    /**
     * 批量修改状态
     * @param ids
     * @param state
     */
    @Override
    public void updateState(int[] ids, Integer state) {

        this.beauticianRelationsMapper.updateState(ids,state);

    }

    /**
     * 根据技师id查询技师所关联的服务项目
     * @param beauticianId
     * @return
     */
	@Override
	public List<BeauticianRelationsServiceOut> findServiceByBeauticianId(Map<String, Object> para) {
		List<BeauticianRelationsServiceOut> arrayList = new ArrayList<BeauticianRelationsServiceOut>();
		//查询出门店下 技师 已关联的和未关联的服务项目
		List<BeauitcianRelationService> list = beauticianRelationsExtMapper.findServiceByBeauticianId(para);
		if (list.size()<1||list==null) {
			return new ArrayList<BeauticianRelationsServiceOut>();
		}
		for (BeauitcianRelationService brs : list) {
			//通过服务项目id去查详细信息
			ServiceExample example = new ServiceExample();
			example.createCriteria().andIdEqualTo(brs.getServiceId());
			List<com.airmcl.air.service.entity.Service> selectByExample = serviceMapper.selectByExample(example);
			for (com.airmcl.air.service.entity.Service service : selectByExample) {
				BeauticianRelationsServiceOut out = new BeauticianRelationsServiceOut();
				out.setId(service.getId());
				out.setServiceName(service.getServiceName());
				out.setServiceCover(service.getServiceCover());
				out.setState(brs.getState());
				out.setBeautyId(brs.getBeautyId());
				out.setRelationsId(brs.getRelationsId());
				arrayList.add(out);
			}
		}
		return arrayList;
	}

	/**
	 * 
	 * 技师关联服务项目操作
	 */
	@Transactional
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void insertRelationShip(BeauticianServiceEnterParams enterParams) {
		//拿到后台登录用户的id 插入RelationShip表里的operate_i-->操作者ID
		User user = SpringSecurityUtils.getLoginUser();
//		if (user==null) {
//			throw new CommonException("获取登录用户信息失败！无法设置操作者ID");
//		}
//		if ("".equals(enterParams.getBeautyId()) ||enterParams.getBeauticianId() ==null ) {
//			throw new CommonException("输入的门店ID为空！");
//		}
//		if ("".equals(enterParams.getBeauticianId()) ||enterParams.getBeautyId()==null) {
//			throw new CommonException("输入的美容师ID为空！");
//		}
		List<Integer> serviceIdList = enterParams.getServiceId();
		//1,如果传入的serviceId不为空，则先删除之前的记录，再重新插入 所有勾选的  否则产生重复数据
		BeauticianRelationsExample example = new BeauticianRelationsExample();
		example.createCriteria().andBeautyIdEqualTo(enterParams.getBeautyId()).andBtIdEqualTo(enterParams.getBeauticianId());
		if (serviceIdList.size()>0) { 
			beauticianRelationsMapper.deleteByExample(example);
			for (int i = 0; i < serviceIdList.size(); i++) {
				BeauticianRelations br = new BeauticianRelations();
				br.setBeautyId(enterParams.getBeautyId());
				br.setBtId(enterParams.getBeauticianId());
				br.setServiceId(serviceIdList.get(i));
				br.setOperateType((byte)1);
				br.setOperateId(1);
				br.setState((byte)1);
				Long time = System.currentTimeMillis()/1000;
				br.setCreatetime(time+"");
				this.beauticianRelationsMapper.insert(br);
			}
		}else {
			if (enterParams.getIds().length>0) {
				//2,如果传入的serviceid为空，表示取消所有关联， 取消所有关联 需要拿到之前的关联id 设置状态为删除
				beauticianRelationsMapper.updateState(enterParams.getIds(),Integer.valueOf(0));
			}else {
				//如果传入的关系表的ids是空的 ，就不做任何操作
				return ;
			}
		}
		
	}
}