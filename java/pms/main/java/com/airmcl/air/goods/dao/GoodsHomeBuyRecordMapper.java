package com.airmcl.air.goods.dao;

import com.airmcl.air.goods.entity.GoodsHomeBuyRecord;
import com.airmcl.air.goods.entity.GoodsHomeBuyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsHomeBuyRecordMapper {
    int countByExample(GoodsHomeBuyRecordExample example);

    int deleteByExample(GoodsHomeBuyRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsHomeBuyRecord record);

    int insertSelective(GoodsHomeBuyRecord record);

    List<GoodsHomeBuyRecord> selectByExample(GoodsHomeBuyRecordExample example);

    GoodsHomeBuyRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsHomeBuyRecord record, @Param("example") GoodsHomeBuyRecordExample example);

    int updateByExample(@Param("record") GoodsHomeBuyRecord record, @Param("example") GoodsHomeBuyRecordExample example);

    int updateByPrimaryKeySelective(GoodsHomeBuyRecord record);

    int updateByPrimaryKey(GoodsHomeBuyRecord record);

    void insertBatch(List<GoodsHomeBuyRecord> list);

    List<GoodsHomeBuyRecord> selectByExampleByPage(GoodsHomeBuyRecordExample example);
}