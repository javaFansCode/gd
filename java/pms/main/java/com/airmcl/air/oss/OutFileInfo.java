package com.airmcl.air.oss;

/**
 * @program: air-pms
 * @description: 文件上次输出结果
 * @author: Mr.Chen
 * @create: 2018-06-21 13:43
 **/
public class OutFileInfo {

    private String fileName;
    private String fiseSize;
    private String width;
    private String height;
    private String mimeType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFiseSize() {
        return fiseSize;
    }

    public void setFiseSize(String fiseSize) {
        this.fiseSize = fiseSize;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
