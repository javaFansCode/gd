package com.airmcl.air.goods.dao.ext;

import com.airmcl.air.goods.entity.GoodsHomeBuyRecord;

public interface GoodsHomeBuyRecordExtMapper {
	GoodsHomeBuyRecord selectGoodsHomeBuyRecordByGoodsId(Integer goodsId);
}
