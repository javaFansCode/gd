package com.airmcl.air.coupon.dao;

import com.airmcl.air.coupon.entity.CouponService;
import com.airmcl.air.coupon.entity.CouponServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponServiceMapper {
    int countByExample(CouponServiceExample example);

    int deleteByExample(CouponServiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CouponService record);

    int insertSelective(CouponService record);

    List<CouponService> selectByExample(CouponServiceExample example);

    CouponService selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CouponService record, @Param("example") CouponServiceExample example);

    int updateByExample(@Param("record") CouponService record, @Param("example") CouponServiceExample example);

    int updateByPrimaryKeySelective(CouponService record);

    int updateByPrimaryKey(CouponService record);

    void insertBatch(List<CouponService> list);

    List<CouponService> selectByExampleByPage(CouponServiceExample example);
}