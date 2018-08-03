package com.airmcl.air.order.service.impl;

import com.airmcl.air.order.dao.LaunchLedgerMapper;
import com.airmcl.air.order.entity.LaunchLedger;
import com.airmcl.air.order.entity.LaunchLedgerExample;
import com.airmcl.air.order.service.LaunchLedgerService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultLaunchLedgerService")
public class LaunchLedgerServiceImpl implements LaunchLedgerService {
    @Resource
    protected LaunchLedgerMapper launchLedgerMapper;

    @CacheEvict(value={"launchLedger"}, allEntries=true)
    @Override
    public void addObj(LaunchLedger t) {
        this.launchLedgerMapper.insertSelective(t);
    }

    @CacheEvict(value={"launchLedger"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.launchLedgerMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"launchLedger"}, allEntries=true)
    @Override
    public void modifyObj(LaunchLedger t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.launchLedgerMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="launchLedger", keyGenerator="redisKeyGenerator")
    @Override
    public LaunchLedger queryObjById(String id) {
        return this.launchLedgerMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="launchLedger", key="'LaunchLedgerService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<LaunchLedger> queryAllObjByExample(LaunchLedgerExample example) {
        return this.launchLedgerMapper.selectByExample(example);
    }

    @Cacheable(value="launchLedger", key="'LaunchLedgerService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<LaunchLedger> queryObjByPage(LaunchLedgerExample example) {
        PageView<LaunchLedger> pageView = example.getPageView();
        pageView.setQueryResult(this.launchLedgerMapper.selectByExampleByPage(example));
        return pageView;
    }
}