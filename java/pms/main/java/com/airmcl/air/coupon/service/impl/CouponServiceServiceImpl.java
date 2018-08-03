package com.airmcl.air.coupon.service.impl;

import com.airmcl.air.coupon.dao.CouponServiceMapper;
import com.airmcl.air.coupon.entity.CouponService;
import com.airmcl.air.coupon.entity.CouponServiceExample;
import com.airmcl.air.coupon.service.CouponServiceService;
import com.els.base.core.entity.PageView;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultCouponServiceService")
public class CouponServiceServiceImpl implements CouponServiceService {
    @Resource
    protected CouponServiceMapper couponServiceMapper;

    @CacheEvict(value={"couponService"}, allEntries=true)
    @Override
    public void addObj(CouponService t) {
        this.couponServiceMapper.insertSelective(t);
    }

    @CacheEvict(value={"couponService"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.couponServiceMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"couponService"}, allEntries=true)
    @Override
    public void modifyObj(CouponService t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.couponServiceMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="couponService", keyGenerator="redisKeyGenerator")
    @Override
    public CouponService queryObjById(Integer id) {
        return this.couponServiceMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="couponService", key="'CouponServiceService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public List<CouponService> queryAllObjByExample(CouponServiceExample example) {
        return this.couponServiceMapper.selectByExample(example);
    }

    @Cacheable(value="couponService", key="'CouponServiceService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
    @Override
    public PageView<CouponService> queryObjByPage(CouponServiceExample example) {
        PageView<CouponService> pageView = example.getPageView();
        pageView.setQueryResult(this.couponServiceMapper.selectByExampleByPage(example));
        return pageView;
    }
}