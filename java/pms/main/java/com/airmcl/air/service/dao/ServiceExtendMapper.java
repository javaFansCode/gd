package com.airmcl.air.service.dao;

import com.airmcl.air.service.entity.ServiceExtend;
import com.airmcl.air.service.entity.ServiceExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceExtendMapper {
    int countByExample(ServiceExtendExample example);

    int deleteByExample(ServiceExtendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceExtend record);

    int insertSelective(ServiceExtend record);

    List<ServiceExtend> selectByExampleWithBLOBs(ServiceExtendExample example);

    List<ServiceExtend> selectByExample(ServiceExtendExample example);

    ServiceExtend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceExtend record, @Param("example") ServiceExtendExample example);

    int updateByExampleWithBLOBs(@Param("record") ServiceExtend record, @Param("example") ServiceExtendExample example);

    int updateByExample(@Param("record") ServiceExtend record, @Param("example") ServiceExtendExample example);

    int updateByPrimaryKeySelective(ServiceExtend record);

    int updateByPrimaryKeyWithBLOBs(ServiceExtend record);

    int updateByPrimaryKey(ServiceExtend record);

    void insertBatch(List<ServiceExtend> list);

    List<ServiceExtend> selectByExampleByPage(ServiceExtendExample example);
}