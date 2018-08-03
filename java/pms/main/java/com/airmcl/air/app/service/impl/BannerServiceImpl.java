package com.airmcl.air.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.air.app.dao.BannerMapper;
import com.airmcl.air.app.dao.PhotoMapper;
import com.airmcl.air.app.dao.ext.BannerExtMapper;
import com.airmcl.air.app.enter.BannerEnterParams;
import com.airmcl.air.app.entity.Banner;
import com.airmcl.air.app.entity.BannerExample;
import com.airmcl.air.app.entity.Photo;
import com.airmcl.air.app.service.BannerService;
import com.els.base.core.entity.PageView;

@Service("defaultBannerService")
public class BannerServiceImpl implements BannerService {
	@Resource
	protected BannerMapper bannerMapper;
	@Resource
	protected PhotoMapper  photoMapper;
	@Resource
	protected BannerExtMapper bannerExtMapper;

	@CacheEvict(value = { "banner" }, allEntries = true)
	@Override
	public void addObj(Banner t) {
		this.bannerMapper.insertSelective(t);
	}

	@CacheEvict(value = { "banner" }, allEntries = true)
	@Override
	public void deleteObjById(Integer id) {
		this.bannerMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "banner" }, allEntries = true)
	@Override
	public void modifyObj(Banner t) {
		if (t.getId() == null || t.getId() == 0) {
			throw new NullPointerException("id 为空，无法更新");
		}
		this.bannerMapper.updateByPrimaryKeySelective(t);
		Photo photoIsExists = bannerExtMapper.selectByPostidSelective(t);
		if(null == photoIsExists){
			if(!StringUtils.isEmpty(t.getBannerImage())){
				Photo photo = new Photo();
				photo.setPost_id(t.getId());
				photo.setType_code("banner");
				photo.setSort((short) 9999);
				String a  = t.getBannerImage();
				photo.setOriginal_path(a);
				photo.setThumb_path(t.getBannerImage());
				Long tim = System.currentTimeMillis();
				photo.setCreatetime(Integer.valueOf(tim / 1000 + ""));
				photo.setIsdelete((byte) 1);
				photoMapper.insert(photo);
			}
		}else{
			bannerExtMapper.updateBannerPhoto(t);
		}
	}

	@Cacheable(value = "banner", keyGenerator = "redisKeyGenerator")
	@Override
	public Banner queryObjById(Integer id) {
		return this.bannerMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "banner", key = "'BannerService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public List<Banner> queryAllObjByExample(BannerExample example) {
		return this.bannerMapper.selectByExample(example);
	}

	@Cacheable(value = "banner", key = "'BannerService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public PageView<Banner> queryObjByPage(BannerExample example) {
		PageView<Banner> pageView = example.getPageView();
		pageView.setQueryResult(this.bannerMapper.selectByExampleByPage(example));
		return pageView;
		/*PageView<Banner> pageView = example.getPageView();
		pageView.setQueryResult(this.bannerMapper.selectByExampleByPage(example));
		return pageView;*/
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	@Override
	public int updateStateByIds(int[] ids, String state) {

		return bannerMapper.updateStateByIds(ids, state);
	}

	/**
	 * 增加banner 要连同photo表一起增加
	 */
	@Override
	public void insertBanner(Banner banner) {

		Date time = new Date(System.currentTimeMillis());
		long createtime = time.getTime() / 1000;
		banner.setCreatetime(Integer.valueOf(createtime + ""));
		if (banner.getService_id() == null || "".equals(banner.getService_id())){
			banner.setService_id(0);
		}
		bannerExtMapper.insert(banner);
		Photo photo = new Photo();
		photo.setPost_id(banner.getId());
		photo.setType_code("banner");
		photo.setSort((short) 9999);
		photo.setOriginal_path(banner.getBannerImage());
		photo.setThumb_path(banner.getBannerImage());
		Long tim = System.currentTimeMillis();
		photo.setCreatetime(Integer.valueOf(tim / 1000 + ""));
		photo.setIsdelete((byte) 1);
		photoMapper.insert(photo);
	}

	/**
	 * banner联查   参数可选
	 */
	@Override
	public PageView<Banner> findBannerByPage(BannerEnterParams params, int pageNo, int pageSize) {
		// 设置返回对象
	    PageView<Banner> resultData = new PageView<Banner>();
		// 分页数据
		params.setPageNo((pageNo - 1) * pageSize);
		params.setPageSize(pageSize);
		List<Banner> listData = bannerExtMapper.findBanner(params);
		if (listData == null || listData.size() < 1) {
			resultData.setPageNo(pageNo);
			resultData.setPageSize(pageSize);
			resultData.setRowCount(0);
			List<Banner> list = new ArrayList<>();
			resultData.setQueryResult(list);
		}
		// 总条数
		Integer count = this.bannerExtMapper.countBanner(params);
		// 数据总记录数
		resultData.setPageSize(pageSize);
		resultData.setRowCount(count);
		resultData.setPageNo(pageNo);
		resultData.setQueryResult(listData);
		return resultData;
	}
	
	
	
	
}