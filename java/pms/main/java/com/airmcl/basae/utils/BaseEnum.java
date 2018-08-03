package com.airmcl.basae.utils;

/**
 *
 * 基础枚举类
 *
 * @Author xuhui
 * @Date 2018/6/14 下午12:02
 */
public enum BaseEnum {

    //描述写在前面，Value写在后台
    TEST("成功", "SUCCESS"),

    // 优惠券使用类型
    COUPON_USE_TYPE_ONE("1", "满减"),
    COUPON_USE_TYPE_TWO("2", "现金抵扣"),
    COUPON_USE_TYPE_THREE("3", "直折"),
    COUPON_USE_TYPE_FOUR("4", "满折+减额上线"),
    COUPON_USE_TYPE_FIVES("5", "满折"),
    COUPON_USE_TYPE_SIX("6", "直折+减额上限"),


    //优惠券状态
    COUPON_STATE_UNUSED("1", "未使用"),
    COUPON_STATE_USED("2", "已使用"),
    COUPON_STATE_EXPIRED("3", "已过期")
    ;

    private String desc;
    private String value;

    private BaseEnum(String desc, String value) {
        this.desc = desc;
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDesc(String value) {
        for (BaseEnum e : BaseEnum.values()) {
            if (e.getValue() == value) {
                return e.desc;
            }
        }
        return null;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public static String getValue(String desc) {
        for (BaseEnum e : BaseEnum.values()) {
            if (e.getDesc() == desc) {
                return e.value;
            }
        }
        return null;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
