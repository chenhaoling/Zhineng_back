package com.zhineng.test.dao;

import com.zhineng.test.domain.po.ActivityOrganizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityOrganizerDao extends JpaRepository<ActivityOrganizer, Integer> {

    List<ActivityOrganizer> findActivityOrganizersByOrganizationId(Integer organizationId);

    List<ActivityOrganizer> findActivityOrganizersByGroupId(Integer groupId);

    List<ActivityOrganizer> findActivityOrganizerByActivityId(Integer activityId);

    List<ActivityOrganizer> findActivitiesOrganizerByActivityIdAndOrganizationId(Integer activityId, Integer organizationId);

    ActivityOrganizer findActivityOrganizerByActivityIdAndGroupId(Integer activityId, Integer groupId);

    void deleteActivityOrganizersByActivityId(Integer activityId);

    void deleteActivityOrganizersByOrganizationId(Integer activityId);

    void deleteActivityOrganizersByGroupId(Integer groupId);

}
