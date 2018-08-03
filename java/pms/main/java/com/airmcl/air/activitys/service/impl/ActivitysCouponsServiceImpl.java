package com.airmcl.air.activitys.service.impl;

import com.airmcl.air.activitys.dao.ActivitysCouponsMapper;
import com.airmcl.air.activitys.entity.ActivitysCoupons;
import com.airmcl.air.activitys.entity.ActivitysCouponsExample;
import com.airmcl.air.activitys.service.ActivitysCouponsService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultActivitysCouponsService")
public class ActivitysCouponsServiceImpl implements ActivitysCouponsService {
    @Resource
    protected ActivitysCouponsMapper activitysCouponsMapper;

    @CacheEvict(value={"activitysCoupons"}, allEntries=true)
    @Override
    public void addObj(ActivitysCoupons t) {
        this.activitysCouponsMapper.insertSelective(t);
    }

    @CacheEvict(value={"activitysCoupons"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.activitysCouponsMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"activitysCoupons"}, allEntries=true)
    @Override
    public void modifyObj(ActivitysCoupons t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.activitysCouponsMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="activitysCoupons", keyGenerator="redisKeyGenerator")
    @Override
    public ActivitysCoupons queryObjById(Integer id) {
        return this.activitysCouponsMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="activitysCoupons", key="'ActivitysCouponsService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<ActivitysCoupons> queryAllObjByExample(ActivitysCouponsExample example) {
        return this.activitysCouponsMapper.selectByExample(example);
    }

    @Cacheable(value="activitysCoupons", key="'ActivitysCouponsService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<ActivitysCoupons> queryObjByPage(ActivitysCouponsExample example) {
        PageView<ActivitysCoupons> pageView = example.getPageView();
        pageView.setQueryResult(this.activitysCouponsMapper.selectByExampleByPage(example));
        return pageView;
    }
}