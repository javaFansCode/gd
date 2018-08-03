package com.airmcl.air.service.dao;

import com.airmcl.air.service.entity.ServiceForm;
import com.airmcl.air.service.entity.ServiceFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceFormMapper {
    int countByExample(ServiceFormExample example);

    int deleteByExample(ServiceFormExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceForm record);

    int insertSelective(ServiceForm record);

    List<ServiceForm> selectByExample(ServiceFormExample example);

    ServiceForm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceForm record, @Param("example") ServiceFormExample example);

    int updateByExample(@Param("record") ServiceForm record, @Param("example") ServiceFormExample example);

    int updateByPrimaryKeySelective(ServiceForm record);

    int updateByPrimaryKey(ServiceForm record);

    void insertBatch(List<ServiceForm> list);

    List<ServiceForm> selectByExampleByPage(ServiceFormExample example);
}