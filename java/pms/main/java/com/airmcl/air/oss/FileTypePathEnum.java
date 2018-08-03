package com.airmcl.air.oss;

/**
 * @program: air-pms
 * @description: 文件类型对应地址枚举
 * @author: Mr.Chen
 * @create: 2018-06-21 09:46
 **/
public enum FileTypePathEnum {

    beauticianPath("美容师图片地址","bcPath","image/mdd/beautician/aptitude/"),
    beauticianHeadpicPath("美容师头像图片地址","bhPath","image/mdd/beautician/headpic/"),
    servicePath("服务项目图片","sPath","image/mdd/service/service_cover/"),
    serviceBannerPath("服务项目轮播图图片","sbPath","image/mdd/service/service_banner/"),
    beauty("门店图片","btPath","image/mdd/beauty/beauty_cover/"),
    banner("轮播图","bPath","image/mdd/banner/banner/");

    private String key;
    private String code;
    private String value;


    public String getKey() {
        return key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    FileTypePathEnum(String code, String key, String value) {
        this.key = key;
        this.code = code;
        this.value = value;
    }
}
