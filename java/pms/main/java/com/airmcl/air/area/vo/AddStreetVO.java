package com.airmcl.air.area.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author xuhui
 * @Date 2018/4/19 上午10:43
 */
public class AddStreetVO implements Serializable {

    //区ID
    private int areaId;
    //街道名称
    private List<String> streets;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public List<String> getStreets() {
        return streets;
    }

    public void setStreets(List<String> streets) {
        this.streets = streets;
    }
}
