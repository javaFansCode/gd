package com.airmcl.air.beauty.dao.ext;

import java.util.List;
import java.util.Map;

import com.airmcl.air.beauty.entity.BeautyRelationsGoodsVO;
import com.airmcl.air.beauty.entity.BeautyRelationsServiceVO;

public interface BeautyRelationsExtMapper {
    List<BeautyRelationsServiceVO> selectServiceByBeautyId(Map<String, Object> para);
    List<BeautyRelationsGoodsVO> selectGoodsByBeautyId(Map<String, Object> para);
}