package com.example.pc.kotlindemo;

import java.io.Serializable;

/**
 * Created by wangwei on 2017/9/16.
 */
public class ByWorkBean implements Serializable {
    public String projectId;
    public String isMaint;           //是否保养  0否 1是
    public String projectName;
    public String standard;
    public String keywords;
    public String content;
    public String isShowNote = "";
    public String imgUri;
    private String remark;
    private String images;
    public int checked;

    /**
     * projectId : 1
     * isMaint : 0
     * remark : 这是备注
     * images : "imageUrl;imageUrl;imageUrl"
     */

    @Override
    public String toString() {
        return "ByWorkBean{" +
                "projectId='" + projectId + '\'' +
                ", isMaint='" + isMaint + '\'' +
                ", content='" + content + '\'' +
                ", projectName='" + projectName + '\'' +
                ", standard='" + standard + '\'' +
                ", keywords='" + keywords + '\'' +
                ", isShowNote='" + isShowNote + '\'' +
                '}';
    }

//    public int getChecked() {
//        return checked;
//    }
//
//    public void setChecked(int checked) {
//        this.checked = checked;
//    }

    public String getIsShowNote() {
        return isShowNote;
    }

    public void setIsShowNote(String isShowNote) {
        this.isShowNote = isShowNote;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getIsMaint() {
        return isMaint;
    }

    public void setIsMaint(String isMaint) {
        this.isMaint = isMaint;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
