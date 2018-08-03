package com.airmcl.air.ledger.enter;

/**
 * @program: air-pms
 * @description:
 * @author: Mr.Chen
 * @create: 2018-06-14 11:22
 **/
@Deprecated
public class CenterChairmanParaVO {
    /**
     * 城市
     */
    private String city;
    /**
     * 区域
     */
    private String area;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "CenterChairmanParaVO{" +
                "city='" + city + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
