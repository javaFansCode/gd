package com.airmcl.air.beautician.service.impl;

import com.airmcl.air.beautician.dao.BeauticianIntfMapper;
import com.airmcl.air.beautician.entity.BeauticianIntf;
import com.airmcl.air.beautician.entity.BeauticianIntfExample;
import com.airmcl.air.beautician.service.BeauticianIntfService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBeauticianIntfService")
public class BeauticianIntfServiceImpl implements BeauticianIntfService {
    @Resource
    protected BeauticianIntfMapper beauticianIntfMapper;

    @CacheEvict(value={"beauticianIntf"}, allEntries=true)
    @Override
    public void addObj(BeauticianIntf t) {
        this.beauticianIntfMapper.insertSelective(t);
    }

    @CacheEvict(value={"beauticianIntf"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.beauticianIntfMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beauticianIntf"}, allEntries=true)
    @Override
    public void modifyObj(BeauticianIntf t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.beauticianIntfMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="beauticianIntf", keyGenerator="redisKeyGenerator")
    @Override
    public BeauticianIntf queryObjById(Integer id) {
        return this.beauticianIntfMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="beauticianIntf", key="'BeauticianIntfService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BeauticianIntf> queryAllObjByExample(BeauticianIntfExample example) {
        return this.beauticianIntfMapper.selectByExample(example);
    }

    @Cacheable(value="beauticianIntf", key="'BeauticianIntfService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BeauticianIntf> queryObjByPage(BeauticianIntfExample example) {
        PageView<BeauticianIntf> pageView = example.getPageView();
        pageView.setQueryResult(this.beauticianIntfMapper.selectByExampleByPage(example));
        return pageView;
    }
}