package com.zhineng.test.domain.po;

import javax.persistence.*;
import java.awt.*;
import java.sql.Timestamp;

@Entity
@Table(name = "userClockHistory")
public class UserClockHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userClockHistoryId;
    private Integer userId;
    private Integer activityId;
    private Integer clockRecord;
    private Timestamp ClockTime;

    public UserClockHistory() {

    }

    public Integer getUserClockHistoryId() {
        return userClockHistoryId;
    }

    public void setUserClockHistoryId(Integer userClockHistoryId) {
        this.userClockHistoryId = userClockHistoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getClockRecord() {
        return clockRecord;
    }

    public void setClockRecord(Integer clockRecord) {
        this.clockRecord = clockRecord;
    }

    public Timestamp getClockTime() {
        return ClockTime;
    }

    public void setClockTime(Timestamp clockTime) {
        ClockTime = clockTime;
    }
}
