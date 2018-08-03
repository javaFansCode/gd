package com.airmcl.air.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.airmcl.air.app.dao.IndexColumnMapper;
import com.airmcl.air.app.dao.ext.IndexColumnExtMapper;
import com.airmcl.air.app.entity.IndexColumn;
import com.airmcl.air.app.entity.IndexColumnExample;
import com.airmcl.air.app.entity.IndexEnterColumnAndModelParams;
import com.airmcl.air.app.entity.IndexOutColumnAndModel;
import com.airmcl.air.app.service.IndexColumnService;
import com.els.base.core.entity.PageView;

@Service("defaultIndexColumnService")
public class IndexColumnServiceImpl implements IndexColumnService {
	@Resource
	protected IndexColumnMapper indexColumnMapper;
	@Resource
	protected IndexColumnExtMapper indexColumnExtMapper;

	@CacheEvict(value = { "indexColumn" }, allEntries = true)
	@Override
	public void addObj(IndexColumn t) {
		Integer createtime = Double.valueOf((new Date().getTime() / 1000)).intValue();
		t.setCreatetime(createtime);
		t.setUpdatetime(createtime);
		this.indexColumnMapper.insertSelective(t);
	}

	@CacheEvict(value = { "indexColumn" }, allEntries = true)
	@Override
	public void deleteObjById(Integer id) {
		this.indexColumnMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "indexColumn" }, allEntries = true)
	@Override
	public void modifyObj(IndexColumn t) {
		if (t.getId() == null || t.getId() == 0) {
			throw new NullPointerException("id 为空，无法更新");
		}
		Integer updatetime = Double.valueOf((new Date().getTime() / 1000)).intValue();
		t.setUpdatetime(updatetime);
		t.setCreatetime(null);
		this.indexColumnMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "indexColumn", keyGenerator = "redisKeyGenerator")
	@Override
	public IndexColumn queryObjById(Integer id) {
		return this.indexColumnMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "indexColumn", key = "'IndexColumnService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public List<IndexColumn> queryAllObjByExample(IndexColumnExample example) {
		return this.indexColumnMapper.selectByExample(example);
	}

	@Cacheable(value = "indexColumn", key = "'IndexColumnService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public PageView<IndexColumn> queryObjByPage(IndexColumnExample example) {
		PageView<IndexColumn> pageView = example.getPageView();
		pageView.setQueryResult(this.indexColumnMapper.selectByExampleByPage(example));
		return pageView;
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	@Override
	public int updateStateByIds(int[] ids) {

		return indexColumnMapper.updateStateByIds(ids);
	}

	/**
	 * 条件查询专家推荐以及栏目信息
	 */
	@Override
	public PageView<IndexOutColumnAndModel> findPageByParams(IndexEnterColumnAndModelParams enterParams,int pageNo,int pageSize) {
		// 设置返回对象
		PageView<IndexOutColumnAndModel> resultData = new PageView<IndexOutColumnAndModel>();
		// 分页数据
		enterParams.setPageNo((pageNo - 1) * pageSize);
		enterParams.setPageSize(pageSize);
		List<IndexOutColumnAndModel> listData = this.indexColumnExtMapper.findPageByParams(enterParams);
		if (listData == null || listData.size() < 1) {
			resultData.setPageNo(pageNo);
			resultData.setPageSize(pageSize);
			resultData.setRowCount(0);
			List<IndexOutColumnAndModel> list = new ArrayList<>();
			resultData.setQueryResult(list);
		}
		// 总条数
		Integer count = this.indexColumnExtMapper.countColumnAndModel(enterParams);
		// 数据总记录数
		resultData.setPageSize(pageSize);
		resultData.setRowCount(count);
		resultData.setPageNo(pageNo);
		resultData.setQueryResult(listData);

		return resultData;
	}
}