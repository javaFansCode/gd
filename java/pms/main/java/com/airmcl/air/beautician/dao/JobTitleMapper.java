package com.airmcl.air.beautician.dao;

import com.airmcl.air.beautician.entity.JobTitle;
import com.airmcl.air.beautician.entity.JobTitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobTitleMapper {
    int countByExample(JobTitleExample example);

    int deleteByExample(JobTitleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JobTitle record);

    int insertSelective(JobTitle record);

    List<JobTitle> selectByExample(JobTitleExample example);

    JobTitle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JobTitle record, @Param("example") JobTitleExample example);

    int updateByExample(@Param("record") JobTitle record, @Param("example") JobTitleExample example);

    int updateByPrimaryKeySelective(JobTitle record);

    int updateByPrimaryKey(JobTitle record);

    void insertBatch(List<JobTitle> list);

    List<JobTitle> selectByExampleByPage(JobTitleExample example);

    int deleteByIds(List list);

    void updateState(@Param("ids")int[] ids, @Param("state")Integer state);

}