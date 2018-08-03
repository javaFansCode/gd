package com.airmcl.air.activitys.service.impl;

import com.airmcl.air.activitys.dao.ActivitysBeautyMapper;
import com.airmcl.air.activitys.entity.ActivitysBeauty;
import com.airmcl.air.activitys.entity.ActivitysBeautyExample;
import com.airmcl.air.activitys.service.ActivitysBeautyService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultActivitysBeautyService")
public class ActivitysBeautyServiceImpl implements ActivitysBeautyService {
    @Resource
    protected ActivitysBeautyMapper activitysBeautyMapper;

    @CacheEvict(value={"activitysBeauty"}, allEntries=true)
    @Override
    public void addObj(ActivitysBeauty t) {
        this.activitysBeautyMapper.insertSelective(t);
    }

    @CacheEvict(value={"activitysBeauty"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.activitysBeautyMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"activitysBeauty"}, allEntries=true)
    @Override
    public void modifyObj(ActivitysBeauty t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.activitysBeautyMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="activitysBeauty", keyGenerator="redisKeyGenerator")
    @Override
    public ActivitysBeauty queryObjById(Integer id) {
        return this.activitysBeautyMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="activitysBeauty", key="'ActivitysBeautyService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ActivitysBeauty> queryAllObjByExample(ActivitysBeautyExample example) {
        return this.activitysBeautyMapper.selectByExample(example);
    }

    @Cacheable(value="activitysBeauty", key="'ActivitysBeautyService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ActivitysBeauty> queryObjByPage(ActivitysBeautyExample example) {
        PageView<ActivitysBeauty> pageView = example.getPageView();
        pageView.setQueryResult(this.activitysBeautyMapper.selectByExampleByPage(example));
        return pageView;
    }
}