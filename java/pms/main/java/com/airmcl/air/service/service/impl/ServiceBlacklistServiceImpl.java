package com.airmcl.air.service.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.airmcl.air.service.dao.ServiceBlacklistMapper;
import com.airmcl.air.service.entity.ServiceBlacklist;
import com.airmcl.air.service.entity.ServiceBlacklistExample;
import com.airmcl.air.service.service.ServiceBlacklistService;
import com.els.base.core.entity.PageView;

@Service("defaultServiceBlacklistService")
public class ServiceBlacklistServiceImpl implements ServiceBlacklistService {
    @Resource
    protected ServiceBlacklistMapper serviceBlacklistMapper;

    @CacheEvict(value={"serviceBlacklist"}, allEntries=true)
    @Override
    public void addObj(ServiceBlacklist t) {
        this.serviceBlacklistMapper.insertSelective(t);
    }

    @CacheEvict(value={"serviceBlacklist"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.serviceBlacklistMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"serviceBlacklist"}, allEntries=true)
    @Override
    public void modifyObj(ServiceBlacklist t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.serviceBlacklistMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="serviceBlacklist", keyGenerator="redisKeyGenerator")
    @Override
    public ServiceBlacklist queryObjById(Integer id) {
        return this.serviceBlacklistMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="serviceBlacklist", key="'ServiceBlacklistService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ServiceBlacklist> queryAllObjByExample(ServiceBlacklistExample example) {
        return this.serviceBlacklistMapper.selectByExample(example);
    }

    @Cacheable(value="serviceBlacklist", key="'ServiceBlacklistService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ServiceBlacklist> queryObjByPage(ServiceBlacklistExample example) {
        PageView<ServiceBlacklist> pageView = example.getPageView();
        pageView.setQueryResult(this.serviceBlacklistMapper.selectByExampleByPage(example));
        return pageView;
    }
}