package com.airmcl.air.app.service;

import com.airmcl.air.app.entity.AppBottomIcon;
import com.airmcl.air.app.entity.AppBottomIconExample;
import com.els.base.core.service.BaseService;

public interface AppBottomIconService extends BaseService<AppBottomIcon, AppBottomIconExample, Integer> {
    int updateStateByIds(int[] ids);
}