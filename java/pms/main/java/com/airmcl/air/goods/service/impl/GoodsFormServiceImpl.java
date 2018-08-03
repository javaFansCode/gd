package com.airmcl.air.goods.service.impl;

import com.airmcl.air.goods.dao.GoodsFormMapper;
import com.airmcl.air.goods.entity.GoodsForm;
import com.airmcl.air.goods.entity.GoodsFormExample;
import com.airmcl.air.goods.service.GoodsFormService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultGoodsFormService")
public class GoodsFormServiceImpl implements GoodsFormService {
    @Resource
    protected GoodsFormMapper goodsFormMapper;

    @CacheEvict(value={"goodsForm"}, allEntries=true)
    @Override
    public void addObj(GoodsForm t) {
        this.goodsFormMapper.insertSelective(t);
    }

    @CacheEvict(value={"goodsForm"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.goodsFormMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"goodsForm"}, allEntries=true)
    @Override
    public void modifyObj(GoodsForm t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.goodsFormMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="goodsForm", keyGenerator="redisKeyGenerator")
    @Override
    public GoodsForm queryObjById(Integer id) {
        return this.goodsFormMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="goodsForm", key="'GoodsFormService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<GoodsForm> queryAllObjByExample(GoodsFormExample example) {
        return this.goodsFormMapper.selectByExample(example);
    }

    @Cacheable(value="goodsForm", key="'GoodsFormService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<GoodsForm> queryObjByPage(GoodsFormExample example) {
        PageView<GoodsForm> pageView = example.getPageView();
        pageView.setQueryResult(this.goodsFormMapper.selectByExampleByPage(example));
        return pageView;
    }
}