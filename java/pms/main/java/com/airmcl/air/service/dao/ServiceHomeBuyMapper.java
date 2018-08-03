package com.airmcl.air.service.dao;

import com.airmcl.air.service.entity.ServiceHomeBuy;
import com.airmcl.air.service.entity.ServiceHomeBuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceHomeBuyMapper {
    int countByExample(ServiceHomeBuyExample example);

    int deleteByExample(ServiceHomeBuyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceHomeBuy record);

    int insertSelective(ServiceHomeBuy record);

    List<ServiceHomeBuy> selectByExample(ServiceHomeBuyExample example);

    ServiceHomeBuy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceHomeBuy record, @Param("example") ServiceHomeBuyExample example);

    int updateByExample(@Param("record") ServiceHomeBuy record, @Param("example") ServiceHomeBuyExample example);

    int updateByPrimaryKeySelective(ServiceHomeBuy record);

    int updateByPrimaryKey(ServiceHomeBuy record);

    void insertBatch(List<ServiceHomeBuy> list);

    List<ServiceHomeBuy> selectByExampleByPage(ServiceHomeBuyExample example);
}