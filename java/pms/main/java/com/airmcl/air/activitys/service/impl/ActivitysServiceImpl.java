package com.airmcl.air.activitys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.air.activitys.dao.ActivitysBeautyMapper;
import com.airmcl.air.activitys.dao.ActivitysCouponsMapper;
import com.airmcl.air.activitys.dao.ActivitysMapper;
import com.airmcl.air.activitys.dao.ActivitysServicesMapper;
import com.airmcl.air.activitys.dao.ext.ActivitysExtMapper;
import com.airmcl.air.activitys.entity.Activitys;
import com.airmcl.air.activitys.entity.ActivitysBeauty;
import com.airmcl.air.activitys.entity.ActivitysBeautyExample;
import com.airmcl.air.activitys.entity.ActivitysBeautyVo;
import com.airmcl.air.activitys.entity.ActivitysCoupons;
import com.airmcl.air.activitys.entity.ActivitysCouponsExample;
import com.airmcl.air.activitys.entity.ActivitysCouponsVo;
import com.airmcl.air.activitys.entity.ActivitysExample;
import com.airmcl.air.activitys.entity.ActivitysServices;
import com.airmcl.air.activitys.entity.ActivitysServicesExample;
import com.airmcl.air.activitys.entity.ActivitysServicesVo;
import com.airmcl.air.activitys.entity.EnterActivitysVo;
import com.airmcl.air.activitys.service.ActivitysService;
import com.els.base.core.entity.PageView;

@Service("defaultActivitysService")
public class ActivitysServiceImpl implements ActivitysService {
    @Resource
    protected ActivitysMapper activitysMapper;
    @Resource
    protected ActivitysExtMapper activitysExtMapper;
    @Resource
    protected ActivitysCouponsMapper activitysCouponsMapper;
    @Resource
    protected ActivitysServicesMapper activitysServicesMapper;
    @Resource
    protected   ActivitysBeautyMapper activitysBeautyMapper;
    @CacheEvict(value={"activitys"}, allEntries=true)
    @Override
    public void addObj(Activitys t) {
        this.activitysMapper.insertSelective(t);
    }

    @CacheEvict(value={"activitys"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.activitysMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"activitys"}, allEntries=true)
    @Override
    public void modifyObj(Activitys t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.activitysMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="activitys", keyGenerator="redisKeyGenerator")
    @Override
    public Activitys queryObjById(Integer id) {
        return this.activitysMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="activitys", key="'ActivitysService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Activitys> queryAllObjByExample(ActivitysExample example) {
        return this.activitysMapper.selectByExample(example);
    }

    @Cacheable(value="activitys", key="'ActivitysService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Activitys> queryObjByPage(ActivitysExample example) {
        PageView<Activitys> pageView = example.getPageView();
        pageView.setQueryResult(this.activitysMapper.selectByExampleByPage(example));
        return pageView;
    }

	@Override
	public List<ActivitysCouponsVo> queryActivitysCouponsVoListByActivitysId(Integer activitysId) {
		return activitysExtMapper.selectActivitysCouponsVoListByActivityId(activitysId);
	}

	@Override
	public List<ActivitysServicesVo> queryActivitysServicesVoListByActivitysId(Integer activitysId) {
		return activitysExtMapper.selectActivitysServicesVoListByActivityId(activitysId);
	}

	@Override
	public int deleteActivitysCouponsByActivitysId(ActivitysCouponsExample example) throws RuntimeException {
		return activitysCouponsMapper.deleteByExample(example);
	}

	@Override
	public int deleteActivitysServices(ActivitysServices activitysServices) throws RuntimeException {
		return activitysServicesMapper.updateByPrimaryKeySelective(activitysServices);
	}

	@Override
	public ActivitysServices queryActivitysServicesByActivitysServicesExample(ActivitysServicesExample example) {
		List<ActivitysServices> activitysServicesList = activitysServicesMapper.selectByExample(example);
		if(activitysServicesList.size()>0){
			return activitysServicesList.get(0);
		}
		return  null;
	}

	@Override
	public ActivitysCoupons queryActivitysCouponsByActivitysCouponsExample(ActivitysCouponsExample example) {
		List<ActivitysCoupons> activitysCouponsList= activitysCouponsMapper.selectByExample(example);
		if(activitysCouponsList.size()>0){
			return activitysCouponsList.get(0);
		}
		return  null;
	}

