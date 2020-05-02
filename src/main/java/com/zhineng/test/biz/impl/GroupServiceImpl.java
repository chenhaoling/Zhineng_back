package com.zhineng.test.biz.impl.impl;

import com.zhineng.test.biz.impl.GroupService;
import com.zhineng.test.dao.GroupOfOrgDao;
import com.zhineng.test.dao.UserDao;
import com.zhineng.test.domain.po.Activity;
import com.zhineng.test.domain.po.GroupOfOrg;
import com.zhineng.test.domain.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupOfOrgDao groupOfOrgDao;

    @Autowired
    private UserDao userDao;

    @Override
    public GroupOfOrg getGroup(Integer groupId) {
        return groupOfOrgDao.findGroupOfOrgByGroupId(groupId);
    }

    @Override
    public List<User> getLeadOfGroup(Integer groupId) {
        return null;
    }

    @Override
    public List<User> getMembersOfGroup(Integer groupId) {
        return userDao.findAllByGroupId(groupId);
    }

    @Override
    public List<Activity> getActivitiesOfGroup(Integer groupId) {
        return null;
    }
}
