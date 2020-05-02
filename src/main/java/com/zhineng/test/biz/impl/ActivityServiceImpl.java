package com.zhineng.test.biz.impl.impl;

import com.zhineng.test.biz.impl.ActivityService;
import com.zhineng.test.dao.ActivityDao;
import com.zhineng.test.dao.ActivityOrganizerDao;
import com.zhineng.test.dao.UserClockHistoryDao;
import com.zhineng.test.domain.po.Activity;
import com.zhineng.test.domain.po.ActivityOrganizer;
import com.zhineng.test.domain.po.UserClockHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static java.lang.Math.*;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private ActivityOrganizerDao activityOrganizerDao;

    @Autowired
    private UserClockHistoryDao userClockHistoryDao;

    private double R = 6371000;

    @Override
    public Activity createActivity(Activity activity, Integer organizationId, Integer groupId) {
        try {
            Activity new_activity = activityDao.save(activity);
            ActivityOrganizer activityOrganizer = new ActivityOrganizer();
            activityOrganizer.setActivityId(new_activity.getActivityId());
            activityOrganizer.setOrganizationId(organizationId);
            if (groupId != -1) {
                activityOrganizer.setGroupId(groupId);
            }
            activityOrganizerDao.save(activityOrganizer);
            return new_activity;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Activity updateActivity(Activity activity, Integer organizationId) {
        try {
            List<ActivityOrganizer> activityOrganizers = activityOrganizerDao.findActivitiesOrganizerByActivityIdAndOrganizationId(activity.getActivityId(), organizationId);
            if (activityOrganizers.size() == 0) {
                activity.setActivityId(-1);
                return activity;
            }
            else {
                return activityDao.save(activity);
            }
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean addClockRecordOfActivity(Integer activityId, List<Integer> participantList) {
        try {
            for (Integer participant: participantList) {
                UserClockHistory userClockHistory = new UserClockHistory();
                userClockHistory.setActivityId(activityId);
                userClockHistory.setUserId(participant);
                userClockHistory.setClockRecord(0);
                userClockHistory.setClockTime(null);
                userClockHistoryDao.save(userClockHistory);
            }
            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean cancelActivity(Integer activityId, Integer organizationId) {
        return false;
    }

    @Override
    public String userClockActivity(Integer userId, Integer activityId, Timestamp clockTime, double longitude, double latitude) {
        try {
            UserClockHistory userClockHistory = userClockHistoryDao.findUserClockHistoryByUserIdAndActivityId(userId, activityId);
            Activity activity = activityDao.findActivityByActivityId(activityId);

            if (clockTime.before(activity.getClockEndTIme())) {
                double distance = R * acos(cos(latitude) * cos(activity.getActivityLatitude()) * cos(longitude - activity.getActivityLongitude()) + sin(latitude) * sin(activity.getActivityLatitude()));
                if (distance < 100) {
                    UserClockHistory updatedUserClockHistory = userClockHistoryDao.findUserClockHistoryByUserIdAndActivityId(userId, activityId);
                    updatedUserClockHistory.setClockTime(clockTime);
                    updatedUserClockHistory.setClockRecord(1);
                    userClockHistoryDao.save(updatedUserClockHistory);
                }
                else {
                    return "out of distance";
                }
            }
            else {
                return "out of time";
            }
            return "true";
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return "error";
        }
    }

    @Override
    public String userLeaveActivity(Integer userId, Integer activityId, Timestamp clockTime) {
        try {
            UserClockHistory userClockHistory = userClockHistoryDao.findUserClockHistoryByUserIdAndActivityId(userId, activityId);
            userClockHistory.setClockTime(clockTime);
            userClockHistory.setClockRecord(2);
            return "true";
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return "false";
        }
    }

    @Override
    public List<UserClockHistory> getActivityClockRecord(Integer activityId) {
        return userClockHistoryDao.findUserClockHistoriesByActivityId(activityId);
    }

}
