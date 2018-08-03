package com.airmcl.air.comments.dao.ext;

import com.airmcl.air.comments.entity.CommentsExt;
import com.airmcl.air.comments.entity.CommentsExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentsExtMapper {
    int countByExample(CommentsExtExample example);

    int deleteByExample(CommentsExtExample example);

    int insert(CommentsExt record);

    int insertSelective(CommentsExt record);

    List<CommentsExt> selectByExampleWithBLOBs(CommentsExtExample example);

    List<CommentsExt> selectByExample(CommentsExtExample example);

    int updateByExampleSelective(@Param("record") CommentsExt record, @Param("example") CommentsExtExample example);

    int updateByExampleWithBLOBs(@Param("record") CommentsExt record, @Param("example") CommentsExtExample example);

    int updateByExample(@Param("record") CommentsExt record, @Param("example") CommentsExtExample example);

    void insertBatch(List<CommentsExt> list);

    List<CommentsExt> selectCommentsByParams(CommentsExt params);

    Integer countCommentByParams(CommentsExt params);
}