package com.airmcl.air.ledger.service.impl;

import com.airmcl.air.ledger.dao.GoodsLedgerRuleMapper;
import com.airmcl.air.ledger.entity.GoodsLedgerRule;
import com.airmcl.air.ledger.entity.GoodsLedgerRuleExample;
import com.airmcl.air.ledger.service.GoodsLedgerRuleService;
import com.els.base.core.entity.PageView;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Deprecated
@Service("defaultGoodsLedgerRuleService")
public class GoodsLedgerRuleServiceImpl implements GoodsLedgerRuleService {
    @Resource
    protected GoodsLedgerRuleMapper goodsLedgerRuleMapper;

    @CacheEvict(value={"goodsLedgerRule"}, allEntries=true)
    @Override
    public void addObj(GoodsLedgerRule t) {
        this.goodsLedgerRuleMapper.insertSelective(t);
    }

    @CacheEvict(value={"goodsLedgerRule"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.goodsLedgerRuleMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"goodsLedgerRule"}, allEntries=true)
    @Override
    public void modifyObj(GoodsLedgerRule t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.goodsLedgerRuleMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="goodsLedgerRule", keyGenerator="redisKeyGenerator")
    @Override
    public GoodsLedgerRule queryObjById(String id) {
        return this.goodsLedgerRuleMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="goodsLedgerRule", key="'GoodsLedgerRuleService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<GoodsLedgerRule> queryAllObjByExample(GoodsLedgerRuleExample example) {
        return this.goodsLedgerRuleMapper.selectByExample(example);
    }

    @Cacheable(value="goodsLedgerRule", key="'GoodsLedgerRuleService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<GoodsLedgerRule> queryObjByPage(GoodsLedgerRuleExample example) {
        PageView<GoodsLedgerRule> pageView = example.getPageView();
        pageView.setQueryResult(this.goodsLedgerRuleMapper.selectByExampleByPage(example));
        return pageView;
    }
}