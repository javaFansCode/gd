package com.airmcl.air.app.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="图片路径记录表")
public class Photo implements Serializable {
    @ApiModelProperty("图片id")
    private Integer id;

    @ApiModelProperty("图片归属表的id 如评论的就是评论表的id")
    private Integer post_id;

    @ApiModelProperty("图片类型编号:beautician技师图片,beauty门店图片,service服务项目图片,order_comment订单评论图片,article_comment文章评论图片,product产品图片,banner轮播图,beauty_paper资质证书,service_partner合伙人")
    private String type_code;

    @ApiModelProperty("图片显示排序越大越前")
    private Short sort;

    @ApiModelProperty("原图路径")
    private String original_path;

    @ApiModelProperty("缩略图路径")
    private String thumb_path;

    @ApiModelProperty("图片上传时间")
    private Integer createtime;

    @ApiModelProperty("是否删除（2已删除 1未删除）")
    private Byte isdelete;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code == null ? null : type_code.trim();
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public String getOriginal_path() {
        return original_path;
    }

    public void setOriginal_path(String original_path) {
        this.original_path = original_path == null ? null : original_path.trim();
    }

    public String getThumb_path() {
        return thumb_path;
    }

    public void setThumb_path(String thumb_path) {
        this.thumb_path = thumb_path == null ? null : thumb_path.trim();
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Byte getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Byte isdelete) {
        this.isdelete = isdelete;
    }
}