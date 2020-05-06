package com.zhineng.test.domain.po;

import javax.persistence.*;

@Entity
@Table(name = "UserConnetion")
public class UserConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer connectionId;
    private Integer rootId;     //培养联系人或者入党介绍人
    private Integer leaveId;   //被发展的
    private Integer relationType;  //1是培养联系人，2是入党介绍人

    public UserConnection() {

    }

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public Integer getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(Integer connectionId) {
        this.connectionId = connectionId;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Integer getRelationType() {
        return relationType;
    }

    public void setRelationType(Integer relationType) {
        this.relationType = relationType;
    }

    public UserConnection(Integer rootId, Integer leaveId, Integer relationType) {
        this.rootId = rootId;
        this.leaveId = leaveId;
        this.relationType = relationType;
    }
    @Override
    public String toString() {
        return "UserConnection{" +
                "connectionId=" + connectionId +
                ", rootId=" + rootId +
                ", leaveId=" + leaveId +
                ", relationType=" + relationType +
                '}';
    }





}
