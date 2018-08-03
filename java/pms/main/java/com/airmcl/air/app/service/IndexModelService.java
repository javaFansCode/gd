package com.airmcl.air.app.service;

import com.airmcl.air.app.entity.IndexModel;
import com.airmcl.air.app.entity.IndexModelExample;
import com.els.base.core.service.BaseService;

public interface IndexModelService extends BaseService<IndexModel, IndexModelExample, Integer> {
    int  updateStateByIds(int[] ids);
}