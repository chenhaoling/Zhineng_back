package com.zhineng.test.domain.po;


import javax.persistence.*;
import java.awt.*;
import java.sql.Date;


@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String openId;
    private String userName;
    private String userIdCard;
    private Integer userRole;
    private Integer userIdentity;
    private Integer groupId;
    private Date userSecondBirthday;
    private String userSex;
    private Date userBirthday;
    private Integer userEduBackground;
    private String userMail;
    private String userPhone;
    private String userNation;
    private String userOccupation;

    public User() {

    }

    public String getUserMail() {
        return this.userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhone() {
        return this.userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserEduBackground() {
        return this.userEduBackground;
    }

    public void setUserEduBackground(Integer userEduBackground) {
        this.userEduBackground = userEduBackground;
    }

    public Date getUserBirthday() {
        return this.userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserSex() {
        return this.userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdCard() {
        return this.userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public Integer getUserRole() {
        return this.userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getUserIdentity() {
        return this.userIdentity;
    }

    public void setUserIdentity(Integer userIdentity) {
        this.userIdentity = userIdentity;
    }

    public Integer getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Date getUserSecondBirthday() {
        return this.userSecondBirthday;
    }

    public void setUserSecondBirthday(Date userSecondBirthday) {
        this.userSecondBirthday = userSecondBirthday;
    }

    public String getUserNation() {
        return this.userNation;
    }

    public void setUserNation(String nation) {
        this.userNation = nation;
    }

    public String getUserOccupation() {
        return this.userOccupation;
    }

    public void setUserOccupation(String occupation) {
        this.userOccupation = occupation;
    }
}
