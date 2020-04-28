package com.zhineng.test.domain.po;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "ExtraUserInfo")
public class ExtraUserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer infoId;
    private Integer userId;
    private String extraInfoTitle;
    private String extraInfoContent;

    public ExtraUserInfo() {
    }

    public ExtraUserInfo(Integer userId, String extraInfoTitle, String extraInfoContent) {
        this.userId = userId;
        this.extraInfoTitle = extraInfoTitle;
        this.extraInfoContent = extraInfoContent;
    }

    public Integer getInfoId() {
        return this.infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExtraInfoTitle() {
        return this.extraInfoTitle;
    }

    public void setExtraInfoTitle(String extraInfoTitle) {
        this.extraInfoTitle = extraInfoTitle;
    }

    public String getExtraInfoContent() {
        return this.extraInfoContent;
    }

    public void setExtraInfoContent(String extraInfoContent) {
        this.extraInfoContent = extraInfoContent;
    }

    @Override
    public String toString() {
        return "ExtraUserInfo{" +
                "infoId=" + this.infoId +
                ", userId=" + this.userId +
                ", extraInfoTitle='" + this.extraInfoTitle + '\'' +
                ", extraInfoContent='" + this.extraInfoContent + '\'' +
                '}';
    }
}
