package com.zhineng.test.domain.po;



import javax.persistence.*;
import java.awt.*;
@Entity
@Table(name = "GroupOfOrg")
public class GroupOfOrg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;
    private Integer organizationId;
    private String groupName;

    public GroupOfOrg() {

    }

    public GroupOfOrg(Integer organizationId, String groupName) {
        this.organizationId = organizationId;
        this.groupName = groupName;
    }

    public Integer getGroupId() {
        return this.groupId;
    }

    public Integer getOrganizationId() {
        return this.organizationId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "GroupOfOrg{" +
                "groupId=" + this.groupId +
                ", organizationId=" + this.organizationId +
                ", groupName='" + this.groupName + '\'' +
                '}';
    }
}
