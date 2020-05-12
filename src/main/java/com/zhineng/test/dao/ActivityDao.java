package com.zhineng.test.dao;

import com.zhineng.test.domain.po.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.sql.Date;
import java.util.List;

@Repository
public interface ActivityDao  extends JpaRepository<Activity, Integer> {

    Activity findActivityByActivityId(Integer activityId);

    Activity findActivitiesByActivityNameAndActivityTypeAndActivityTime(String activityName, Integer activityType, Date activityTime);

    List<Activity> findActivitiesByActivityName(String activityName);

    List<Activity> findActivitiesByActivityType(Integer activityType);

    List<Activity> findActivitiesByActivityTime(Date activityTime);

    List<Activity> findActivitiesByActivityTimeGreaterThanEqualAndActivityTimeLessThanEqual(Date startDate, Date endDate);

    void deleteActivityByActivityId(Integer activityId);

    @Modifying
    @Query(value = "update Activity set activity_name = :activityName where activity_id = :activityId", nativeQuery = true)
    void updateActivityName(String activityName, Integer activityId);

    @Modifying
    @Query(value = "update Activity set activity_type = :activityType where activity_id = :activityId", nativeQuery = true)
    void updateActivityType(Integer activityType, Integer activityId);

    @Modifying
    @Query(value = "update Activity set activity_time = :activityTime where activity_id = :activityId", nativeQuery = true)
    void updateActivityTime(Date activityTime, Integer activityId);


    @Modifying
    @Query(value = "update Activity set activity_description = :activityDescription where activity_id = :activityId", nativeQuery = true)
    void updateActivityDescription(String activityDescription, Integer activityId);

    @Modifying
    @Query(value = "update Activity set clock_end_time = :clockEndTime where activity_id = :activityId", nativeQuery = true)
    void updateClockEndTime(Date clockEndTime, Integer activityId);

    @Modifying
    @Query(value = "update Activity set activity_longitude = :longitude and activity_latitude = :latitude where activity_id = :activityId", nativeQuery = true)
    void updateActivityLocation(double longitude, double latitude, Integer activityId);

}
