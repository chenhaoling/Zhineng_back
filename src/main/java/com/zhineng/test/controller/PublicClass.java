package com.zhineng.test.controller;

import com.zhineng.test.domain.po.Activity;
import com.zhineng.test.domain.po.GroupOfOrg;
import com.zhineng.test.domain.po.User;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PublicClass {
}


class ResponseActivity {

    public Integer activityId;
    public String activityName;
    public String activityType;
    public String activityDescription;
    public Timestamp activityTime;
    public Timestamp clockEndTIme;
    public Integer supposeNumber;
    public Integer attendanceNumber;

    public ResponseActivity() {

    }

    public ResponseActivity(Activity activity, Integer supposeNumber, Integer attendanceNumber) {
        List<String> typeList = new ArrayList<String>();
        typeList.add("支部大会");
        typeList.add("民主生活会");
        typeList.add("党小组学习会");
        typeList.add("志愿活动");
        typeList.add("其他学习会");

        this.activityId = activity.getActivityId();
        this.activityName = activity.getActivityName();
        this.activityType = typeList.get(activity.getActivityType() - 1);
        this.activityDescription = activity.getActivityDescription();
        this.activityTime = activity.getActivityTime();
        this.clockEndTIme = activity.getClockEndTIme();
        this.supposeNumber = supposeNumber;
        this.attendanceNumber = attendanceNumber;
    }

}

class ResponseGroup {
    public Integer groupId;
    public String groupName;
    public ResponseUser groupLeader;
    public List<ResponseUser> memberList;

    public ResponseGroup() { }

    public ResponseGroup(GroupOfOrg group, ResponseUser groupLeader, List<ResponseUser> memberList) {
        this.groupId = group.getGroupId();
        this.groupName = group.getGroupName();
        this.groupLeader = groupLeader;
        this.memberList = memberList;
    }
}

class ResponseUser {
    public Integer userId;
    public String userName;
    public String userIdCard;
    public String userRole;
    public String userIdentity;
    public Integer groupId;
    public Date userSecondBirthday;
    public String userSex;
    public Date userBirthday;
    public String userEduBackground;
    public String userMail;
    public String userPhone;

    public ResponseUser() {}

    public ResponseUser(User user) {
        List<String> roleList = new ArrayList<String>();
        roleList.add("无权限用户");
        roleList.add("党小组组长");
        roleList.add("支委成员");
        List<String> identityList = new ArrayList<String>();
        identityList.add("积极分子");
        identityList.add("发展对象");
        identityList.add("预备党员");
        identityList.add("党员");
        List<String> eduList = new ArrayList<String>();
        eduList.add("本科");
        eduList.add("硕士");
        eduList.add("博士");
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.userIdCard = user.getUserIdCard();
        this.userRole = roleList.get(user.getUserRole() - 1);
        this.userIdentity = identityList.get(user.getUserIdentity());
        this.groupId = user.getGroupId();
        this.userSecondBirthday = user.getUserSecondBirthday();
        this.userSex = user.getUserSex();
        this.userBirthday = user.getUserBirthday();
        this.userEduBackground = eduList.get(user.getUserEduBackground() - 1);
        this.userMail = user.getUserMail();
        this.userPhone = user.getUserPhone();
    }
}