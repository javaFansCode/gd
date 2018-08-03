package com.airmcl.air.order.dao;

import com.airmcl.air.order.entity.OrderChange;
import com.airmcl.air.order.entity.OrderChangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderChangeMapper {
    int countByExample(OrderChangeExample example);

    int deleteByExample(OrderChangeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderChange record);

    int insertSelective(OrderChange record);

    List<OrderChange> selectByExample(OrderChangeExample example);

    OrderChange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderChange record, @Param("example") OrderChangeExample example);

    int updateByExample(@Param("record") OrderChange record, @Param("example") OrderChangeExample example);

    int updateByPrimaryKeySelective(OrderChange record);

    int updateByPrimaryKey(OrderChange record);

    void insertBatch(List<OrderChange> list);

    List<OrderChange> selectByExampleByPage(OrderChangeExample example);
}