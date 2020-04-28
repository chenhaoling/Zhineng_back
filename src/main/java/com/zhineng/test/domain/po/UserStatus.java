package com.zhineng.test.domain.po;

import javax.persistence.*;
import java.awt.*;
import java.sql.Timestamp;

@Entity
@Table(name = "UserStatus")
public class UserStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userStatusId;
    private Integer userId;
    private Integer userStage;
    private Timestamp changeTime;

    public UserStatus() {

    }

    public UserStatus(Integer userId, Integer userStage, Timestamp changeTime) {
        this.userId = userId;
        this.userStage = userStage;
        this.changeTime = changeTime;
    }

    public Integer getUserStatusId() {
        return this.userStatusId;
    }

    public void setUserStatusId(Integer userStatusId) {
        this.userStatusId = userStatusId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserStage() {
        return this.userStage;
    }

    public void setUserStage(Integer userStage) {
        this.userStage = userStage;
    }

    public Timestamp getChangeTime() {
        return this.changeTime;
    }

    public void setChangeTime(Timestamp changeTime) {
        this.changeTime = changeTime;
    }

}
