package com.airmcl.air.beautician.service;

import com.airmcl.air.beautician.entity.BeauticianService;
import com.airmcl.air.beautician.entity.BeauticianServiceExample;
import com.els.base.core.service.BaseService;

public interface BeauticianServiceService extends BaseService<BeauticianService, BeauticianServiceExample, Integer> {
    void updateState(int[] ids, Integer state);

}