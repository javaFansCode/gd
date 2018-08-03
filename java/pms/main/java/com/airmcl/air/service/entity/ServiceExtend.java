package com.airmcl.air.service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="服务项目扩展表")
public class ServiceExtend implements Serializable {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("服务项目ID")
    private Integer serviceId;

    @ApiModelProperty("产品功效")
    private String effect;

    @ApiModelProperty("内耗值")
    private Integer internalFriction;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建时间")
    private String createtime;

    @ApiModelProperty("项目简介")
    private String serviceDesc;

    @ApiModelProperty("服务步骤")
    private String serviceStep;

    @ApiModelProperty("适用人群")
    private String peopleUse;

    @ApiModelProperty("注意事项")
    private String note;

    @ApiModelProperty("服务项目内容")
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect == null ? null : effect.trim();
    }

    public Integer getInternalFriction() {
        return internalFriction;
    }

    public void setInternalFriction(Integer internalFriction) {
        this.internalFriction = internalFriction;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc == null ? null : serviceDesc.trim();
    }

    public String getServiceStep() {
        return serviceStep;
    }

    public void setServiceStep(String serviceStep) {
        this.serviceStep = serviceStep == null ? null : serviceStep.trim();
    }

    public String getPeopleUse() {
        return peopleUse;
    }

    public void setPeopleUse(String peopleUse) {
        this.peopleUse = peopleUse == null ? null : peopleUse.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}