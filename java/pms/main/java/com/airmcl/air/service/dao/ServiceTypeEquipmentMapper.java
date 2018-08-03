package com.airmcl.air.service.dao;

import com.airmcl.air.service.entity.ServiceTypeEquipment;
import com.airmcl.air.service.entity.ServiceTypeEquipmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceTypeEquipmentMapper {
    int countByExample(ServiceTypeEquipmentExample example);

    int deleteByExample(ServiceTypeEquipmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServiceTypeEquipment record);

    int insertSelective(ServiceTypeEquipment record);

    List<ServiceTypeEquipment> selectByExample(ServiceTypeEquipmentExample example);

    ServiceTypeEquipment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServiceTypeEquipment record, @Param("example") ServiceTypeEquipmentExample example);

    int updateByExample(@Param("record") ServiceTypeEquipment record, @Param("example") ServiceTypeEquipmentExample example);

    int updateByPrimaryKeySelective(ServiceTypeEquipment record);

    int updateByPrimaryKey(ServiceTypeEquipment record);

    void insertBatch(List<ServiceTypeEquipment> list);

    List<ServiceTypeEquipment> selectByExampleByPage(ServiceTypeEquipmentExample example);
}