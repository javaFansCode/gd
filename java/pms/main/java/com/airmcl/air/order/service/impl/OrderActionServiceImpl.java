package com.airmcl.air.order.service.impl;

import com.airmcl.air.order.dao.OrderActionMapper;
import com.airmcl.air.order.entity.OrderAction;
import com.airmcl.air.order.entity.OrderActionExample;
import com.airmcl.air.order.service.OrderActionService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultOrderActionService")
public class OrderActionServiceImpl implements OrderActionService {
    @Resource
    protected OrderActionMapper orderActionMapper;

    @CacheEvict(value={"orderAction"}, allEntries=true)
    @Override
    public void addObj(OrderAction t) {
        this.orderActionMapper.insertSelective(t);
    }

    @CacheEvict(value={"orderAction"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.orderActionMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"orderAction"}, allEntries=true)
    @Override
    public void modifyObj(OrderAction t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.orderActionMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="orderAction", keyGenerator="redisKeyGenerator")
    @Override
    public OrderAction queryObjById(Integer id) {
        return this.orderActionMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="orderAction", key="'OrderActionService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<OrderAction> queryAllObjByExample(OrderActionExample example) {
        return this.orderActionMapper.selectByExample(example);
    }

    @Cacheable(value="orderAction", key="'OrderActionService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<OrderAction> queryObjByPage(OrderActionExample example) {
        PageView<OrderAction> pageView = example.getPageView();
        pageView.setQueryResult(this.orderActionMapper.selectByExampleByPage(example));
        return pageView;
    }
}