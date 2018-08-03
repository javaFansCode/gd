package com.airmcl.air.service.service.impl;

import com.airmcl.air.service.dao.ServicesHomeBuyRecordMapper;
import com.airmcl.air.service.entity.ServicesHomeBuyRecord;
import com.airmcl.air.service.entity.ServicesHomeBuyRecordExample;
import com.airmcl.air.service.service.ServicesHomeBuyRecordService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultServicesHomeBuyRecordService")
public class ServicesHomeBuyRecordServiceImpl implements ServicesHomeBuyRecordService {
    @Resource
    protected ServicesHomeBuyRecordMapper servicesHomeBuyRecordMapper;

    @CacheEvict(value={"servicesHomeBuyRecord"}, allEntries=true)
    @Override
    public void addObj(ServicesHomeBuyRecord t) {
        this.servicesHomeBuyRecordMapper.insertSelective(t);
    }

    @CacheEvict(value={"servicesHomeBuyRecord"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.servicesHomeBuyRecordMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"servicesHomeBuyRecord"}, allEntries=true)
    @Override
    public void modifyObj(ServicesHomeBuyRecord t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.servicesHomeBuyRecordMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="servicesHomeBuyRecord", keyGenerator="redisKeyGenerator")
    @Override
    public ServicesHomeBuyRecord queryObjById(Integer id) {
        return this.servicesHomeBuyRecordMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="servicesHomeBuyRecord", key="'ServicesHomeBuyRecordService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ServicesHomeBuyRecord> queryAllObjByExample(ServicesHomeBuyRecordExample example) {
        return this.servicesHomeBuyRecordMapper.selectByExample(example);
    }

    @Cacheable(value="servicesHomeBuyRecord", key="'ServicesHomeBuyRecordService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ServicesHomeBuyRecord> queryObjByPage(ServicesHomeBuyRecordExample example) {
        PageView<ServicesHomeBuyRecord> pageView = example.getPageView();
        pageView.setQueryResult(this.servicesHomeBuyRecordMapper.selectByExampleByPage(example));
        return pageView;
    }
}