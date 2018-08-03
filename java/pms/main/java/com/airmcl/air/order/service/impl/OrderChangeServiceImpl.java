package com.airmcl.air.order.service.impl;

import com.airmcl.air.order.dao.OrderChangeMapper;
import com.airmcl.air.order.entity.OrderChange;
import com.airmcl.air.order.entity.OrderChangeExample;
import com.airmcl.air.order.service.OrderChangeService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultOrderChangeService")
public class OrderChangeServiceImpl implements OrderChangeService {
    @Resource
    protected OrderChangeMapper orderChangeMapper;

    @CacheEvict(value={"orderChange"}, allEntries=true)
    @Override
    public void addObj(OrderChange t) {
        this.orderChangeMapper.insertSelective(t);
    }

    @CacheEvict(value={"orderChange"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.orderChangeMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"orderChange"}, allEntries=true)
    @Override
    public void modifyObj(OrderChange t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.orderChangeMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="orderChange", keyGenerator="redisKeyGenerator")
    @Override
    public OrderChange queryObjById(Integer id) {
        return this.orderChangeMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="orderChange", key="'OrderChangeService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<OrderChange> queryAllObjByExample(OrderChangeExample example) {
        return this.orderChangeMapper.selectByExample(example);
    }

    @Cacheable(value="orderChange", key="'OrderChangeService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<OrderChange> queryObjByPage(OrderChangeExample example) {
        PageView<OrderChange> pageView = example.getPageView();
        pageView.setQueryResult(this.orderChangeMapper.selectByExampleByPage(example));
        return pageView;
    }
}