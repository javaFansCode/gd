package com.airmcl.air.comments.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.io.Serializable;

@ApiModel(value="v_mdd_api_comments_beauty_beautician")
public class CommentsExt implements Serializable {
    @ApiModelProperty("评论主表id")
    private Integer id;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("项目名称(+号隔开)")
    private String serviceName;

    @ApiModelProperty("美容院名称")
    private String beautyName;

    @ApiModelProperty("技师名称")
    private String name;

    @ApiModelProperty("是否已回复0未回复 1已回复")
    private Byte isReply;

    @ApiModelProperty("状态，1已审核，2未审核 0删除  3：下架")
    private Byte state;

    private Integer[] commentstate;

    //用与查询传参 状态
    public Integer[] getCommentstate() {
        return commentstate;
    }

    public void setCommentstate(Integer[] commentstate) {
        this.commentstate = commentstate;
    }

    @ApiModelProperty("评论内容")
    private String content;

    private Integer pageNo;
    private Integer pageSize;

    private Integer	startcreatetime;
    private Integer	endcreatetime;

    public Integer getStartcreatetime() {
        return startcreatetime;
    }

    public void setStartcreatetime(Integer startcreatetime) {
        this.startcreatetime = startcreatetime;
    }

    public Integer getEndcreatetime() {
        return endcreatetime;
    }

    public void setEndcreatetime(Integer endcreatetime) {
        this.endcreatetime = endcreatetime;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public String getNickname() {
//        return nickname;
//    }
//
//    public void setNickname(String nickname) {
//        this.nickname = nickname == null ? null : nickname.trim();
//    }

//    public String getServiceName() {
//        return serviceName;
//    }
//
//    public void setServiceName(String serviceName) {
//        this.serviceName = serviceName == null ? null : serviceName.trim();
//    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getBeautyName() {
        return beautyName;
    }

    public void setBeautyName(String beautyName) {
        this.beautyName = beautyName == null ? null : beautyName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getIsReply() {
        return isReply;
    }

    public void setIsReply(Byte isReply) {
        this.isReply = isReply;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}