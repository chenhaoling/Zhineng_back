package com.zhineng.test.controller;

import com.zhineng.test.biz.impl.ActivityServiceImpl;
import com.zhineng.test.biz.impl.GroupServiceImpl;
import com.zhineng.test.biz.impl.OrganizationServiceImpl;
import com.zhineng.test.domain.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Organization")
public class OrganizationController {

    @Autowired
    private OrganizationServiceImpl organizationService;

    @Autowired
    private ActivityServiceImpl activityService;

    @Autowired
    private GroupServiceImpl groupService;


    @RequestMapping("/getActivitiesOfOrganization")
    @ResponseBody
    public List<ResponseActivity> getActivitiesOfOrganization(@RequestParam Map<String, Object> params) {

        List<ResponseActivity> responseList = new ArrayList<ResponseActivity>();

        Integer organizationId = Integer.parseInt((String) params.get("organization_id"));

        List<Activity> activities = organizationService.getActivitiesOfOrganization(organizationId);
        for (Activity activity: activities) {
            List<UserClockHistory> userClockHistories = activityService.getActivityClockRecord(activity.getActivityId());
            Integer supposeNumber = userClockHistories.size();
            Integer attendanceNumber = 0;
            for (UserClockHistory userClockHistory: userClockHistories) {
                if (userClockHistory.getClockRecord() == 1) {
                    attendanceNumber ++;
                }
            }

            responseList.add(new ResponseActivity(activity, supposeNumber, attendanceNumber));
        }

        return responseList;
    }

    @RequestMapping("/getMembersOfOrganization")
    @ResponseBody
    public List<ResponseGroup> getMembersOfOrganization(@RequestParam Map<String, Object> params) {
        List<ResponseGroup> responseList = new ArrayList<ResponseGroup>();

        Integer organizationId = Integer.parseInt((String) params.get("organization_id"));

        List<GroupOfOrg> groupList = organizationService.getGroupsOfOrganization(organizationId);

        for (GroupOfOrg groupOfOrg: groupList) {
            List<ResponseUser> memberList = new ArrayList<ResponseUser>();
            ResponseUser groupLeader = null;

            for (User user: groupService.getMembersOfGroup(groupOfOrg.getGroupId())) {
                memberList.add(new ResponseUser(user));
                if (user.getUserRole() == 2) {
                    groupLeader = new ResponseUser(user);
                }
            }

            responseList.add(new ResponseGroup(groupOfOrg, groupLeader, memberList));
        }

        return responseList;
    }

    @RequestMapping("/getLeadersOfOrganization")
    @ResponseBody
    public List<ResponseUser> getLeadersOfOrganization(@RequestParam Map<String, Object> params) {
        List<ResponseUser> responseList = new ArrayList<ResponseUser>();

        Integer organizationId = Integer.parseInt((String) params.get("organization_id"));

        List<GroupOfOrg> groupList = organizationService.getGroupsOfOrganization(organizationId);

        for (GroupOfOrg groupOfOrg: groupList) {
            if (groupOfOrg.getGroupName() == "党支部委员会") {
                for (User user : groupService.getMembersOfGroup(groupOfOrg.getGroupId())) {
                    responseList.add(new ResponseUser(user));
                    if (user.getUserRole() >= 2) {
                        responseList.add(new ResponseUser(user));
                    }
                }
            }
        }

        return responseList;
    }

    @RequestMapping("/CreateGroup")
    @ResponseBody
    public Integer CreateGroup(@RequestParam Map<String, Object> params) {

        String groupName = (String) params.get("group_name");
        Integer organizationId = Integer.parseInt((String) params.get("organization_id"));

        GroupOfOrg groupOfOrg = new GroupOfOrg();
        groupOfOrg.setGroupName(groupName);
        groupOfOrg.setOrganizationId(organizationId);

        GroupOfOrg new_group = organizationService.createGroupOfOrganization(groupOfOrg);

        return new_group.getGroupId();
    }

    @RequestMapping("/CreateUser")
    @ResponseBody
    public Integer CreateUser(@RequestParam Map<String, Object> params) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Integer groupId = Integer.parseInt((String) params.get("group_id"));
        try {
            groupService.getGroup(groupId);
        }
        catch (Exception e) {
            return -1;
        }
        String userName = (String) params.get("user_name");
        String userIdCard = (String) params.get("user_id_card");
        int userRole = Integer.parseInt((String) params.get("user_role"));
        if (userRole == 1) {
            try {
                for (User user: groupService.getMembersOfGroup(groupId)) {
                    if (user.getUserRole() == 2) {
                        return -2;
                    }
                }
            }
            catch (Exception ignored) {
            }
        }
        Integer userIdentity = Integer.parseInt((String) params.get("user_identity"));
        Date userSecondBirthday = null;
        try {
            userSecondBirthday = (Date) sdf.parse((String) params.get("user_second_birthday"));
        }
        catch (Exception ignored) {
        }
        String userSex = (String) params.get("user_sex");
        Date userBirthday = (Date) sdf.parse((String) params.get("user_birthday"));
        Integer userEduBackground = Integer.parseInt((String) params.get("user_edu_background"));
        String userMail = (String) params.get("user_mail");
        String userPhone = (String) params.get("user_phone");
        String userNation = (String) params.get("user_nation");
        String userOccupation = (String) params.get("user_occupation");

        User user = new User();
        user.setGroupId(groupId);
        user.setUserBirthday(userBirthday);
        user.setUserEduBackground(userEduBackground);
        user.setUserMail(userMail);
        user.setUserName(userName);
        user.setUserIdCard(userIdCard);
        user.setUserRole(userRole);
        user.setUserIdentity(userIdentity);
        user.setUserSecondBirthday(userSecondBirthday);
        user.setUserSex(userSex);
        user.setUserPhone(userPhone);
        user.setUserNation(userNation);
        user.setUserOccupation(userOccupation);

        return organizationService.createUserOfOrganization(user).getUserId();
    }

    @RequestMapping("/getOrganization")
    @ResponseBody
    public Organization getOrganization(@RequestParam Map<String, Object> params) throws ParseException {

        Integer groupId = Integer.parseInt((String) params.get("group_id"));
        System.out.println(groupId);

        GroupOfOrg group = groupService.getGroup(groupId);
        System.out.println(group.getOrganizationId());

        return organizationService.getOrganizationById(group.getOrganizationId());
    }
}