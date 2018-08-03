package com.airmcl.air.scheduler.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airmcl.air.coupon.dao.CouponMapper;
import com.airmcl.air.coupon.entity.Coupon;
import com.airmcl.air.coupon.entity.CouponExample;
import com.airmcl.air.scheduler.service.CouponJobService;
import com.airmcl.basae.utils.DateUtil;

@Service
public class CouponJobServiceImpl implements CouponJobService {
     
	@Resource
	protected  CouponMapper couponMapper;
	
	@Transactional
	@Override
	public int batchUpdateCouponState() throws RuntimeException {
		// TODO Auto-generated method stub
		int result = 0;
		CouponExample example = new CouponExample();
		example.createCriteria().andStateNotEqualTo((byte)0)
		.andExpiryTypeEqualTo((byte)2);
		example.setOrderByClause("expiry asc");
		List<Coupon> couponList = couponMapper.selectByExample(example);
		if(couponList==null||couponList.size()==0){
			return result;
		}
		int systemTime = DateUtil.getTimestamp(0);
		List<Integer> listIds = new ArrayList<Integer>();
		for (int i = 0; i < couponList.size(); i++) {
			Coupon coupon = couponList.get(i);
			int expiry = coupon.getExpiry();
			if(expiry>systemTime){
				break;
			}
			Integer couponId = coupon.getId();
			listIds.add(couponId);
		}
		if(listIds.size()>0){
			CouponExample example2 = new CouponExample();
			example2.createCriteria().andIdIn(listIds);
			Coupon record = new Coupon();
			record.setState((byte)3);
			result=couponMapper.updateByExampleSelective(record, example2);
		}
		return result;
	}

}
