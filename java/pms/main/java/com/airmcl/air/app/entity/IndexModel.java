package com.airmcl.air.app.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="首页模块显示表")
public class IndexModel implements Serializable {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("模块名称(active:活动,btpush:技师推荐,beauty:门店推荐,service:服务项目)")
    private String modelName;

    @ApiModelProperty("排序(越小排越前)")
    private Byte sort;

    @ApiModelProperty("状态(1:可用,2:禁用)")
    private Byte state;

    @ApiModelProperty("创建时间")
    private String createtime;

    @ApiModelProperty("模块内容")
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}