package com.airmcl.air.beautician.dao;

import com.airmcl.air.beautician.entity.Beautician;
import com.airmcl.air.beautician.entity.BeauticianExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeauticianMapper {
    int countByExample(BeauticianExample example);

    int deleteByExample(BeauticianExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Beautician record);

    int insertSelective(Beautician record);

    List<Beautician> selectByExample(BeauticianExample example);

    Beautician selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Beautician record, @Param("example") BeauticianExample example);

    int updateByExample(@Param("record") Beautician record, @Param("example") BeauticianExample example);

    int updateByPrimaryKeySelective(Beautician record);

    int updateByPrimaryKey(Beautician record);

    void insertBatch(List<Beautician> list);

    List<Beautician> selectByExampleByPage(BeauticianExample example);

    int deleteByIds(List list);

    void updateState(@Param("ids")int[] ids, @Param("state")Integer state);

}