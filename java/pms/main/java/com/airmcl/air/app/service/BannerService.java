package com.airmcl.air.app.service;

import com.airmcl.air.app.enter.BannerEnterParams;
import com.airmcl.air.app.entity.Banner;
import com.airmcl.air.app.entity.BannerExample;
import com.els.base.core.entity.PageView;
import com.els.base.core.service.BaseService;

public interface BannerService extends BaseService<Banner, BannerExample, Integer> {
	
		int updateStateByIds(int[] ids,String state);
		//增加banner--photo表内也要关联插入
		void insertBanner(Banner banner);
		//连表查询bannerANDphoto
		 PageView<Banner>  findBannerByPage(BannerEnterParams params,int pageNo,int pageSize);
}