package com.airmcl.air.beautician.dao;

import com.airmcl.air.beautician.entity.BeauticianData;
import com.airmcl.air.beautician.entity.BeauticianDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeauticianDataMapper {
    int countByExample(BeauticianDataExample example);

    int deleteByExample(BeauticianDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeauticianData record);

    int insertSelective(BeauticianData record);

    List<BeauticianData> selectByExample(BeauticianDataExample example);

    BeauticianData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeauticianData record, @Param("example") BeauticianDataExample example);

    int updateByExample(@Param("record") BeauticianData record, @Param("example") BeauticianDataExample example);

    int updateByPrimaryKeySelective(BeauticianData record);

    int updateByPrimaryKey(BeauticianData record);

    void insertBatch(List<BeauticianData> list);

    List<BeauticianData> selectByExampleByPage(BeauticianDataExample example);
}