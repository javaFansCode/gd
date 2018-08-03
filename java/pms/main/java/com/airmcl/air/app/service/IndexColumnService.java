package com.airmcl.air.app.service;

import com.airmcl.air.app.entity.IndexColumn;
import com.airmcl.air.app.entity.IndexColumnExample;
import com.airmcl.air.app.entity.IndexEnterColumnAndModelParams;
import com.airmcl.air.app.entity.IndexOutColumnAndModel;
import com.els.base.core.entity.PageView;
import com.els.base.core.service.BaseService;

public interface IndexColumnService extends BaseService<IndexColumn, IndexColumnExample, Integer> {
	int updateStateByIds(int[] ids);
    //多条件搜索栏目或者推荐项目
	PageView<IndexOutColumnAndModel> findPageByParams(IndexEnterColumnAndModelParams enterParams,int pageNo,int pageSize);
}