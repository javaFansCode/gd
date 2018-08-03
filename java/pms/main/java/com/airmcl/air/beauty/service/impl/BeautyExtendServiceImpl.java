package com.airmcl.air.beauty.service.impl;

import com.airmcl.air.beauty.dao.BeautyExtendMapper;
import com.airmcl.air.beauty.entity.BeautyExtend;
import com.airmcl.air.beauty.entity.BeautyExtendExample;
import com.airmcl.air.beauty.service.BeautyExtendService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBeautyExtendService")
public class BeautyExtendServiceImpl implements BeautyExtendService {
    @Resource
    protected BeautyExtendMapper beautyExtendMapper;

    @CacheEvict(value={"beautyExtend"}, allEntries=true)
    @Override
    public void addObj(BeautyExtend t) {
        this.beautyExtendMapper.insertSelective(t);
    }

    @CacheEvict(value={"beautyExtend"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.beautyExtendMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beautyExtend"}, allEntries=true)
    @Override
    public void modifyObj(BeautyExtend t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.beautyExtendMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="beautyExtend", keyGenerator="redisKeyGenerator")
    @Override
    public BeautyExtend queryObjById(Integer id) {
        return this.beautyExtendMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="beautyExtend", key="'BeautyExtendService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BeautyExtend> queryAllObjByExample(BeautyExtendExample example) {
        return this.beautyExtendMapper.selectByExample(example);
    }

    @Cacheable(value="beautyExtend", key="'BeautyExtendService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BeautyExtend> queryObjByPage(BeautyExtendExample example) {
        PageView<BeautyExtend> pageView = example.getPageView();
        pageView.setQueryResult(this.beautyExtendMapper.selectByExampleByPage(example));
        return pageView;
    }
}