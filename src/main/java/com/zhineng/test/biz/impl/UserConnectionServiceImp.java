package com.zhineng.test.biz.impl;

import com.zhineng.test.biz.UserConnectionService;
import com.zhineng.test.dao.UserConnectionDao;
import com.zhineng.test.domain.po.UserConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserConnectionServiceImp implements UserConnectionService {
    @Autowired
    private UserConnectionDao userConnectionDao;

    @Override
    public List<UserConnection> findAllByConnectionId(Integer connectionId) {
        return userConnectionDao.findAllByConnectionId(connectionId);
    }

    @Override
    public List<UserConnection> findAllByLeaveId(Integer leaveId) {
        return userConnectionDao.findAllByLeaveId(leaveId);
    }
}
