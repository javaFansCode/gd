package com.airmcl.air.service.service.impl;

import com.airmcl.air.service.dao.ServiceFormMapper;
import com.airmcl.air.service.entity.ServiceForm;
import com.airmcl.air.service.entity.ServiceFormExample;
import com.airmcl.air.service.service.ServiceFormService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultServiceFormService")
public class ServiceFormServiceImpl implements ServiceFormService {
    @Resource
    protected ServiceFormMapper serviceFormMapper;

    @CacheEvict(value={"serviceForm"}, allEntries=true)
    @Override
    public void addObj(ServiceForm t) {
        this.serviceFormMapper.insertSelective(t);
    }

    @CacheEvict(value={"serviceForm"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.serviceFormMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"serviceForm"}, allEntries=true)
    @Override
    public void modifyObj(ServiceForm t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.serviceFormMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="serviceForm", keyGenerator="redisKeyGenerator")
    @Override
    public ServiceForm queryObjById(Integer id) {
        return this.serviceFormMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="serviceForm", key="'ServiceFormService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ServiceForm> queryAllObjByExample(ServiceFormExample example) {
        return this.serviceFormMapper.selectByExample(example);
    }

    @Cacheable(value="serviceForm", key="'ServiceFormService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ServiceForm> queryObjByPage(ServiceFormExample example) {
        PageView<ServiceForm> pageView = example.getPageView();
        pageView.setQueryResult(this.serviceFormMapper.selectByExampleByPage(example));
        return pageView;
    }
}