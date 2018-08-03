package com.airmcl.air.service.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.air.beautician.dao.BeauticianRelationsMapper;
import com.airmcl.air.beautician.entity.BeauticianRelations;
import com.airmcl.air.beautician.entity.BeauticianRelationsExample;
import com.airmcl.air.beauty.dao.BeautyRelationsMapper;
import com.airmcl.air.beauty.entity.BeautyRelations;
import com.airmcl.air.beauty.entity.BeautyRelationsExample;
import com.airmcl.air.service.dao.ServiceCityMapper;
import com.airmcl.air.service.dao.ServiceExtendMapper;
import com.airmcl.air.service.dao.ServiceMapper;
import com.airmcl.air.service.dao.ServicePackageMapper;
import com.airmcl.air.service.dao.ext.ServiceExtMapper;
import com.airmcl.air.service.dao.ext.ServiceExtendExtMapper;
import com.airmcl.air.service.entity.Service;
import com.airmcl.air.service.entity.ServiceCity;
import com.airmcl.air.service.entity.ServiceExample;
import com.airmcl.air.service.entity.ServiceExtend;
import com.airmcl.air.service.entity.ServiceIdNameCover;
import com.airmcl.air.service.entity.ServicePackage;
import com.airmcl.air.service.entity.ServiceVo;
import com.airmcl.air.service.service.ServiceService;
import com.airmcl.basae.utils.DateUtil;
import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.utils.encryption.Md5Utils;

@org.springframework.stereotype.Service("defaultServiceService")
public class ServiceServiceImpl implements ServiceService {
    @Resource
    protected ServiceMapper serviceMapper;
    @Resource
    protected ServicePackageMapper servicePackageMapper ;
    @Resource
    protected ServiceExtMapper serviceExtMapper;
    @Resource
    protected ServiceExtendMapper serviceExtendMapper;
    @Resource
    protected ServiceExtendExtMapper serviceExtendExtMapper;
    @Resource
    protected ServiceCityMapper serviceCityMapper;
    
    @Resource
    protected  BeautyRelationsMapper beautyRelationsMapper;
   
    @Resource
    protected BeauticianRelationsMapper beauticianRelationsMapper;
    
    @CacheEvict(value={"service"}, allEntries=true)
    @Override
    public void addObj(Service t) {
        this.serviceMapper.insertSelective(t);
    }

    @CacheEvict(value={"service"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.serviceMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"service"}, allEntries=true)
    @Override
    public void modifyObj(Service t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.serviceMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="service", keyGenerator="redisKeyGenerator")
    @Override
    public Service queryObjById(Integer id) {
        return this.serviceMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="service", key="'ServiceService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Service> queryAllObjByExample(ServiceExample example) {
        return this.serviceMapper.selectByExample(example);
    }

    @Cacheable(value="service", key="'ServiceService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Service> queryObjByPage(ServiceExample example) {
        PageView<Service> pageView = example.getPageView();
        pageView.setQueryResult(this.serviceMapper.selectByExampleByPage(example));
        return pageView;
    }

	@Override
	public int saveServicePackage(List<ServicePackage> servicePackages) {
		int rt = 0;
		if(servicePackages==null||servicePackages.isEmpty()){
			return rt;
		}
		rt=servicePackageMapper.insertBatch(servicePackages);
		return rt ;
	}
	@Override
	public List<ServicePackage> queryServicePackageByServiceId(Integer serviceId) {
		return servicePackageMapper.selectAllServicePackagesByServiceId(serviceId);
	}

	@Override
	public int modifyServicePackage(ServicePackage servicePackage) {
		return servicePackageMapper.updateServicePackage(servicePackage);
	}

	@Override
	public List<Service> querySingleService() {
		return serviceExtMapper.selectAllSingleService();
	}

	@Override
	public int delAllServicePackage(Integer serviceId) {
		return servicePackageMapper.delServicePackageByPackageId(serviceId);
	}

