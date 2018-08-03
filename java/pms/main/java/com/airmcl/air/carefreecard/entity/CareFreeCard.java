package com.airmcl.air.carefreecard.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="分发无忧卡")
public class CareFreeCard implements Serializable {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("无忧卡编号")
    private String card_number;

    @ApiModelProperty("商品无忧卡ID")
    private String goods_card_id;

    @ApiModelProperty("商品无忧卡名称")
    private String goods_card_name;

    @ApiModelProperty("密钥")
    private String secret_key;

    @ApiModelProperty("状态0：生成、1：打印、2：分发、3：激活")
    private Byte action_flag;

    @ApiModelProperty("门店名称")
    private String store_name;

    @ApiModelProperty("门店ID")
    private String store_id;

    @ApiModelProperty("客户姓名")
    private String customer_name;

    @ApiModelProperty("客户手机号")
    private String customer_mobile_phone;

    @ApiModelProperty("激活时间")
    private Date activation_time;

    @ApiModelProperty("创建时间")
    private Date create_time;

    @ApiModelProperty("修改时间")
    private Date update_time;

    @ApiModelProperty("是否删除（0：否 1：是）")
    private Byte is_delete;

    @ApiModelProperty("无忧卡分发数量")
    private Integer num;

    @ApiModelProperty("激活时间")
    private String activationTime;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("修改时间")
    private String updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number == null ? null : card_number.trim();
    }

    public String getGoods_card_id() {
        return goods_card_id;
    }

    public void setGoods_card_id(String goods_card_id) {
        this.goods_card_id = goods_card_id == null ? null : goods_card_id.trim();
    }

    public String getGoods_card_name() {
        return goods_card_name;
    }

    public void setGoods_card_name(String goods_card_name) {
        this.goods_card_name = goods_card_name == null ? null : goods_card_name.trim();
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key == null ? null : secret_key.trim();
    }

    public Byte getAction_flag() {
        return action_flag;
    }

    public void setAction_flag(Byte action_flag) {
        this.action_flag = action_flag;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name == null ? null : store_name.trim();
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id == null ? null : store_id.trim();
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name == null ? null : customer_name.trim();
    }

    public String getCustomer_mobile_phone() {
        return customer_mobile_phone;
    }

    public void setCustomer_mobile_phone(String customer_mobile_phone) {
        this.customer_mobile_phone = customer_mobile_phone == null ? null : customer_mobile_phone.trim();
    }

    public Date getActivation_time() {
        return activation_time;
    }

    public void setActivation_time(Date activation_time) {
        this.activation_time = activation_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Byte getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Byte is_delete) {
        this.is_delete = is_delete;
    }

    public String getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(String activationTime) {
        this.activationTime = activationTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}