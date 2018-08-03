package com.airmcl.air.app.service.impl;

import com.airmcl.air.app.dao.AppBottomIconMapper;
import com.airmcl.air.app.entity.AppBottomIcon;
import com.airmcl.air.app.entity.AppBottomIconExample;
import com.airmcl.air.app.service.AppBottomIconService;
import com.els.base.core.entity.PageView;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultAppBottomIconService")
public class AppBottomIconServiceImpl implements AppBottomIconService {
    @Resource
    protected AppBottomIconMapper appBottomIconMapper;

    @CacheEvict(value={"appBottomIcon"}, allEntries=true)
    @Override
    public void addObj(AppBottomIcon t) {
        this.appBottomIconMapper.insertSelective(t);
    }

    @CacheEvict(value={"appBottomIcon"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.appBottomIconMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"appBottomIcon"}, allEntries=true)
    @Override
    public void modifyObj(AppBottomIcon t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.appBottomIconMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="appBottomIcon", keyGenerator="redisKeyGenerator")
    @Override
    public AppBottomIcon queryObjById(Integer id) {
        return this.appBottomIconMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="appBottomIcon", key="'AppBottomIconService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<AppBottomIcon> queryAllObjByExample(AppBottomIconExample example) {
        return this.appBottomIconMapper.selectByExample(example);
    }

    @Cacheable(value="appBottomIcon", key="'AppBottomIconService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<AppBottomIcon> queryObjByPage(AppBottomIconExample example) {
        PageView<AppBottomIcon> pageView = example.getPageView();
        pageView.setQueryResult(this.appBottomIconMapper.selectByExampleByPage(example));
        return pageView;
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public int updateStateByIds(int[] ids) {

        return appBottomIconMapper.updateStateByIds(ids);
    }
}