package com.zhineng.test.biz;

import com.zhineng.test.domain.po.Activity;
import com.zhineng.test.domain.po.GroupOfOrg;
import com.zhineng.test.domain.po.Organization;
import com.zhineng.test.domain.po.User;

import java.util.List;

public interface OrganizationService {

    Organization createOrganization(Organization organization);

    GroupOfOrg createGroupOfOrganization(GroupOfOrg groupOfOrg);

    User createUserOfOrganization(User user);

    boolean organizationRemoveGroup(Integer groupId);

    boolean organizationRemoveUser(Integer userId);

    boolean organizationChangeGroupLeader(Integer groupId, Integer userId);

    boolean organizationChangeUserGroup(Integer groupId, Integer userId);

    boolean organizationChangeName(String name, Integer organizationId);

    boolean organizationChangeDescription(String description, Integer organizationId);

    List<GroupOfOrg> getGroupsOfOrganization(Integer organizationId);

    List<User> getGroupLeadersOfOrganization(Integer organizationId);

    List<User> getLeadersOfOrganization(Integer organization);

    List<Activity> getActivitiesOfOrganization(Integer organizationId);

    Organization getOrganizationById(Integer organizationId);




}
