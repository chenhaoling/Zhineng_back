package com.zhineng.test.dao;


import com.zhineng.test.domain.po.UserClockHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserClockHistoryDao  extends JpaRepository<UserClockHistory, Integer> {

    UserClockHistory findUserClockHistoryByUserIdAndActivityId(Integer userId, Integer activityId);

    List<UserClockHistory> findUserClockHistoriesByActivityId(Integer activityId);

    List<UserClockHistory> findUserClockHistoriesByUserId(Integer userId);

    void deleteUserClockHistoryByUserIdAndActivityId(Integer userId, Integer activityId);

    void deleteUserClockHistoriesByUserId(Integer userId);

    void deleteUserClockHistoriesByActivityId(Integer activityId);

    @Modifying
    @Query(value = "update UserClockHistory set clock_record = :record where user_id = :userId and activity_id = :activityId", nativeQuery = true)
    void updateClockHistoryByUserIdAndActivityId(@Param("record") Integer record, @Param("userId") Integer userId, @Param("activityId") Integer activityId);

}
