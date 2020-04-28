package com.zhineng.test.domain.po;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

@Entity
@Table(name = "Organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer organizationId;
    private String organizationName;
    private String organizationDescription;

    public Organization() {
    }

    public Organization(String organizationName, String organizationDescription) {
        this.organizationName = organizationName;
        this.organizationDescription = organizationDescription;
    }

    public Integer getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return this.organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return this.organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organizationId=" + this.organizationId +
                ", organizationName='" + this.organizationName + '\'' +
                ", organizationDescription=" + this.organizationDescription +
                '}';
    }
}
