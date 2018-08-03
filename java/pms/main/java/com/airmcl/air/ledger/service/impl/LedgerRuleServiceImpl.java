package com.airmcl.air.ledger.service.impl;

import com.airmcl.air.ledger.dao.LedgerRuleMapper;
import com.airmcl.air.ledger.entity.LedgerRule;
import com.airmcl.air.ledger.entity.LedgerRuleExample;
import com.airmcl.air.ledger.service.LedgerRuleService;
import com.els.base.core.entity.PageView;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Deprecated
@Service("defaultLedgerRuleService")
public class LedgerRuleServiceImpl implements LedgerRuleService {
    @Resource
    protected LedgerRuleMapper ledgerRuleMapper;

    @CacheEvict(value={"ledgerRule"}, allEntries=true)
    @Override
    public void addObj(LedgerRule t) {
        this.ledgerRuleMapper.insertSelective(t);
    }

    @CacheEvict(value={"ledgerRule"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.ledgerRuleMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"ledgerRule"}, allEntries=true)
    @Override
    public void modifyObj(LedgerRule t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.ledgerRuleMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="ledgerRule", keyGenerator="redisKeyGenerator")
    @Override
    public LedgerRule queryObjById(String id) {
        return this.ledgerRuleMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="ledgerRule", key="'LedgerRuleService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<LedgerRule> queryAllObjByExample(LedgerRuleExample example) {
        return this.ledgerRuleMapper.selectByExample(example);
    }

    @Cacheable(value="ledgerRule", key="'LedgerRuleService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<LedgerRule> queryObjByPage(LedgerRuleExample example) {
        PageView<LedgerRule> pageView = example.getPageView();
        pageView.setQueryResult(this.ledgerRuleMapper.selectByExampleByPage(example));
        return pageView;
    }
}