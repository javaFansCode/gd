package com.airmcl.air.users.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="会员受益人")
public class UsersEditRefereeParaVO implements Serializable {
 

    @ApiModelProperty("用户id")
    private String userId;
 
    @ApiModelProperty("收益人手机号")
    private String refereeMobile;

    @ApiModelProperty("受益人id(如果是首次购买的会员,去门店受益人,如果是兑换的,取对方返回的受益人)")
    private String refereeId;

    @ApiModelProperty("受益人姓名")
    private String refereeName;

    private static final long serialVersionUID = 1L;

 
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
 
    public String getRefereeMobile() {
        return refereeMobile;
    }

    public void setRefereeMobile(String refereeMobile) {
        this.refereeMobile = refereeMobile == null ? null : refereeMobile.trim();
    }

    public String getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(String refereeId) {
        this.refereeId = refereeId == null ? null : refereeId.trim();
    }

    public String getRefereeName() {
        return refereeName;
    }

    public void setRefereeName(String refereeName) {
        this.refereeName = refereeName == null ? null : refereeName.trim();
    }
}