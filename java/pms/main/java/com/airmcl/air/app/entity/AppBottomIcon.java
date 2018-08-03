package com.airmcl.air.app.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="app底部管理")
public class AppBottomIcon implements Serializable {
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("选中时图标-大")
    private String maxSelectIcon;

    @ApiModelProperty("选中时图标")
    private String selectIcon;

    @ApiModelProperty("非选中图标-大")
    private String maxUnselectedIcon;

    @ApiModelProperty("非选中图标")
    private String unselectedIcon;

    @ApiModelProperty("字体颜色")
    private String fontColor;

    @ApiModelProperty("0=不是链接,1=是")
    private Byte isUrl;

    @ApiModelProperty("url链接")
    private String url;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("1=正常,0=删除")
    private Byte state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMaxSelectIcon() {
        return maxSelectIcon;
    }

    public void setMaxSelectIcon(String maxSelectIcon) {
        this.maxSelectIcon = maxSelectIcon == null ? null : maxSelectIcon.trim();
    }

    public String getSelectIcon() {
        return selectIcon;
    }

    public void setSelectIcon(String selectIcon) {
        this.selectIcon = selectIcon == null ? null : selectIcon.trim();
    }

    public String getMaxUnselectedIcon() {
        return maxUnselectedIcon;
    }

    public void setMaxUnselectedIcon(String maxUnselectedIcon) {
        this.maxUnselectedIcon = maxUnselectedIcon == null ? null : maxUnselectedIcon.trim();
    }

    public String getUnselectedIcon() {
        return unselectedIcon;
    }

    public void setUnselectedIcon(String unselectedIcon) {
        this.unselectedIcon = unselectedIcon == null ? null : unselectedIcon.trim();
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor == null ? null : fontColor.trim();
    }

    public Byte getIsUrl() {
        return isUrl;
    }

    public void setIsUrl(Byte isUrl) {
        this.isUrl = isUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}