	@Transactional
	@Override
	public boolean saveActivitysDetail(final EnterActivitysVo vo) throws RuntimeException {
		 Activitys activitys =  vo.getActivitys();
		 List<ActivitysCoupons>  activitysCouponsList =  vo.getActivitysCouponsList();
		 List<ActivitysServices> activitysServicesList =  vo.getActivitysServicesList();
		 List<ActivitysBeauty> activitysBeauticianList = vo.getActivitysBeauticianList();
		
		 final Long creatTime = System.currentTimeMillis()/1000;
		 final Integer creatTimeInt = creatTime.intValue();
		 activitys.setCreatetime(creatTimeInt);
		 activitysMapper.insertSelective(activitys);
		 final Integer activitysId = activitys.getId();
		if(activitysServicesList!=null && !activitysServicesList.isEmpty()){
			for (ActivitysServices activitysServices : activitysServicesList) {
				 activitysServices.setActivityId(activitysId);
				 activitysServices.setState(Byte.valueOf("1"));
				 activitysServices.setCreatetime(creatTimeInt);
			 }
			 activitysServicesMapper.insertBatch(activitysServicesList);
		}
        if(activitysCouponsList!=null && !activitysCouponsList.isEmpty()){
        	for (ActivitysCoupons activitysCoupons : activitysCouponsList) {
        		activitysCoupons.setActivityId(activitysId);
			}
        	activitysCouponsMapper.insertBatch(activitysCouponsList);
		}
        if(activitysBeauticianList!=null&&!activitysBeauticianList.isEmpty()){
        	for (ActivitysBeauty activitysBeauty : activitysBeauticianList) {
        		activitysBeauty.setActivityId(activitysId);
        		activitysBeauty.setState(Byte.valueOf("1"));
        		activitysBeauty.setCreatetime(creatTimeInt);
			}
        	activitysBeautyMapper.insertBatch(activitysBeauticianList);
        }
		return true;
	}

