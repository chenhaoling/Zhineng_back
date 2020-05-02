package com.zhineng.test.biz.impl.impl;

import com.zhineng.test.biz.impl.GroupService;
import com.zhineng.test.biz.impl.OrganizationService;
import com.zhineng.test.dao.*;
import com.zhineng.test.domain.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private GroupOfOrgDao groupOfOrgDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private ActivityOrganizerDao activityOrganizerDao;

    @Override
    public Organization createOrganization(Organization organization) {
        try {
            return organizationDao.save(organization);
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public GroupOfOrg createGroupOfOrganization(GroupOfOrg groupOfOrg) {
        try {
            return groupOfOrgDao.save(groupOfOrg);
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public User createUserOfOrganization(User user) {
        try {

            return userDao.save(user);
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public boolean organizationRemoveGroup(Integer groupId) {
        try {
            Optional<GroupOfOrg> groupOfOrg = groupOfOrgDao.findById(groupId);

            organizationDao.deleteById(groupId);
            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean organizationRemoveUser(Integer userId) {
        try {

            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean organizationChangeGroupLeader(Integer groupId, Integer userId) {
        try {

            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean organizationChangeUserGroup(Integer groupId, Integer userId) {
        try {

            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean organizationChangeName(String name, Integer organizationId) {
        try {

            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean organizationChangeDescription(String description, Integer organizationId) {
        try {

            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public List<GroupOfOrg> getGroupsOfOrganization(Integer organizationId) {
        return groupOfOrgDao.findGroupOfOrgsByOrganizationId(organizationId);
    }

    @Override
    public List<User> getGroupLeadersOfOrganization(Integer organizationId) {
        return null;
    }

    @Override
    public List<User> getLeadersOfOrganization(Integer organization) {
        return null;
    }

    @Override
    public List<Activity> getActivitiesOfOrganization(Integer organizationId) {
        List<Activity> activities = new ArrayList<Activity>();
        List<ActivityOrganizer> activityOrganizers = activityOrganizerDao.findActivityOrganizersByOrganizationId(organizationId);

        for (ActivityOrganizer activityOrganizer: activityOrganizers) {
            activities.add(activityDao.findActivityByActivityId(activityOrganizer.getActivityId()));
        }

        return activities;
    }
}
