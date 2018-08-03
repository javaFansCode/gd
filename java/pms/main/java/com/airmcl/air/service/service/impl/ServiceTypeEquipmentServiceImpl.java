package com.airmcl.air.service.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.air.service.dao.ServiceTypeEquipmentMapper;
import com.airmcl.air.service.dao.ext.ServiceTypeEquipmentExtMapper;
import com.airmcl.air.service.entity.ServiceTypeEquipment;
import com.airmcl.air.service.entity.ServiceTypeEquipmentExample;
import com.airmcl.air.service.service.ServiceTypeEquipmentService;
import com.els.base.core.entity.PageView;

@Service("defaultServiceTypeEquipmentService")
public class ServiceTypeEquipmentServiceImpl implements ServiceTypeEquipmentService {
    @Resource
    protected ServiceTypeEquipmentMapper serviceTypeEquipmentMapper;
    
    @Resource
    ServiceTypeEquipmentExtMapper  serviceTypeEquipmentExtMapper;

    @CacheEvict(value={"serviceTypeEquipment"}, allEntries=true)
    @Override
    public void addObj(ServiceTypeEquipment t) {
        this.serviceTypeEquipmentMapper.insertSelective(t);
    }

    @CacheEvict(value={"serviceTypeEquipment"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.serviceTypeEquipmentMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"serviceTypeEquipment"}, allEntries=true)
    @Override
    public void modifyObj(ServiceTypeEquipment t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 修改的ID不能为空");
        }
        this.serviceTypeEquipmentMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="serviceTypeEquipment", keyGenerator="redisKeyGenerator")
    @Override
    public ServiceTypeEquipment queryObjById(Integer id) {
        return this.serviceTypeEquipmentMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="serviceTypeEquipment", key="'ServiceTypeEquipmentService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ServiceTypeEquipment> queryAllObjByExample(ServiceTypeEquipmentExample example) {
        return this.serviceTypeEquipmentMapper.selectByExample(example);
    }

    @Cacheable(value="serviceTypeEquipment", key="'ServiceTypeEquipmentService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ServiceTypeEquipment> queryObjByPage(ServiceTypeEquipmentExample example) {
        PageView<ServiceTypeEquipment> pageView = example.getPageView();
        pageView.setQueryResult(this.serviceTypeEquipmentMapper.selectByExampleByPage(example));
        return pageView;
    }

	@Override
	public List<ServiceTypeEquipment> queryServiceTypeEquipmentsByServiceTypeId(Integer serviceTypeId) {
		return serviceTypeEquipmentExtMapper.selectServiceTypeEquipmentsByServiceTypeId(serviceTypeId);
	}

	@Transactional(rollbackFor=Exception.class) 
	@Override
	public void updateServiceTypeEquipments(List<ServiceTypeEquipment> newServiceTypeEquipments,List<ServiceTypeEquipment> delServiceTypeEquipments) {
		if(newServiceTypeEquipments!=null&&newServiceTypeEquipments.size()>0){
			for (ServiceTypeEquipment serviceTypeEquipment : newServiceTypeEquipments) {
				this.serviceTypeEquipmentMapper.insertSelective(serviceTypeEquipment);
			}
		}
		
		if(delServiceTypeEquipments!=null&&delServiceTypeEquipments.size()>0){
			for (ServiceTypeEquipment serviceTypeEquipment : delServiceTypeEquipments) {
				this.serviceTypeEquipmentMapper.deleteByPrimaryKey(serviceTypeEquipment.getId());
			}
		}
		
		
		
		
	}
}