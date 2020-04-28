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

    public UserConnection(Integer rootId, Integer leaveId, Integer relationType) {
        this.rootId = rootId;
        this.leaveId = leaveId;
        this.relationType = relationType;
    }

    Integer getConnectionId() {
        return this.connectionId;
    }

    void setConnectionId(Integer connectionId) {
        this.connectionId = connectionId;
    }

    Integer getNodeId() {
        return this.rootId;
    }

    void setNodeId(Integer rootId) {
        this.rootId = rootId;
    }

    Integer getLeaveId() {
        return this.leaveId;
    }

    void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    Integer getRelationType() {
        return this.relationType;
    }

    void setRelationType(Integer relationType) {
        this.relationType = relationType;
    }

}
