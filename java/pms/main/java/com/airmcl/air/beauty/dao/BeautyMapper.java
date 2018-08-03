package com.airmcl.air.beauty.dao;

import com.airmcl.air.beauty.entity.Beauty;
import com.airmcl.air.beauty.entity.BeautyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeautyMapper {
    int countByExample(BeautyExample example);

    int deleteByExample(BeautyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Beauty record);

    int insertSelective(Beauty record);

    List<Beauty> selectByExample(BeautyExample example);

    Beauty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Beauty record, @Param("example") BeautyExample example);

    int updateByExample(@Param("record") Beauty record, @Param("example") BeautyExample example);

    int updateByPrimaryKeySelective(Beauty record);

    int updateByPrimaryKey(Beauty record);

    void insertBatch(List<Beauty> list);

    List<Beauty> selectByExampleByPage(BeautyExample example);
}