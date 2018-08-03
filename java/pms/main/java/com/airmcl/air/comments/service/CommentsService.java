package com.airmcl.air.comments.service;

import com.airmcl.air.comments.entity.Comments;
import com.airmcl.air.comments.entity.CommentsExample;
import com.airmcl.air.comments.entity.CommentsExt;
import com.airmcl.air.comments.entity.CommentsExtExample;
import com.els.base.core.entity.PageView;
import com.els.base.core.service.BaseService;

import java.util.List;

public interface CommentsService extends BaseService<Comments, CommentsExample, Integer> {

    void updateState(int[] ids, Integer state);

    PageView<CommentsExt> queryCommentsByparams(CommentsExt commentsParams,int pageNo,int pageSize);
}