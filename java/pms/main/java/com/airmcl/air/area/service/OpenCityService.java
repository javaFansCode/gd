package com.airmcl.air.area.service;

import com.airmcl.air.area.entity.OpenCity;
import com.airmcl.air.area.entity.OpenCityExample;
import com.airmcl.air.area.vo.AddStreetVO;
import com.airmcl.air.area.vo.CreateOpenCityVO;
import com.els.base.core.service.BaseService;

public interface OpenCityService extends BaseService<OpenCity, OpenCityExample, Integer> {

    /**
     * 创建开通成
     * @param createOpenCityVO
     * @return
     */
    OpenCity createOpenCity(CreateOpenCityVO createOpenCityVO);

    /**
     * 给区添加街道数据
     * @param addStreetVO
     * @return
     */
    OpenCity addStreetToArea(AddStreetVO addStreetVO);

    /**
     * 删除街道数据
     * @param id
     */
    void deleteStreetById(int id);

}