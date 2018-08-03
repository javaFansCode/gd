package com.airmcl.air.red.dao.ext;

import java.util.List;

import com.airmcl.air.red.entity.RedEventGiftVo;

public interface RedEventGiftExtMapper {
	
    List<RedEventGiftVo> selectRedEventGiftsByRedId(Integer redId);
    
    int updateRedEventGiftsByRedEventId(Integer redEventId);
}
