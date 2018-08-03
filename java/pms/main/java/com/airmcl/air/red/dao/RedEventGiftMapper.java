package com.airmcl.air.red.dao;

import com.airmcl.air.red.entity.RedEventGift;
import com.airmcl.air.red.entity.RedEventGiftExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RedEventGiftMapper {
    int countByExample(RedEventGiftExample example);

    int deleteByExample(RedEventGiftExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RedEventGift record);

    int insertSelective(RedEventGift record);

    List<RedEventGift> selectByExample(RedEventGiftExample example);

    RedEventGift selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RedEventGift record, @Param("example") RedEventGiftExample example);

    int updateByExample(@Param("record") RedEventGift record, @Param("example") RedEventGiftExample example);

    int updateByPrimaryKeySelective(RedEventGift record);

    int updateByPrimaryKey(RedEventGift record);

    void insertBatch(List<RedEventGift> list);

    List<RedEventGift> selectByExampleByPage(RedEventGiftExample example);
}