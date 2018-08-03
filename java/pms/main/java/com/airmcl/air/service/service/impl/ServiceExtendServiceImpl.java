package com.airmcl.air.service.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.airmcl.air.service.dao.ServiceExtendMapper;
import com.airmcl.air.service.dao.ext.ServiceExtendExtMapper;
import com.airmcl.air.service.entity.ServiceExtend;
import com.airmcl.air.service.entity.ServiceExtendExample;
import com.airmcl.air.service.service.ServiceExtendService;
import com.els.base.core.entity.PageView;

@Service("defaultServiceExtendService")
public class ServiceExtendServiceImpl implements ServiceExtendService {
    @Resource
    protected ServiceExtendMapper serviceExtendMapper;

    @Resource
    protected ServiceExtendExtMapper serviceExtendExtMapper;
    
    @CacheEvict(value={"serviceExtend"}, allEntries=true)
    @Override
    public void addObj(ServiceExtend t) {
        this.serviceExtendMapper.insertSelective(t);
    }

    @CacheEvict(value={"serviceExtend"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.serviceExtendMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"serviceExtend"}, allEntries=true)
    @Override
    public void modifyObj(ServiceExtend t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.serviceExtendMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="serviceExtend", keyGenerator="redisKeyGenerator")
    @Override
    public ServiceExtend queryObjById(Integer id) {
        return this.serviceExtendMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="serviceExtend", key="'ServiceExtendService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ServiceExtend> queryAllObjByExample(ServiceExtendExample example) {
        return this.serviceExtendMapper.selectByExample(example);
    }

    @Cacheable(value="serviceExtend", key="'ServiceExtendService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ServiceExtend> queryObjByPage(ServiceExtendExample example) {
        PageView<ServiceExtend> pageView = example.getPageView();
        pageView.setQueryResult(this.serviceExtendMapper.selectByExampleByPage(example));
        return pageView;
    }

	@Override
	public ServiceExtend queryServiceExtendByServiceId(Integer serviceId) {
		return serviceExtendExtMapper.selectByServiceId(serviceId);
	}
}