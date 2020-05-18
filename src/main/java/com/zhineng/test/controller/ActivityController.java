package com.zhineng.test.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zhineng.test.biz.impl.ActivityServiceImpl;
import com.zhineng.test.biz.impl.MessageServiceImpl;
import com.zhineng.test.domain.po.Activity;
import com.zhineng.test.domain.po.UserClockHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Activity")
public class ActivityController {

    @Autowired
    private ActivityServiceImpl activityService;

    @Autowired
    private MessageServiceImpl messageService;

    @RequestMapping(value = "/CreateActivity")
    @ResponseBody
    public Integer CreateActivity(@RequestParam Map<String, Object> params) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String activityName = (String) params.get("activity_name");
        Integer activityType = Integer.parseInt((String) params.get("activity_type"));
        Date activityTime = sdf.parse((String) params.get("activity_time"));
        String activityDescription = (String) params.get("activity_description");
        Date clockEndTime = sdf.parse((String) params.get("clock_end_time"));
        double activityLongitude = Double.parseDouble((String) params.get("activity_longitude"));
        double activityLatitude = Double.parseDouble((String) params.get("activity_latitude"));

        List<Integer> participantList = PublicClass.getList((String) params.get("participant_list"));

        Integer organizationId = Integer.parseInt((String) params.get("organization_id"));
        Integer groupId = -1;
        try {
            groupId = Integer.parseInt((String) params.get("group_id"));
        }
        catch (Exception e) {
            groupId = -1;
        }
        try {
            Activity activity = new Activity();
            activity.setActivityName(activityName);
            activity.setActivityType(activityType);
            activity.setActivityTime(new java.sql.Timestamp(activityTime.getTime()));
            activity.setActivityDescription(activityDescription);
            activity.setClockEndTIme(new java.sql.Timestamp(clockEndTime.getTime()));
            activity.setActivityLongitude(activityLongitude);
            activity.setActivityLatitude(activityLatitude);

            Activity new_activity = activityService.createActivity(activity, organizationId, groupId);

            activityService.addClockRecordOfActivity(new_activity.getActivityId(), new_activity.getActivityName(), participantList);

            messageService.sendMessagesToUsers(participantList, "您有新的活动签到，请注意议按时签到");

            return new_activity.getActivityId();
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return -1;
        }
    }

    @RequestMapping(value = "/ClockActivity")
    @ResponseBody
    public String ClockActivity(@RequestParam Map<String, Object> params) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Integer activityId = Integer.parseInt((String) params.get("activity_id"));
        Integer userId = Integer.parseInt((String) params.get("user_id"));
        double longitude = Double.parseDouble((String) params.get("longitude"));
        double latitude = Double.parseDouble((String) params.get("latitude"));
        Date clockTime = sdf.parse((String) params.get("clock_time"));

        try {
            return activityService.userClockActivity(userId, activityId, new java.sql.Timestamp(clockTime.getTime()), longitude, latitude);
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return "false";
        }
    }

    @RequestMapping(value = "/ChangeActivityInfo")
    @ResponseBody
    public Integer changeActivity(@RequestParam Map<String, Object> params) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Integer activityId = Integer.parseInt((String) params.get("activity_id"));
        String activityName = (String) params.get("activity_name");
        Integer activityType = Integer.parseInt((String) params.get("activity_type"));
        Date activityTime = sdf.parse((String) params.get("activity_time"));
        String activityDescription = (String) params.get("activity_description");
        Date clockEndTime = sdf.parse((String) params.get("clock_end_time"));
        double activityLongitude = Double.parseDouble((String) params.get("activity_longitude"));
        double activityLatitude = Double.parseDouble((String) params.get("activity_latitude"));
        Integer organizationId = Integer.parseInt((String) params.get("organization_id"));

        try {
            Activity activity = new Activity();
            activity.setActivityId(activityId);
            activity.setActivityName(activityName);
            activity.setActivityType(activityType);
            activity.setActivityTime(new java.sql.Timestamp(activityTime.getTime()));
            activity.setActivityDescription(activityDescription);
            activity.setClockEndTIme(new java.sql.Timestamp(clockEndTime.getTime()));
            activity.setActivityLongitude(activityLongitude);
            activity.setActivityLatitude(activityLatitude);

            Activity new_activity = activityService.updateActivity(activity, organizationId);

            if (new_activity == null) {
                return -2;
            }
            else {
                return new_activity.getActivityId();
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return -2;
        }
    }

    @RequestMapping(value = "/getUserActivityList")
    @ResponseBody
    public List<Activity> getUserActivityList(@RequestParam Map<String, Object> params) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Integer userId = Integer.parseInt((String) params.get("user_id"));
        Date nowTime = sdf.parse((String) params.get("activity_time"));

        List<UserClockHistory> userClockHistoryList = activityService.getActivityClockRecordByUserId(userId);
        List<Activity> couldClockActivities = new ArrayList<Activity>();

        for (UserClockHistory userClockHistory: userClockHistoryList) {
            if (userClockHistory.getClockRecord() == 0) {
                couldClockActivities.add(activityService.getActivityById(userClockHistory.getActivityId()));
            }
        }

        List<Activity> responseList = new ArrayList<Activity>();

        for (Activity activity: couldClockActivities) {
            if (nowTime.before(activity.getClockEndTIme())) {
                responseList.add(activity);
            }
        }

        return responseList;
    }
}