	@Transactional
	@Override
	public boolean modifyActivitysDetail(EnterActivitysVo vo) throws RuntimeException {
		Activitys newActivitys = vo.getActivitys();
		Integer newActivitysId = newActivitys.getId();
		if(newActivitys==null||newActivitysId==null){
			return false;
		}
		Activitys dbActivitys = activitysMapper.selectByPrimaryKey(newActivitysId);
		if(dbActivitys==null){
			return false;
		}
		ActivitysCouponsExample example = new ActivitysCouponsExample();
		ActivitysCouponsExample.Criteria criteriaActivitysCoupons = example.createCriteria();
		criteriaActivitysCoupons.andActivityIdEqualTo(newActivitysId);
		List<ActivitysCoupons> dbActivitysCouponsList = activitysCouponsMapper.selectByExample(example);
		boolean havedbActivitysCouponsList = dbActivitysCouponsList==null||dbActivitysCouponsList.isEmpty()?false:true;
		
		
		ActivitysServicesExample activitysServicesExample = new ActivitysServicesExample();
		ActivitysServicesExample.Criteria criteria= activitysServicesExample.createCriteria();
		criteria.andActivityIdEqualTo(newActivitysId);
		criteria.andStateEqualTo(Byte.valueOf("1"));
		
		List<ActivitysServices> dbActivitysServicesList = activitysServicesMapper.selectByExample(activitysServicesExample);
		boolean havedbActivitysServicesList = dbActivitysServicesList==null||dbActivitysServicesList.isEmpty()?false:true;
		
		final  Long createtime = System.currentTimeMillis()/1000;
			  List<ActivitysCoupons> newActivitysCouponsList = vo.getActivitysCouponsList();
			  boolean haveNewActivitysCouponsList = newActivitysCouponsList!=null&&newActivitysCouponsList.size()>0?true:false;
			  //如果有新增
			if(!havedbActivitysCouponsList&&haveNewActivitysCouponsList){
				    for (ActivitysCoupons activitysCoupons : newActivitysCouponsList) {
				    	activitysCoupons.setActivityId(newActivitysId);
					}
					activitysCouponsMapper.insertBatch(newActivitysCouponsList);
					newActivitysCouponsList = null;
			}else if(haveNewActivitysCouponsList){
				
					Map<Integer,ActivitysCoupons> dbActivitysCouponsMap = new HashMap<Integer,ActivitysCoupons>();
					for (ActivitysCoupons activitysCoupons : dbActivitysCouponsList) {
						  dbActivitysCouponsMap.put(activitysCoupons.getId(), activitysCoupons);
					}
					
					List<ActivitysCoupons> newAddActivitysCoupons = new ArrayList<ActivitysCoupons>();
					List<ActivitysCoupons> delActivitysCoupons = new ArrayList<ActivitysCoupons>();
					Map<Integer,ActivitysCoupons> intersectionActivitysCouponsMap =  new HashMap<Integer,ActivitysCoupons>();
					 for (ActivitysCoupons activitysCoupons : newActivitysCouponsList) {
						   Integer key = activitysCoupons.getId();
						   if(key==null){
							   activitysCoupons.setActivityId(newActivitysId);
							   newAddActivitysCoupons.add(activitysCoupons);
							   continue;
						   }
						   if(dbActivitysCouponsMap.containsKey(key)){
							   intersectionActivitysCouponsMap.put(key, activitysCoupons);
						   }
					    }
					 for(Map.Entry<Integer,ActivitysCoupons>tempObj:dbActivitysCouponsMap.entrySet()){
						 Integer key = tempObj.getKey();
						 if(!intersectionActivitysCouponsMap.containsKey(key)){
							 delActivitysCoupons.add(tempObj.getValue());
						 }
					 }
					
					 if(!newAddActivitysCoupons.isEmpty()){
						 activitysCouponsMapper.insertBatch(newAddActivitysCoupons);
					 }
					 if(!delActivitysCoupons.isEmpty()){
						 activitysExtMapper.deleteActivitysCouponsByIdBath(delActivitysCoupons);
					 }
					 newAddActivitysCoupons = null;
					 delActivitysCoupons = null;
					 dbActivitysCouponsMap = null;
			}
			
			List<ActivitysServices> newActivitysServicesList = vo.getActivitysServicesList();
			boolean haveNewActivitysServicesList = newActivitysServicesList!=null&&newActivitysServicesList.size()>0?true:false;
			 
			if(!havedbActivitysServicesList&&haveNewActivitysServicesList){
				 for (ActivitysServices activitysServices : newActivitysServicesList) {
					  activitysServices.setCreatetime(createtime.intValue());
					  activitysServices.setState(Byte.valueOf("1"));
					  activitysServices.setActivityId(newActivitysId);
				 }
					activitysServicesMapper.insertBatch(newActivitysServicesList);
					newActivitysServicesList = null;
			}else if(haveNewActivitysServicesList){
				
					Map<Integer,ActivitysServices> dbActivitysServicesMap = new HashMap<Integer,ActivitysServices>();
					for (ActivitysServices activitysServices : dbActivitysServicesList) {
						 dbActivitysServicesMap.put(activitysServices.getId(), activitysServices);
					}
					  List<ActivitysServices> newAddActivitysServices = new ArrayList<ActivitysServices>();
					  
					  List<ActivitysServices> delActivitysServices = new ArrayList<ActivitysServices>();
					  
					  
					  Map<Integer,ActivitysServices> intersectionActivitysServicesMap = new HashMap<Integer,ActivitysServices>();
					  
					  for (ActivitysServices activitysServices : newActivitysServicesList) {
						  Integer key2 = activitysServices.getId();
						  if(key2==null){
							  activitysServices.setCreatetime(createtime.intValue());
							  activitysServices.setState(Byte.valueOf("1"));
							  activitysServices.setActivityId(newActivitysId);
							  newAddActivitysServices.add(activitysServices);
							  continue;
						  }
						  if(dbActivitysServicesMap.containsKey(key2)){
							  intersectionActivitysServicesMap.put(key2, activitysServices);
						  } 
					 }
					  
					 for(Map.Entry<Integer,ActivitysServices> tempObj:dbActivitysServicesMap.entrySet()){
						  Integer key = tempObj.getKey();
						  if(!intersectionActivitysServicesMap.containsKey(key)){
							  delActivitysServices.add(tempObj.getValue());
						  }
					  }
					 
					  if(!delActivitysServices.isEmpty()){
						  activitysExtMapper.updateActivitysServicesByIdBath(delActivitysServices);
					   }
					  if(!newAddActivitysServices.isEmpty()){
						  activitysServicesMapper.insertBatch(newAddActivitysServices);
					  }
					  
					 delActivitysServices = null;
					 newAddActivitysServices = null;
					 dbActivitysServicesMap = null;
			}
			
			List<ActivitysBeauty> newActivitysBeautyList = vo.getActivitysBeauticianList();
			boolean haveNewActivitysBeauticianList = newActivitysBeautyList==null||newActivitysBeautyList.isEmpty()?false:true;
			ActivitysBeautyExample activitysBeauticianExample = new ActivitysBeautyExample();
			activitysBeauticianExample.createCriteria().andActivityIdEqualTo(newActivitysId)//
			.andStateEqualTo(Byte.valueOf("1"));//
			List<ActivitysBeauty> dbActivitysBeautyList = activitysBeautyMapper.selectByExample(activitysBeauticianExample);
			boolean haveDbActivitysBeauticianList = dbActivitysBeautyList==null||dbActivitysBeautyList.isEmpty()?false:true;
			if(!haveDbActivitysBeauticianList&&haveNewActivitysBeauticianList){
				 for (ActivitysBeauty activitysBeauty : newActivitysBeautyList) {
					 activitysBeauty.setCreatetime(createtime.intValue());
					 activitysBeauty.setState(Byte.valueOf("1"));
					 activitysBeauty.setActivityId(newActivitysId);
				  }
				    activitysBeautyMapper.insertBatch(newActivitysBeautyList);
					newActivitysServicesList = null;
			}else if(haveNewActivitysBeauticianList){
				Map<Integer,ActivitysBeauty> dbActivitysBeautyMap = new HashMap<Integer,ActivitysBeauty>();
				for (ActivitysBeauty activitysBeauty : dbActivitysBeautyList) {
					dbActivitysBeautyMap.put(activitysBeauty.getId(), activitysBeauty);
				}
				
				 List<ActivitysBeauty> delActivitysBeauty = new ArrayList<>();
				 List<ActivitysBeauty> newAddActivitysBeauty= new ArrayList<>();
				 
				 Map<Integer,ActivitysBeauty> intersectionActivitysBeautyMap = new HashMap<Integer,ActivitysBeauty>();
				 
				 for (ActivitysBeauty activitysBeauty : newActivitysBeautyList) {
					  Integer key3 = activitysBeauty.getId();
					  if(key3==null){
						  activitysBeauty.setCreatetime(createtime.intValue());
						  activitysBeauty.setState(Byte.valueOf("1"));
						  activitysBeauty.setActivityId(newActivitysId);
						  newAddActivitysBeauty.add(activitysBeauty);
						  continue;
					  }
					if(dbActivitysBeautyMap.containsKey(key3)){
						intersectionActivitysBeautyMap.put(key3, activitysBeauty);
					 } 
				 }
				 for(Map.Entry<Integer,ActivitysBeauty> tempObj :dbActivitysBeautyMap.entrySet()){
					 Integer key = tempObj.getKey();
					if(!intersectionActivitysBeautyMap.containsKey(key)){
						delActivitysBeauty.add(tempObj.getValue());
					 }
				 }
				 if(!newAddActivitysBeauty.isEmpty()){
					 activitysBeautyMapper.insertBatch(newAddActivitysBeauty);
				 }
				 if(!delActivitysBeauty.isEmpty()){
					  activitysExtMapper.updateActivitysBeautyByIdBath(delActivitysBeauty);
				   }
				 newActivitysBeautyList = null;
				 delActivitysBeauty = null;
			}
			activitysMapper.updateByPrimaryKeySelective(newActivitys);
			newActivitys = null;
		return true;
	}

	@Override
	public List<ActivitysBeautyVo> queryActivitysBeautyVoListByActivitysId(Integer activitysId) {
		return activitysExtMapper.selectActivitysBeautyVoListByActivitysId(activitysId);
	}
}