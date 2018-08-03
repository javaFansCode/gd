package com.airmcl.air.beautician.service.impl;

import com.airmcl.air.beautician.dao.BeauticianExtendMapper;
import com.airmcl.air.beautician.entity.BeauticianExtend;
import com.airmcl.air.beautician.entity.BeauticianExtendExample;
import com.airmcl.air.beautician.service.BeauticianExtendService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultBeauticianExtendService")
public class BeauticianExtendServiceImpl implements BeauticianExtendService {
    @Resource
    protected BeauticianExtendMapper beauticianExtendMapper;

    @CacheEvict(value={"beauticianExtend"}, allEntries=true)
    @Override
    public void addObj(BeauticianExtend t) {
        this.beauticianExtendMapper.insertSelective(t);
    }

    @CacheEvict(value={"beauticianExtend"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.beauticianExtendMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"beauticianExtend"}, allEntries=true)
    @Override
    public void modifyObj(BeauticianExtend t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.beauticianExtendMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="beauticianExtend", keyGenerator="redisKeyGenerator")
    @Override
    public BeauticianExtend queryObjById(Integer id) {
        return this.beauticianExtendMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="beauticianExtend", key="'BeauticianExtendService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<BeauticianExtend> queryAllObjByExample(BeauticianExtendExample example) {
        return this.beauticianExtendMapper.selectByExample(example);
    }

    @Cacheable(value="beauticianExtend", key="'BeauticianExtendService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<BeauticianExtend> queryObjByPage(BeauticianExtendExample example) {
        PageView<BeauticianExtend> pageView = example.getPageView();
        pageView.setQueryResult(this.beauticianExtendMapper.selectByExampleByPage(example));
        return pageView;
    }
}