package com.airmcl.air.beautician.service.impl;

import com.airmcl.air.beautician.dao.BeauticianWorktimeMapper;
import com.airmcl.air.beautician.entity.BeauticianWorktime;
import com.airmcl.air.beautician.entity.BeauticianWorktimeExample;
import com.airmcl.air.beautician.service.BeauticianWorktimeService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBeauticianWorktimeService")
public class BeauticianWorktimeServiceImpl implements BeauticianWorktimeService {
    @Resource
    protected BeauticianWorktimeMapper beauticianWorktimeMapper;

    @CacheEvict(value={"beauticianWorktime"}, allEntries=true)
    @Override
    public void addObj(BeauticianWorktime t) {
        this.beauticianWorktimeMapper.insertSelective(t);
    }

    @CacheEvict(value={"beauticianWorktime"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.beauticianWorktimeMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beauticianWorktime"}, allEntries=true)
    @Override
    public void modifyObj(BeauticianWorktime t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.beauticianWorktimeMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="beauticianWorktime", keyGenerator="redisKeyGenerator")
    @Override
    public BeauticianWorktime queryObjById(Integer id) {
        return this.beauticianWorktimeMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="beauticianWorktime", key="'BeauticianWorktimeService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BeauticianWorktime> queryAllObjByExample(BeauticianWorktimeExample example) {
        return this.beauticianWorktimeMapper.selectByExample(example);
    }

    @Cacheable(value="beauticianWorktime", key="'BeauticianWorktimeService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BeauticianWorktime> queryObjByPage(BeauticianWorktimeExample example) {
        PageView<BeauticianWorktime> pageView = example.getPageView();
        pageView.setQueryResult(this.beauticianWorktimeMapper.selectByExampleByPage(example));
        return pageView;
    }
}