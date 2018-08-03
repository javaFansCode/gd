package com.airmcl.air.oss.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="附件表")
public class MddAttachment implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("物理路径")
    private String url;

    @ApiModelProperty("宽度")
    private String imagewidth;

    @ApiModelProperty("宽度")
    private String imageheight;

    @ApiModelProperty("图片类型")
    private String imagetype;

    @ApiModelProperty("图片帧数")
    private Integer imageframes;

    @ApiModelProperty("文件大小")
    private Integer filesize;

    @ApiModelProperty("mime类型")
    private String mimetype;

    @ApiModelProperty("透传数据")
    private String extparam;

    @ApiModelProperty("创建日期")
    private Integer createtime;

    @ApiModelProperty("更新时间")
    private Integer updatetime;

    @ApiModelProperty("上传时间")
    private Integer uploadtime;

    @ApiModelProperty("存储位置 'local','qiniu'")
    private String storage;

    @ApiModelProperty("图片上传所属分类")
    private String imagemodel;

    @ApiModelProperty("上传区块")
    private String bucket;

    @ApiModelProperty("文件 sha1编码")
    private String sha1;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getImagewidth() {
        return imagewidth;
    }

    public void setImagewidth(String imagewidth) {
        this.imagewidth = imagewidth == null ? null : imagewidth.trim();
    }

    public String getImageheight() {
        return imageheight;
    }

    public void setImageheight(String imageheight) {
        this.imageheight = imageheight == null ? null : imageheight.trim();
    }

    public String getImagetype() {
        return imagetype;
    }

    public void setImagetype(String imagetype) {
        this.imagetype = imagetype == null ? null : imagetype.trim();
    }

    public Integer getImageframes() {
        return imageframes;
    }

    public void setImageframes(Integer imageframes) {
        this.imageframes = imageframes;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype == null ? null : mimetype.trim();
    }

    public String getExtparam() {
        return extparam;
    }

    public void setExtparam(String extparam) {
        this.extparam = extparam == null ? null : extparam.trim();
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Integer getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Integer updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Integer uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage == null ? null : storage.trim();
    }

    public String getImagemodel() {
        return imagemodel;
    }

    public void setImagemodel(String imagemodel) {
        this.imagemodel = imagemodel == null ? null : imagemodel.trim();
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket == null ? null : bucket.trim();
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1 == null ? null : sha1.trim();
    }
}