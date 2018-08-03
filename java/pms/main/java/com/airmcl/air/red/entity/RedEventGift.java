package com.airmcl.air.red.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="红包事件触发礼物表")
public class RedEventGift implements Serializable {
    private Integer id;

    @ApiModelProperty("事件id")
    private Integer redEventId;

    @ApiModelProperty("1 = 优惠券")
    private Byte type;

    @ApiModelProperty("礼物id")
    private Integer giftId;

    @ApiModelProperty("价值")
    private BigDecimal discount;

    @ApiModelProperty("数量")
    private Integer num;

    @ApiModelProperty("状态 0删除 1启用")
    private Byte state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRedEventId() {
        return redEventId;
    }

    public void setRedEventId(Integer redEventId) {
        this.redEventId = redEventId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}