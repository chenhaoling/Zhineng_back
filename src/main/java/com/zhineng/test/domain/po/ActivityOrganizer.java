package com.zhineng.test.domain.po;

import javax.persistence.*;
import java.awt.*;


@Entity
@Table(name = "ActivityOrganizer")
public class ActivityOrganizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aORelationId;
    private Integer activityId;
    private Integer organizationId;
    private Integer groupId;

    public ActivityOrganizer() {
    }

    public ActivityOrganizer(Integer activityId, Integer organizationId, Integer groupId) {
        this.activityId = activityId;
        this.organizationId = organizationId;
        this.groupId = groupId;
    }

    public Integer getAORelationId() {
        return aORelationId;
    }

    public void setAORelationId(Integer aORelationId) {
        this.aORelationId = aORelationId;
    }

    public Integer getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "ActivityOrganizer{" +
                "AORelationId=" + this.aORelationId +
                ", activityId=" + this.activityId +
                ", organizationId=" + this.organizationId +
                ", groupId=" + this.groupId +
                '}';
    }
}
