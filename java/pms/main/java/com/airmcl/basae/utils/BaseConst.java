package com.airmcl.basae.utils;

/**
 *
 * 基础常量类
 *
 * @Author xuhui
 * @Date 2018/6/14 下午12:02
 */
public final class BaseConst {

    /**
     * 用户中心
     * 接口HOST地址
     */
    public static final String UC_HOST = "https://passport.airmcl.com/";

    /**
     * 用户中心
     * 根据手机号或者ucopenid获取用户信息接口地址
     */
    public static final String UC_MEMBER_QUERY_URL = "uc/api/apps/member/query";

    /**
     * 编码生成类型
     * 1：全字母
     * 2：全数字
     * 3：数字+字母
     */
    public static Byte GENERATE_TYPE_ALL_ABC = 1;
    public static Byte GENERATE_TYPE_ALL_NUMBER = 2;
    public static Byte GENERATE_TYPE_NUMBER_AND_ABC = 3;

    /**
     * 技师主表 账号状态
     * 0: 已删除
     * 1: 正常
     * 2: 待验证
     * 4: 下架
     */
    public static Byte BEAUTICIAN_STATE_DELETE = 0;
    public static Byte BEAUTICIAN_STATE_NORMAL = 1;
    public static Byte BEAUTICIAN_STATE_VERIFIED = 2;
    public static Byte BEAUTICIAN_STATE_DOWN = 4;

    /**
     * 门店主表 门店状态
     * 1: 正常
     * 0: 删除
     * 4: 下架
     */
    public static Byte BEAUTY_STATE_DELETE = 0;
    public static Byte BEAUTY_STATE_NORMAL = 1;
    public static Byte BEAUTY_STATE_DOWN = 4;
}
