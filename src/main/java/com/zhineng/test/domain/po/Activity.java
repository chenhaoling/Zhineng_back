package com.zhineng.test.domain.po;

import javax.persistence.*;
import java.awt.*;
import java.io.*;
import java.sql.Timestamp;
import java.sql.Timestamp;

@Entity
@Table(name = "Activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;
    private String activityName;
    private Integer activityType;
    private String activityDescription;
    private Timestamp activityTime;
    private Timestamp clockEndTIme;
    private Double activityLongitude;
    private Double activityLatitude;

    public Activity() {

    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getActivityDescription() {
        return this.activityDescription;
    }

    public void setActivityDescription(String description) {
        this.activityDescription = description;
    }

    public Timestamp getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Timestamp activityTime) {
        this.activityTime = activityTime;
    }

    public Timestamp getClockEndTIme() {
        return clockEndTIme;
    }

    public void setClockEndTIme(Timestamp clockEndTIme) {
        this.clockEndTIme = clockEndTIme;
    }

    public Double getActivityLongitude() {
        return activityLongitude;
    }

    public void setActivityLongitude(Double activityLongitude) {
        this.activityLongitude = activityLongitude;
    }

    public Double getActivityLatitude() {
        return activityLatitude;
    }

    public void setActivityLatitude(Double activityLatitude) {
        this.activityLatitude = activityLatitude;
    }
}
