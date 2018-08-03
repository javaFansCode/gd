package com.airmcl.air.beautician.service;

import com.airmcl.air.beautician.entity.Beautician;
import com.airmcl.air.beautician.entity.BeauticianExample;
import com.els.base.core.service.BaseService;

public interface BeauticianService extends BaseService<Beautician, BeauticianExample, Integer> {
    int deleteByIds(int[] id);

    void updateState(int[] ids, Integer state);

    void modifyObj(Beautician beautician);

}