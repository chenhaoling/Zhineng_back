package com.zhineng.test.biz.impl;

import com.zhineng.test.domain.po.Activity;
import com.zhineng.test.domain.po.GroupOfOrg;
import com.zhineng.test.domain.po.Organization;
import com.zhineng.test.domain.po.User;

import java.util.List;

public interface GroupService {

    GroupOfOrg getGroup(Integer groupId);

    List<User> getLeadOfGroup(Integer groupId);

    List<User> getMembersOfGroup(Integer groupId);

    List<Activity> getActivitiesOfGroup(Integer groupId);

}
