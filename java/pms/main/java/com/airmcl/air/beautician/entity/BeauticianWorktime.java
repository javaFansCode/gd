package com.airmcl.air.beautician.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="技师工作预约时间记录表")
public class BeauticianWorktime implements Serializable {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("技师ID")
    private Integer btId;

    @ApiModelProperty("门店ID")
    private Integer beautyId;

    @ApiModelProperty("预约日期")
    private String currentdate;

    @ApiModelProperty("操作者ID")
    private Integer operateId;

    @ApiModelProperty("0:失效,1:被预约,2:可预约,")
    private Byte isrest;

    @ApiModelProperty("技师工作时间")
    private String workTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBtId() {
        return btId;
    }

    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    public Integer getBeautyId() {
        return beautyId;
    }

    public void setBeautyId(Integer beautyId) {
        this.beautyId = beautyId;
    }

    public String getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(String currentdate) {
        this.currentdate = currentdate == null ? null : currentdate.trim();
    }

    public Integer getOperateId() {
        return operateId;
    }

    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }

    public Byte getIsrest() {
        return isrest;
    }

    public void setIsrest(Byte isrest) {
        this.isrest = isrest;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime == null ? null : workTime.trim();
    }
}