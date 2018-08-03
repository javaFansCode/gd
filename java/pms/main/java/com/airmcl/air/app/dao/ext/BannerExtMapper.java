package com.airmcl.air.app.dao.ext;

import java.util.List;

import com.airmcl.air.app.enter.BannerEnterParams;
import com.airmcl.air.app.entity.Banner;
import com.airmcl.air.app.entity.Photo;

public interface BannerExtMapper {

	// 联表插入banner
	int insert(Banner bannerr);
	//后台连表查询banner
	List<Banner> findBanner(BannerEnterParams params);
	
	Integer countBanner(BannerEnterParams params);

	Photo selectByPostidSelective(Banner banner);

	int updateBannerPhoto(Banner banner);

}