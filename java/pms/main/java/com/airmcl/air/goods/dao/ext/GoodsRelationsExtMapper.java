package com.airmcl.air.goods.dao.ext;

import java.util.List;

import com.airmcl.air.goods.entity.GoodsRelations;

public interface GoodsRelationsExtMapper {
      List<GoodsRelations> selectGoodsRelationsByGoodsId(Integer goodsId);
      
      int deleteGoodsRelationsByGoodsId(Integer goodsId);
}
