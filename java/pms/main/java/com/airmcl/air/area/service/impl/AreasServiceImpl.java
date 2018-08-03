package com.airmcl.air.area.service.impl;

import com.airmcl.air.area.dao.AreasMapper;
import com.airmcl.air.area.entity.Areas;
import com.airmcl.air.area.entity.AreasExample;
import com.airmcl.air.area.service.AreasService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultAreasService")
public class AreasServiceImpl implements AreasService {
    @Resource
    protected AreasMapper areasMapper;

    @CacheEvict(value={"areas"}, allEntries=true)
    @Override
    public void addObj(Areas t) {
        this.areasMapper.insertSelective(t);
    }

    @CacheEvict(value={"areas"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.areasMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"areas"}, allEntries=true)
    @Override
    public void modifyObj(Areas t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.areasMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="areas", keyGenerator="redisKeyGenerator")
    @Override
    public Areas queryObjById(Integer id) {
        return this.areasMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="areas", key="'AreasService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<Areas> queryAllObjByExample(AreasExample example) {
        return this.areasMapper.selectByExample(example);
    }

    @Cacheable(value="areas", key="'AreasService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<Areas> queryObjByPage(AreasExample example) {
        PageView<Areas> pageView = example.getPageView();
        pageView.setQueryResult(this.areasMapper.selectByExampleByPage(example));
        return pageView;
    }
}