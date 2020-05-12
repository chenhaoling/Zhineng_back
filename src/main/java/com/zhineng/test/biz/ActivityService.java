package com.zhineng.test.biz;

import com.zhineng.test.domain.po.Activity;
import com.zhineng.test.domain.po.UserClockHistory;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ActivityService {

    Activity createActivity(Activity activity, Integer organizationId, Integer groupId);

    Activity updateActivity(Activity activity, Integer organizationId);

    boolean addClockRecordOfActivity(Integer activityId, List<Integer> participantList);

    boolean cancelActivity(Integer activityId, Integer organizationId);

    String userClockActivity(Integer userId, Integer activityId, Timestamp clockTime, double longitude, double latitude);

    String userLeaveActivity(Integer userId, Integer activityId, Timestamp clockTime);

    List<UserClockHistory> getActivityClockRecord(Integer activityId);

    Activity getActivityById(Integer activityId);

}
