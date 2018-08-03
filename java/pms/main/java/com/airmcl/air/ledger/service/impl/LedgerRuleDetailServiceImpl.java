package com.airmcl.air.ledger.service.impl;

import com.airmcl.air.ledger.dao.LedgerRuleDetailMapper;
import com.airmcl.air.ledger.entity.LedgerRuleDetail;
import com.airmcl.air.ledger.entity.LedgerRuleDetailExample;
import com.airmcl.air.ledger.service.LedgerRuleDetailService;
import com.els.base.core.entity.PageView;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Deprecated
@Service("defaultLedgerRuleDetailService")
public class LedgerRuleDetailServiceImpl implements LedgerRuleDetailService {
    @Resource
    protected LedgerRuleDetailMapper ledgerRuleDetailMapper;

    @CacheEvict(value={"ledgerRuleDetail"}, allEntries=true)
    @Override
    public void addObj(LedgerRuleDetail t) {
        this.ledgerRuleDetailMapper.insertSelective(t);
    }

    @CacheEvict(value={"ledgerRuleDetail"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.ledgerRuleDetailMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"ledgerRuleDetail"}, allEntries=true)
    @Override
    public void modifyObj(LedgerRuleDetail t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.ledgerRuleDetailMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="ledgerRuleDetail", keyGenerator="redisKeyGenerator")
    @Override
    public LedgerRuleDetail queryObjById(String id) {
        return this.ledgerRuleDetailMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="ledgerRuleDetail", key="'LedgerRuleDetailService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<LedgerRuleDetail> queryAllObjByExample(LedgerRuleDetailExample example) {
        return this.ledgerRuleDetailMapper.selectByExample(example);
    }

    @Cacheable(value="ledgerRuleDetail", key="'LedgerRuleDetailService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<LedgerRuleDetail> queryObjByPage(LedgerRuleDetailExample example) {
        PageView<LedgerRuleDetail> pageView = example.getPageView();
        pageView.setQueryResult(this.ledgerRuleDetailMapper.selectByExampleByPage(example));
        return pageView;
    }
}