package com.airmcl.air.beauty.service.impl;

import com.airmcl.air.beauty.dao.BeautyProfitMapper;
import com.airmcl.air.beauty.dao.ext.BeautyProfitExtMapper;
import com.airmcl.air.beauty.entity.BeautyProfit;
import com.airmcl.air.beauty.entity.BeautyProfitExample;
import com.airmcl.air.beauty.service.BeautyProfitService;
import com.els.base.core.entity.PageView;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBeautyProfitService")
public class BeautyProfitServiceImpl implements BeautyProfitService {
    @Resource
    protected BeautyProfitMapper beautyProfitMapper;
    @Resource
    protected BeautyProfitExtMapper beautyProfitExtMapper;

    @CacheEvict(value={"beautyProfit"}, allEntries=true)
    @Override
    public void addObj(BeautyProfit t) {
        this.beautyProfitMapper.insertSelective(t);
    }

    @CacheEvict(value={"beautyProfit"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.beautyProfitMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beautyProfit"}, allEntries=true)
    @Override
    public void modifyObj(BeautyProfit t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.beautyProfitMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="beautyProfit", keyGenerator="redisKeyGenerator")
    @Override
    public BeautyProfit queryObjById(Integer id) {
        return this.beautyProfitMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="beautyProfit", key="'BeautyProfitService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BeautyProfit> queryAllObjByExample(BeautyProfitExample example) {
        return this.beautyProfitMapper.selectByExample(example);
    }

    @Cacheable(value="beautyProfit", key="'BeautyProfitService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BeautyProfit> queryObjByPage(BeautyProfitExample example) {
        PageView<BeautyProfit> pageView = example.getPageView();
        pageView.setQueryResult(this.beautyProfitMapper.selectByExampleByPage(example));
        return pageView;
    }
	/***
	 * 更新店铺分润受益方状态
	 * @param para
	 */
	@Override
	public void updateBeautyProfitState(Map<String, Object> para) {
		this.beautyProfitExtMapper.updateBeautyProfitState(para);
		
	}
}