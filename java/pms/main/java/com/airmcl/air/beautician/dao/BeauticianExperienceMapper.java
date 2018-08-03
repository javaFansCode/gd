package com.airmcl.air.beautician.dao;

import com.airmcl.air.beautician.entity.BeauticianExperience;
import com.airmcl.air.beautician.entity.BeauticianExperienceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeauticianExperienceMapper {
    int countByExample(BeauticianExperienceExample example);

    int deleteByExample(BeauticianExperienceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeauticianExperience record);

    int insertSelective(BeauticianExperience record);

    List<BeauticianExperience> selectByExample(BeauticianExperienceExample example);

    BeauticianExperience selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeauticianExperience record, @Param("example") BeauticianExperienceExample example);

    int updateByExample(@Param("record") BeauticianExperience record, @Param("example") BeauticianExperienceExample example);

    int updateByPrimaryKeySelective(BeauticianExperience record);

    int updateByPrimaryKey(BeauticianExperience record);

    void insertBatch(List<BeauticianExperience> list);

    List<BeauticianExperience> selectByExampleByPage(BeauticianExperienceExample example);

    BeauticianExperience findBeauticianExperienceByBtId(Integer btId);

    int deleteByIds(List list);

    void updateState(@Param("ids")int[] ids, @Param("state")Integer state);

}