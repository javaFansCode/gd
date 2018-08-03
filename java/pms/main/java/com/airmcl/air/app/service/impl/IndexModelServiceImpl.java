package com.airmcl.air.app.service.impl;

import com.airmcl.air.app.dao.IndexModelMapper;
import com.airmcl.air.app.entity.IndexModel;
import com.airmcl.air.app.entity.IndexModelExample;
import com.airmcl.air.app.service.IndexModelService;
import com.els.base.core.entity.PageView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultIndexModelService")
public class IndexModelServiceImpl implements IndexModelService {
    @Resource
    protected IndexModelMapper indexModelMapper;

    @CacheEvict(value={"indexModel"}, allEntries=true)
    @Override
    public void addObj(IndexModel t) {
        Integer createtime =Double.valueOf((new Date().getTime()/1000)).intValue();

        t.setCreatetime(createtime.toString());

        this.indexModelMapper.insertSelective(t);
    }

    @CacheEvict(value={"indexModel"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.indexModelMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"indexModel"}, allEntries=true)
    @Override
    public void modifyObj(IndexModel t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.indexModelMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="indexModel", keyGenerator="redisKeyGenerator")
    @Override
    public IndexModel queryObjById(Integer id) {
        return this.indexModelMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="indexModel", key="'IndexModelService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<IndexModel> queryAllObjByExample(IndexModelExample example) {
        return this.indexModelMapper.selectByExample(example);
    }

    @Cacheable(value="indexModel", key="'IndexModelService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<IndexModel> queryObjByPage(IndexModelExample example) {
        PageView<IndexModel> pageView = example.getPageView();
        pageView.setQueryResult(this.indexModelMapper.selectByExampleByPage(example));
        return pageView;
    }
    /**
     * 批量删除
     * @param ids
     */
    @Override
    public int updateStateByIds(int[] ids) {

        return indexModelMapper.updateStateByIds(ids);
    }
}