package com.airmcl.air.service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="设备关联服务类型表")
public class ServiceTypeEquipment implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("服务类型")
    private Integer serviceType;

    @ApiModelProperty("设备类型id")
    private String equipmentTypeId;

    @ApiModelProperty("设备id")
    private String equipmentId;

    @ApiModelProperty("状态(1:可用,0删除)")
    private Byte state;

    @ApiModelProperty("创建时间")
    private Integer createtime;

    @ApiModelProperty("是否需要扫码开启设备(0不需要 1需要)")
    private Byte isScan;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(String equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId == null ? null : equipmentTypeId.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Byte getIsScan() {
        return isScan;
    }

    public void setIsScan(Byte isScan) {
        this.isScan = isScan;
    }
}