package com.airmcl.air.red.service.impl;

import com.airmcl.air.red.dao.RedEventGiftMapper;
import com.airmcl.air.red.entity.RedEventGift;
import com.airmcl.air.red.entity.RedEventGiftExample;
import com.airmcl.air.red.service.RedEventGiftService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultRedEventGiftService")
public class RedEventGiftServiceImpl implements RedEventGiftService {
    @Resource
    protected RedEventGiftMapper redEventGiftMapper;

    @CacheEvict(value={"redEventGift"}, allEntries=true)
    @Override
    public void addObj(RedEventGift t) {
        this.redEventGiftMapper.insertSelective(t);
    }

    @CacheEvict(value={"redEventGift"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.redEventGiftMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"redEventGift"}, allEntries=true)
    @Override
    public void modifyObj(RedEventGift t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.redEventGiftMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="redEventGift", keyGenerator="redisKeyGenerator")
    @Override
    public RedEventGift queryObjById(Integer id) {
        return this.redEventGiftMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="redEventGift", key="'RedEventGiftService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<RedEventGift> queryAllObjByExample(RedEventGiftExample example) {
        return this.redEventGiftMapper.selectByExample(example);
    }

    @Cacheable(value="redEventGift", key="'RedEventGiftService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<RedEventGift> queryObjByPage(RedEventGiftExample example) {
        PageView<RedEventGift> pageView = example.getPageView();
        pageView.setQueryResult(this.redEventGiftMapper.selectByExampleByPage(example));
        return pageView;
    }
}