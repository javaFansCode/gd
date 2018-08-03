package com.airmcl.air.carefreecard.service.impl;

import com.airmcl.air.carefreecard.dao.CareFreeCardMapper;
import com.airmcl.air.carefreecard.entity.CareFreeCard;
import com.airmcl.air.carefreecard.entity.CareFreeCardExample;
import com.airmcl.air.carefreecard.service.CareFreeCardService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultCareFreeCardService")
public class CareFreeCardServiceImpl implements CareFreeCardService {
    @Resource
    protected CareFreeCardMapper careFreeCardMapper;

    @CacheEvict(value={"careFreeCard"}, allEntries=true)
    @Override
    public void addObj(CareFreeCard t) {
        this.careFreeCardMapper.insertSelective(t);
    }

    @CacheEvict(value={"careFreeCard"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.careFreeCardMapper.deleteByPrimaryKey(id.toString());
    }

    @CacheEvict(value={"careFreeCard"}, allEntries=true)
    @Override
    public void modifyObj(CareFreeCard t) {
        if (StringUtils.isEmpty(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.careFreeCardMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="careFreeCard", keyGenerator="redisKeyGenerator")
    @Override
    public CareFreeCard queryObjById(Integer id) {
        return this.careFreeCardMapper.selectByPrimaryKey(id.toString());
    }

    @Cacheable(value="careFreeCard", key="'CareFreeCardService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<CareFreeCard> queryAllObjByExample(CareFreeCardExample example) {
        return this.careFreeCardMapper.selectByExample(example);
    }

    @Cacheable(value="careFreeCard", key="'CareFreeCardService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<CareFreeCard> queryObjByPage(CareFreeCardExample example) {
        PageView<CareFreeCard> pageView = example.getPageView();
        pageView.setQueryResult(this.careFreeCardMapper.selectByExampleByPage(example));
        return pageView;
    }
}