	@Transactional
	@Override
	public boolean saveServiceDetail(ServiceVo serviceVo) throws RuntimeException {
		Service service = serviceVo.getService();
		Long time = System.currentTimeMillis()/1000;
    	service.setCreatetime(time.intValue());
    	this.serviceMapper.insertSelective(service);
    	ServiceExtend serviceExtend =serviceVo.getServiceExtend();
    	if(serviceExtend!=null){
    		serviceExtend.setCreatetime(DateUtil.getTime());
       	    if(service.getIsPackage()!=null&&service.getIsPackage()==2){
            	  List<ServicePackage>	servicePackages = serviceVo.getAllSelectService();
            	  if(servicePackages!=null&&!servicePackages.isEmpty()){
            		 for(ServicePackage sp : servicePackages){
            			 if(sp.getBeautyId()==null){
            				 sp.setBeautyId(0);
            			 }
               		     sp.setPackageId(service.getId());
               	  }
            		servicePackageMapper.insertBatch(servicePackages);
            	  }
            	}
       	 serviceExtend.setServiceId(service.getId());
       	 serviceExtendMapper.insertSelective(serviceExtend);
    	}
		 return true;
	}

	@Transactional
	@Override
	public boolean modifyServiceDetail(ServiceVo serviceVo,Service oldService) throws RuntimeException {
		 Service service= serviceVo.getService();
		 Integer serviceId = service.getId();
		 //原来的是套餐
		if(oldService.getIsPackage()==2){
	    	List<ServicePackage> newServicePackage = serviceVo.getAllSelectService();
	    	List<ServicePackage> servicePackages = servicePackageMapper.selectAllServicePackagesByServiceId(serviceId);
	    	if(newServicePackage==null||newServicePackage.isEmpty()){
	    		if(servicePackages!=null&&!servicePackages.isEmpty()){
	    			servicePackageMapper.delServicePackageByPackageId(serviceId);
	    		}
	    	}else{
	    		 for(ServicePackage sp:newServicePackage){
	    			 if(sp.getBeautyId()==null){
	    				 sp.setBeautyId(0);
	    			 }
	    			 sp.setPackageId(serviceId);
	    		 }
	    		 servicePackageMapper.delServicePackageByPackageId(serviceId);
	    		 servicePackageMapper.insertBatch(newServicePackage);
	    	}
        }
		//服务项目的扩展信息
		ServiceExtend serviceExtend = serviceVo.getServiceExtend();
		ServiceExtend oldserviceExtend =serviceExtendExtMapper.selectByServiceId(serviceId);
		//项目简介
        String serviceDesc = oldserviceExtend.getServiceDesc();
        String newServiceDesc = serviceExtend.getServiceDesc();
        if(isSame(serviceDesc, newServiceDesc)){
        	serviceExtend.setServiceDesc(null);
        }
        //服务步骤
        String serviceStep = oldserviceExtend.getServiceStep();
        String newServiceStep = serviceExtend.getServiceStep();
        if(isSame(serviceStep, newServiceStep)){
        	serviceExtend.setServiceStep(null);
        }
        //适用人群
        String peopleUse   = oldserviceExtend.getPeopleUse();
        String newPeopleUse   =serviceExtend.getPeopleUse();
        if(isSame(peopleUse, newPeopleUse)){
        	serviceExtend.setPeopleUse(null);
        }
        //注意事项
        String note = oldserviceExtend.getNote();
        String newNote = serviceExtend.getNote();
        if(isSame(note, newNote)){
        	serviceExtend.setNote(null);
        }
        serviceMapper.updateByPrimaryKeySelective(service);
        serviceExtendMapper.updateByPrimaryKeySelective(serviceExtend);
		return true;
	}
	private boolean isSame(String oldString,String newString){
   	 if(oldString!=null&&newString!=null){
   		 try {
  			  String oldMd5 = Md5Utils.md5Encode(oldString);
  			  String newMd5 = Md5Utils.md5Encode(newString);
  			  if(newMd5.equals(oldMd5)){
  				  return true;
  			  }
  			} catch (NoSuchAlgorithmException e) {
  				throw new CommonException("数据错误");
  			} catch (UnsupportedEncodingException e) {
  				throw new CommonException("数据错误");
  			}
   	 }
   	 return false;
    }

