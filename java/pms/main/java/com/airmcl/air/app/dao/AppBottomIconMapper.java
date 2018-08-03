package com.airmcl.air.app.dao;

import com.airmcl.air.app.entity.AppBottomIcon;
import com.airmcl.air.app.entity.AppBottomIconExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppBottomIconMapper {
    int countByExample(AppBottomIconExample example);

    int deleteByExample(AppBottomIconExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppBottomIcon record);

    int insertSelective(AppBottomIcon record);

    List<AppBottomIcon> selectByExample(AppBottomIconExample example);

    AppBottomIcon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppBottomIcon record, @Param("example") AppBottomIconExample example);

    int updateByExample(@Param("record") AppBottomIcon record, @Param("example") AppBottomIconExample example);

    int updateByPrimaryKeySelective(AppBottomIcon record);

    int updateByPrimaryKey(AppBottomIcon record);

    void insertBatch(List<AppBottomIcon> list);

    List<AppBottomIcon> selectByExampleByPage(AppBottomIconExample example);

    int updateStateByIds(@Param("ids") int[] ids);
}