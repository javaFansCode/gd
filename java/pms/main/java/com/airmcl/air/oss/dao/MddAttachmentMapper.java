package com.airmcl.air.oss.dao;

import com.airmcl.air.oss.entity.MddAttachment;
import com.airmcl.air.oss.entity.MddAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MddAttachmentMapper {
    int countByExample(MddAttachmentExample example);

    int deleteByExample(MddAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MddAttachment record);

    int insertSelective(MddAttachment record);

    List<MddAttachment> selectByExample(MddAttachmentExample example);

    MddAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MddAttachment record, @Param("example") MddAttachmentExample example);

    int updateByExample(@Param("record") MddAttachment record, @Param("example") MddAttachmentExample example);

    int updateByPrimaryKeySelective(MddAttachment record);

    int updateByPrimaryKey(MddAttachment record);

    void insertBatch(List<MddAttachment> list);

    List<MddAttachment> selectByExampleByPage(MddAttachmentExample example);
}