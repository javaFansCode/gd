package com.airmcl.air.service.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.airmcl.air.service.dao.ServiceTypeMapper;
import com.airmcl.air.service.dao.ext.ServiceTypeExtMapper;
import com.airmcl.air.service.entity.ServiceType;
import com.airmcl.air.service.entity.ServiceTypeExample;
import com.airmcl.air.service.service.ServiceTypeService;
import com.els.base.core.entity.PageView;

@Service("defaultServiceTypeService")
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Resource
    protected ServiceTypeMapper serviceTypeMapper;
    @Resource
    protected ServiceTypeExtMapper serviceTypeExtMapper;

    @CacheEvict(value={"serviceType"}, allEntries=true)
    @Override
    public void addObj(ServiceType t) {
        this.serviceTypeMapper.insertSelective(t);
    }

    @CacheEvict(value={"serviceType"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.serviceTypeMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"serviceType"}, allEntries=true)
    @Override
    public void modifyObj(ServiceType t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 不能为空");
        }
        this.serviceTypeMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="serviceType", keyGenerator="redisKeyGenerator")
    @Override
    public ServiceType queryObjById(Integer id) {
        return this.serviceTypeMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="serviceType", key="'ServiceTypeService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ServiceType> queryAllObjByExample(ServiceTypeExample example) {
        return this.serviceTypeMapper.selectByExample(example);
    }

    @Cacheable(value="serviceType", key="'ServiceTypeService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ServiceType> queryObjByPage(ServiceTypeExample example) {
        PageView<ServiceType> pageView = example.getPageView();
        pageView.setQueryResult(this.serviceTypeMapper.selectByExampleByPage(example));
        return pageView;
    }

	@Override
	public List<ServiceType> queryAllServiceType() {
		return serviceTypeExtMapper.selectServiceTypes();
	}
}