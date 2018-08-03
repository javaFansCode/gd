package com.airmcl.air.app.service;

import com.airmcl.air.app.entity.Startpage;
import com.airmcl.air.app.entity.StartpageExample;
import com.els.base.core.service.BaseService;

public interface StartpageService extends BaseService<Startpage, StartpageExample, Integer> {
    int updateStateByIds(int[] ids);
}