package com.airmcl.air.beautician.dao;

import com.airmcl.air.beautician.entity.BeauticianWorktime;
import com.airmcl.air.beautician.entity.BeauticianWorktimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeauticianWorktimeMapper {
    int countByExample(BeauticianWorktimeExample example);

    int deleteByExample(BeauticianWorktimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeauticianWorktime record);

    int insertSelective(BeauticianWorktime record);

    List<BeauticianWorktime> selectByExampleWithBLOBs(BeauticianWorktimeExample example);

    List<BeauticianWorktime> selectByExample(BeauticianWorktimeExample example);

    BeauticianWorktime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeauticianWorktime record, @Param("example") BeauticianWorktimeExample example);

    int updateByExampleWithBLOBs(@Param("record") BeauticianWorktime record, @Param("example") BeauticianWorktimeExample example);

    int updateByExample(@Param("record") BeauticianWorktime record, @Param("example") BeauticianWorktimeExample example);

    int updateByPrimaryKeySelective(BeauticianWorktime record);

    int updateByPrimaryKeyWithBLOBs(BeauticianWorktime record);

    int updateByPrimaryKey(BeauticianWorktime record);

    void insertBatch(List<BeauticianWorktime> list);

    List<BeauticianWorktime> selectByExampleByPage(BeauticianWorktimeExample example);
}