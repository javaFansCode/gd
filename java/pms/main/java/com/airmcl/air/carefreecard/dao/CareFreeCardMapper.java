package com.airmcl.air.carefreecard.dao;

import com.airmcl.air.carefreecard.entity.CareFreeCard;
import com.airmcl.air.carefreecard.entity.CareFreeCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CareFreeCardMapper {
    int countByExample(CareFreeCardExample example);

    int deleteByExample(CareFreeCardExample example);

    int deleteByPrimaryKey(String id);

    int insert(CareFreeCard record);

    int insertSelective(CareFreeCard record);

    List<CareFreeCard> selectByExample(CareFreeCardExample example);

    CareFreeCard selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CareFreeCard record, @Param("example") CareFreeCardExample example);

    int updateByExample(@Param("record") CareFreeCard record, @Param("example") CareFreeCardExample example);

    int updateByPrimaryKeySelective(CareFreeCard record);

    int updateByPrimaryKey(CareFreeCard record);

    void insertBatch(List<CareFreeCard> list);

    List<CareFreeCard> selectByExampleByPage(CareFreeCardExample example);
}