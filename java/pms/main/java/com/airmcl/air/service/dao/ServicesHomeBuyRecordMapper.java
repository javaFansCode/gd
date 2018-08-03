package com.airmcl.air.service.dao;

import com.airmcl.air.service.entity.ServicesHomeBuyRecord;
import com.airmcl.air.service.entity.ServicesHomeBuyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServicesHomeBuyRecordMapper {
    int countByExample(ServicesHomeBuyRecordExample example);

    int deleteByExample(ServicesHomeBuyRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServicesHomeBuyRecord record);

    int insertSelective(ServicesHomeBuyRecord record);

    List<ServicesHomeBuyRecord> selectByExample(ServicesHomeBuyRecordExample example);

    ServicesHomeBuyRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServicesHomeBuyRecord record, @Param("example") ServicesHomeBuyRecordExample example);

    int updateByExample(@Param("record") ServicesHomeBuyRecord record, @Param("example") ServicesHomeBuyRecordExample example);

    int updateByPrimaryKeySelective(ServicesHomeBuyRecord record);

    int updateByPrimaryKey(ServicesHomeBuyRecord record);

    void insertBatch(List<ServicesHomeBuyRecord> list);

    List<ServicesHomeBuyRecord> selectByExampleByPage(ServicesHomeBuyRecordExample example);
}