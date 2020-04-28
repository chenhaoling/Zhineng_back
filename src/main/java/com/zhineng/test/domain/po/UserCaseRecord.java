package com.zhineng.test.domain.po;

import javax.persistence.*;
import java.awt.*;
import java.sql.Timestamp;

@Entity
@Table(name = "UserCaseRecord")
public class UserCaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userCaseRecordId;
    private Integer userId;
    private String fileName;
    private Integer fileType;
    private Timestamp submitDate;

    public Integer getUserCaseRecordId() {

        return userCaseRecordId;
    }

    public void setUserCaseRecordId(Integer userCaseRecordId) {
        this.userCaseRecordId = userCaseRecordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Timestamp getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Timestamp submitDate) {
        this.submitDate = submitDate;
    }

    public UserCaseRecord() {

    }


}
