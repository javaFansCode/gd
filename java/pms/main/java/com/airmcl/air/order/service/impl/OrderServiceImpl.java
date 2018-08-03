package com.airmcl.air.order.service.impl;

import com.airmcl.air.order.dao.OrderMapper;
import com.airmcl.air.order.entity.Order;
import com.airmcl.air.order.entity.OrderExample;
import com.airmcl.air.order.service.OrderService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultOrderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    protected OrderMapper orderMapper;

    @CacheEvict(value={"order"}, allEntries=true)
    @Override
    public void addObj(Order t) {
        this.orderMapper.insertSelective(t);
    }

    @CacheEvict(value={"order"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.orderMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"order"}, allEntries=true)
    @Override
    public void modifyObj(Order t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.orderMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="order", keyGenerator="redisKeyGenerator")
    @Override
    public Order queryObjById(Integer id) {
        return this.orderMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="order", key="'OrderService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Order> queryAllObjByExample(OrderExample example) {
        return this.orderMapper.selectByExample(example);
    }

    @Cacheable(value="order", key="'OrderService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Order> queryObjByPage(OrderExample example) {
        PageView<Order> pageView = example.getPageView();
        pageView.setQueryResult(this.orderMapper.selectByExampleByPage(example));
        return pageView;
    }
}