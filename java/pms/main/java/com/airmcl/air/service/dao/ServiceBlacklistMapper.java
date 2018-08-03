package com.airmcl.air.service.dao;

import com.airmcl.air.service.entity.ServiceBlacklist;
import com.airmcl.air.service.entity.ServiceBlacklistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceBlacklistMapper {
    int countByExample(ServiceBlacklistExample example);

    int deleteByExample(ServiceBlacklistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceBlacklist record);

    int insertSelective(ServiceBlacklist record);

    List<ServiceBlacklist> selectByExampleWithBLOBs(ServiceBlacklistExample example);

    List<ServiceBlacklist> selectByExample(ServiceBlacklistExample example);

    ServiceBlacklist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceBlacklist record, @Param("example") ServiceBlacklistExample example);

    int updateByExampleWithBLOBs(@Param("record") ServiceBlacklist record, @Param("example") ServiceBlacklistExample example);

    int updateByExample(@Param("record") ServiceBlacklist record, @Param("example") ServiceBlacklistExample example);

    int updateByPrimaryKeySelective(ServiceBlacklist record);

    int updateByPrimaryKeyWithBLOBs(ServiceBlacklist record);

    int updateByPrimaryKey(ServiceBlacklist record);

    void insertBatch(List<ServiceBlacklist> list);

    List<ServiceBlacklist> selectByExampleByPage(ServiceBlacklistExample example);
}