	@Transactional
	@Override
	public boolean modifyServiceCities(List<ServiceCity> addCitys, List<ServiceCity> updateCitys) throws RuntimeException {
		if(!updateCitys.isEmpty()){
    		for(ServiceCity updateCity:updateCitys){
    			serviceCityMapper.updateByPrimaryKeySelective(updateCity);
    		}
    	}
    	if(!addCitys.isEmpty()){
    			serviceCityMapper.insertBatch(addCitys);
    	}
		return true;
	}

	@Override
	public List<ServiceIdNameCover> queryServiceInfo(List<Integer> ids) {
		return serviceExtMapper.selectServiceIdNameCoverByServiceIds(ids);
	}

	@Transactional
	@Override
	public int updateService(Service service) throws RuntimeException {
		int result = 0;
		int beauticianRelationResult = 0;
		//下架或者删除
		if(service.getState()==0||service.getState()==2){
			BeautyRelationsExample example = new BeautyRelationsExample();
			example.createCriteria().andRelationIdEqualTo(service.getId())//
			.andStateEqualTo((byte)1).andTypeEqualTo((byte)1);//
			List<BeautyRelations> beautyRelationsList =beautyRelationsMapper.selectByExample(example);
			if(beautyRelationsList!=null&&beautyRelationsList.size()>0){
				  BeautyRelations beautyRelationsTemp = new BeautyRelations();
				  beautyRelationsTemp.setState((byte)0);
				  result = beautyRelationsMapper.updateByExampleSelective(beautyRelationsTemp, example);
			}
			BeauticianRelationsExample beauticianRelationsExample = new BeauticianRelationsExample();
			beauticianRelationsExample.createCriteria().//
			andServiceIdEqualTo(service.getId()).//
			andStateEqualTo((byte)1);
			List<BeauticianRelations> beauticianRelationsList = beauticianRelationsMapper.selectByExample(beauticianRelationsExample);
			if(beauticianRelationsList!=null&&beauticianRelationsList.size()>0){
				BeauticianRelations tempBeauticianRelations = new BeauticianRelations();
				tempBeauticianRelations.setState((byte)0);
				beauticianRelationResult = beauticianRelationsMapper.updateByExampleSelective(tempBeauticianRelations, beauticianRelationsExample);
			}
		//上架
		}else if(service.getState()==1){
			BeautyRelationsExample example2 = new BeautyRelationsExample();
			example2.createCriteria().andRelationIdEqualTo(service.getId())//
			.andStateEqualTo((byte)0).andTypeEqualTo((byte)1);//
			//获取删除的关系
			List<BeautyRelations> beautyRelationsList2 =beautyRelationsMapper.selectByExample(example2);
			if(beautyRelationsList2!=null&&beautyRelationsList2.size()>0){
				  BeautyRelations beautyRelationsTemp2 = new BeautyRelations();
				  beautyRelationsTemp2.setState((byte)1);
				  //改为上架
				  result = beautyRelationsMapper.updateByExampleSelective(beautyRelationsTemp2, example2);
			}
			BeauticianRelationsExample beauticianRelationsExample = new BeauticianRelationsExample();
			beauticianRelationsExample.createCriteria().//
			andServiceIdEqualTo(service.getId()).//
			andStateEqualTo((byte)0);
			List<BeauticianRelations> beauticianRelationsList = beauticianRelationsMapper.selectByExample(beauticianRelationsExample);
			if(beauticianRelationsList!=null&&beauticianRelationsList.size()>0){
				BeauticianRelations tempBeauticianRelations = new BeauticianRelations();
				tempBeauticianRelations.setState((byte)1);
				beauticianRelationResult = beauticianRelationsMapper.updateByExampleSelective(tempBeauticianRelations, beauticianRelationsExample);
			}
		}
		int serviveResult = serviceMapper.updateByPrimaryKeySelective(service);
		result = result+serviveResult+beauticianRelationResult;
		return result;
	} 
}