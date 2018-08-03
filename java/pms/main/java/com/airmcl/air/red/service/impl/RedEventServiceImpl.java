package com.airmcl.air.red.service.impl;

import com.airmcl.air.red.dao.RedEventMapper;
import com.airmcl.air.red.entity.RedEvent;
import com.airmcl.air.red.entity.RedEventExample;
import com.airmcl.air.red.service.RedEventService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultRedEventService")
public class RedEventServiceImpl implements RedEventService {
    @Resource
    protected RedEventMapper redEventMapper;

    @CacheEvict(value={"redEvent"}, allEntries=true)
    @Override
    public void addObj(RedEvent t) {
        this.redEventMapper.insertSelective(t);
    }

    @CacheEvict(value={"redEvent"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.redEventMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"redEvent"}, allEntries=true)
    @Override
    public void modifyObj(RedEvent t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.redEventMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="redEvent", keyGenerator="redisKeyGenerator")
    @Override
    public RedEvent queryObjById(Integer id) {
        return this.redEventMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="redEvent", key="'RedEventService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<RedEvent> queryAllObjByExample(RedEventExample example) {
        return this.redEventMapper.selectByExample(example);
    }

    @Cacheable(value="redEvent", key="'RedEventService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<RedEvent> queryObjByPage(RedEventExample example) {
        PageView<RedEvent> pageView = example.getPageView();
        pageView.setQueryResult(this.redEventMapper.selectByExampleByPage(example));
        return pageView;
    }
}