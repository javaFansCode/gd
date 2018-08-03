package com.airmcl.air.coupon.entity;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: wzy
 * Date: 2018/4/2
 * Time: 16:58
 */
public class CouponTitleVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String title;

    private String money;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
