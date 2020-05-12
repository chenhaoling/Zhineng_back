package com.zhineng.test.controller;

import com.zhineng.test.biz.GroupService;
import com.zhineng.test.biz.impl.ActivityServiceImpl;
import com.zhineng.test.domain.po.Activity;
import com.zhineng.test.domain.po.GroupOfOrg;
import com.zhineng.test.domain.po.User;
import com.zhineng.test.domain.po.UserClockHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private ActivityServiceImpl activityService;

    @RequestMapping("/getActivitiesOfGroup")
    @ResponseBody
    public List<ResponseActivity> getActivitiesOfGroup(@RequestParam Map<String, Object> params) {

        List<ResponseActivity> responseList = new ArrayList<ResponseActivity>();

        Integer groupId = Integer.parseInt((String) params.get("group_id"));

        List<Activity> activities = groupService.getActivitiesOfGroup(groupId);
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

    @RequestMapping("/getMembersOfGroup")
    @ResponseBody
    public List<ResponseUser> getMembersOfGroup(@RequestParam Map<String, Object> params) {
        List<ResponseUser> responseList = new ArrayList<ResponseUser>();

        Integer groupId = Integer.parseInt((String) params.get("group_id"));

        List<User> memberList = groupService.getMembersOfGroup(groupId);

        for (User user: memberList) {
            responseList.add(new ResponseUser(user));
        }

        return responseList;
    }

    @RequestMapping("/getLeadersOfOrganization")
    @ResponseBody
    public ResponseUser getLeadersOfOrganization(@RequestParam Map<String, Object> params) {
        ResponseUser leader = new ResponseUser();

        Integer groupId = Integer.parseInt((String) params.get("group_id"));

        List<User> memberList = groupService.getMembersOfGroup(groupId);

        for (User user: memberList) {
            if (user.getUserRole() == 2) {
                leader = new ResponseUser(user);
                break;
            }
        }

        return leader;
    }

    @RequestMapping("/getGroup")
    @ResponseBody
    public GroupOfOrg getGroup(@RequestParam Map<String, Object> params) throws ParseException {

        Integer groupId = Integer.parseInt((String) params.get("group_id"));

        return groupService.getGroup(groupId);
    }

}
