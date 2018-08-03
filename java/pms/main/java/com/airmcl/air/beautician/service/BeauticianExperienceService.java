package com.airmcl.air.beautician.service;

import com.airmcl.air.beautician.entity.BeauticianExperience;
import com.airmcl.air.beautician.entity.BeauticianExperienceExample;
import com.els.base.core.service.BaseService;

public interface BeauticianExperienceService extends BaseService<BeauticianExperience, BeauticianExperienceExample, Integer> {
    void updateState(int[] ids, Integer state);

}