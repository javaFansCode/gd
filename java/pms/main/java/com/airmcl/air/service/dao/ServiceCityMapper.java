package com.airmcl.air.service.dao;

import com.airmcl.air.service.entity.ServiceCity;
import com.airmcl.air.service.entity.ServiceCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceCityMapper {
    int countByExample(ServiceCityExample example);

    int deleteByExample(ServiceCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceCity record);

    int insertSelective(ServiceCity record);

    List<ServiceCity> selectByExample(ServiceCityExample example);

    ServiceCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceCity record, @Param("example") ServiceCityExample example);

    int updateByExample(@Param("record") ServiceCity record, @Param("example") ServiceCityExample example);

    int updateByPrimaryKeySelective(ServiceCity record);

    int updateByPrimaryKey(ServiceCity record);

    void insertBatch(List<ServiceCity> list);

    List<ServiceCity> selectByExampleByPage(ServiceCityExample example);
}