package com.zhineng.test.domain.po;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;
    private Integer userId;
    private String messageContent;
    private Integer messageStatus; //0未读，1已读

    public Message() {

    }

    public Message(Integer userId, String messageContent, Integer messageStatus) {
        this.userId = userId;
        this.messageContent = messageContent;
        this.messageStatus = messageStatus;
    }

    public Integer getMessageId() {
        return this.messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessageContent() {
        return this.messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Integer getMessageStatus() {
        return this.messageStatus;
    }

    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
    }
}
