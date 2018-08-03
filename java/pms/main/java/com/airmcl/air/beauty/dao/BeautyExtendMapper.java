package com.airmcl.air.beauty.dao;

import com.airmcl.air.beauty.entity.BeautyExtend;
import com.airmcl.air.beauty.entity.BeautyExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeautyExtendMapper {
    int countByExample(BeautyExtendExample example);

    int deleteByExample(BeautyExtendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeautyExtend record);

    int insertSelective(BeautyExtend record);

    List<BeautyExtend> selectByExampleWithBLOBs(BeautyExtendExample example);

    List<BeautyExtend> selectByExample(BeautyExtendExample example);

    BeautyExtend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeautyExtend record, @Param("example") BeautyExtendExample example);

    int updateByExampleWithBLOBs(@Param("record") BeautyExtend record, @Param("example") BeautyExtendExample example);

    int updateByExample(@Param("record") BeautyExtend record, @Param("example") BeautyExtendExample example);

    int updateByPrimaryKeySelective(BeautyExtend record);

    int updateByPrimaryKeyWithBLOBs(BeautyExtend record);

    int updateByPrimaryKey(BeautyExtend record);

    void insertBatch(List<BeautyExtend> list);

    List<BeautyExtend> selectByExampleByPage(BeautyExtendExample example);
}