package com.zhineng.test.biz.impl;


import com.zhineng.test.biz.UserStatusService;
import com.zhineng.test.dao.UserStatusDao;
import com.zhineng.test.domain.po.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserStatusServiceImpl implements UserStatusService {

    @Autowired
    private UserStatusDao userStatusDao;

    @Override
    public List<UserStatus> findAllByUserId(Integer userId) {
        return userStatusDao.findAllByUserId(userId);
    }
}
