package com.airmcl.air.area.dao;

import com.airmcl.air.area.entity.OpenCity;
import com.airmcl.air.area.entity.OpenCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpenCityMapper {
    int countByExample(OpenCityExample example);

    int deleteByExample(OpenCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpenCity record);

    int insertSelective(OpenCity record);

    List<OpenCity> selectByExample(OpenCityExample example);

    OpenCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpenCity record, @Param("example") OpenCityExample example);

    int updateByExample(@Param("record") OpenCity record, @Param("example") OpenCityExample example);

    int updateByPrimaryKeySelective(OpenCity record);

    int updateByPrimaryKey(OpenCity record);

    void insertBatch(List<OpenCity> list);

    List<OpenCity> selectByExampleByPage(OpenCityExample example);
}