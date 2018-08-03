package com.airmcl.air.app.dao;

import com.airmcl.air.app.entity.Startpage;
import com.airmcl.air.app.entity.StartpageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StartpageMapper {
    int countByExample(StartpageExample example);

    int deleteByExample(StartpageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Startpage record);

    int insertSelective(Startpage record);

    List<Startpage> selectByExample(StartpageExample example);

    Startpage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Startpage record, @Param("example") StartpageExample example);

    int updateByExample(@Param("record") Startpage record, @Param("example") StartpageExample example);

    int updateByPrimaryKeySelective(Startpage record);

    int updateByPrimaryKey(Startpage record);

    void insertBatch(List<Startpage> list);

    List<Startpage> selectByExampleByPage(StartpageExample example);

    int updateStateByIds(@Param("ids") int[] ids);
}