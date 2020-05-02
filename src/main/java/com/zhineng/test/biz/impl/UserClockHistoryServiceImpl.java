package com.zhineng.test.biz.impl;


import com.zhineng.test.biz.UserClockHistoryService;
import com.zhineng.test.dao.UserClockHistoryDao;
import com.zhineng.test.domain.po.UserClockHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserClockHistoryServiceImpl implements UserClockHistoryService {

    @Autowired
    private UserClockHistoryDao userClockHistoryDao;
    @Override
    public List<UserClockHistory> getUserClockHistory(Integer userId) {
        return userClockHistoryDao.findAllByUserId(userId);
    }
}
