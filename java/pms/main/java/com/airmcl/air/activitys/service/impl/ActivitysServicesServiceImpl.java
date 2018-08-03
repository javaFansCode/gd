package com.airmcl.air.activitys.service.impl;

import com.airmcl.air.activitys.dao.ActivitysServicesMapper;
import com.airmcl.air.activitys.entity.ActivitysServices;
import com.airmcl.air.activitys.entity.ActivitysServicesExample;
import com.airmcl.air.activitys.service.ActivitysServicesService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultActivitysServicesService")
public class ActivitysServicesServiceImpl implements ActivitysServicesService {
    @Resource
    protected ActivitysServicesMapper activitysServicesMapper;

    @CacheEvict(value={"activitysServices"}, allEntries=true)
    @Override
    public void addObj(ActivitysServices t) {
        this.activitysServicesMapper.insertSelective(t);
    }

    @CacheEvict(value={"activitysServices"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.activitysServicesMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"activitysServices"}, allEntries=true)
    @Override
    public void modifyObj(ActivitysServices t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.activitysServicesMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="activitysServices", keyGenerator="redisKeyGenerator")
    @Override
    public ActivitysServices queryObjById(Integer id) {
        return this.activitysServicesMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="activitysServices", key="'ActivitysServicesService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ActivitysServices> queryAllObjByExample(ActivitysServicesExample example) {
        return this.activitysServicesMapper.selectByExample(example);
    }

    @Cacheable(value="activitysServices", key="'ActivitysServicesService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ActivitysServices> queryObjByPage(ActivitysServicesExample example) {
        PageView<ActivitysServices> pageView = example.getPageView();
        pageView.setQueryResult(this.activitysServicesMapper.selectByExampleByPage(example));
        return pageView;
    }
}