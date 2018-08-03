package com.airmcl.air.beautician.dao;

import com.airmcl.air.beautician.entity.BeauticianRelations;
import com.airmcl.air.beautician.entity.BeauticianRelationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeauticianRelationsMapper {
    int countByExample(BeauticianRelationsExample example);

    int deleteByExample(BeauticianRelationsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeauticianRelations record);

    int insertSelective(BeauticianRelations record);

    List<BeauticianRelations> selectByExample(BeauticianRelationsExample example);

    BeauticianRelations selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeauticianRelations record, @Param("example") BeauticianRelationsExample example);

    int updateByExample(@Param("record") BeauticianRelations record, @Param("example") BeauticianRelationsExample example);

    int updateByPrimaryKeySelective(BeauticianRelations record);

    int updateByPrimaryKey(BeauticianRelations record);

    void insertBatch(List<BeauticianRelations> list);

    List<BeauticianRelations> selectByExampleByPage(BeauticianRelationsExample example);

    void updateState(@Param("ids")int[] ids, @Param("state")Integer state);

}