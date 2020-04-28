package com.zhineng.test.dao;

import com.zhineng.test.domain.po.GroupOfOrg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupOfOrgDao extends JpaRepository<GroupOfOrg, Integer> {

    List<GroupOfOrg> findGroupOfOrgsByOrganizationId(Integer organizationId);

    void deleteGroupOfOrgsByOrganizationId(Integer organizationId);

    @Modifying
    @Query(value = "update GroupOfOrg set group_name = :groupName where group_id = :groupId", nativeQuery = true)
    void updateGroupName(@Param("groupName") String groupName, @Param("groupId") Integer groupId);
}
