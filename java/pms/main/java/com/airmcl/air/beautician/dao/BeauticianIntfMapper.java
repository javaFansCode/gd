package com.airmcl.air.beautician.dao;

import com.airmcl.air.beautician.entity.BeauticianIntf;
import com.airmcl.air.beautician.entity.BeauticianIntfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeauticianIntfMapper {
    int countByExample(BeauticianIntfExample example);

    int deleteByExample(BeauticianIntfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeauticianIntf record);

    int insertSelective(BeauticianIntf record);

    List<BeauticianIntf> selectByExample(BeauticianIntfExample example);

    BeauticianIntf selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeauticianIntf record, @Param("example") BeauticianIntfExample example);

    int updateByExample(@Param("record") BeauticianIntf record, @Param("example") BeauticianIntfExample example);

    int updateByPrimaryKeySelective(BeauticianIntf record);

    int updateByPrimaryKey(BeauticianIntf record);

    void insertBatch(List<BeauticianIntf> list);

    List<BeauticianIntf> selectByExampleByPage(BeauticianIntfExample example);
}