package com.airmcl.air.beautician.dao;

import com.airmcl.air.beautician.entity.BeauticianOperation;
import com.airmcl.air.beautician.entity.BeauticianOperationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeauticianOperationMapper {
    int countByExample(BeauticianOperationExample example);

    int deleteByExample(BeauticianOperationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeauticianOperation record);

    int insertSelective(BeauticianOperation record);

    List<BeauticianOperation> selectByExample(BeauticianOperationExample example);

    BeauticianOperation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeauticianOperation record, @Param("example") BeauticianOperationExample example);

    int updateByExample(@Param("record") BeauticianOperation record, @Param("example") BeauticianOperationExample example);

    int updateByPrimaryKeySelective(BeauticianOperation record);

    int updateByPrimaryKey(BeauticianOperation record);

    void insertBatch(List<BeauticianOperation> list);

    List<BeauticianOperation> selectByExampleByPage(BeauticianOperationExample example);
}