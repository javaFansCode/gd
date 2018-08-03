package com.airmcl.air.exchange.service.impl;

import com.airmcl.air.exchange.dao.ExchangeCodeRecordMapper;
import com.airmcl.air.exchange.entity.ExchangeCodeRecord;
import com.airmcl.air.exchange.entity.ExchangeCodeRecordExample;
import com.airmcl.air.exchange.service.ExchangeCodeRecordService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultExchangeCodeRecordService")
public class ExchangeCodeRecordServiceImpl implements ExchangeCodeRecordService {
    @Resource
    protected ExchangeCodeRecordMapper exchangeCodeRecordMapper;

    @CacheEvict(value={"exchangeCodeRecord"}, allEntries=true)
    @Override
    public void addObj(ExchangeCodeRecord t) {
        this.exchangeCodeRecordMapper.insertSelective(t);
    }

    @CacheEvict(value={"exchangeCodeRecord"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.exchangeCodeRecordMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"exchangeCodeRecord"}, allEntries=true)
    @Override
    public void modifyObj(ExchangeCodeRecord t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.exchangeCodeRecordMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="exchangeCodeRecord", keyGenerator="redisKeyGenerator")
    @Override
    public ExchangeCodeRecord queryObjById(Integer id) {
        return this.exchangeCodeRecordMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="exchangeCodeRecord", key="'ExchangeCodeRecordService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ExchangeCodeRecord> queryAllObjByExample(ExchangeCodeRecordExample example) {
        return this.exchangeCodeRecordMapper.selectByExample(example);
    }

    @Cacheable(value="exchangeCodeRecord", key="'ExchangeCodeRecordService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ExchangeCodeRecord> queryObjByPage(ExchangeCodeRecordExample example) {
        PageView<ExchangeCodeRecord> pageView = example.getPageView();
        pageView.setQueryResult(this.exchangeCodeRecordMapper.selectByExampleByPage(example));
        return pageView;
    }
}