package com.airmcl.air.beautician.service;

import com.airmcl.air.beautician.entity.JobTitle;
import com.airmcl.air.beautician.entity.JobTitleExample;
import com.els.base.core.service.BaseService;

public interface JobTitleService extends BaseService<JobTitle, JobTitleExample, Integer> {
    int deleteByIds(int[] id);
    void updateState(int[] ids, Integer state);

}