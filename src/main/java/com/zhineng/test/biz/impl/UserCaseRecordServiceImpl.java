package com.zhineng.test.biz.impl;

import com.zhineng.test.biz.UserCaseRecordService;
import com.zhineng.test.dao.UserCaseRecordDao;
import com.zhineng.test.domain.po.UserCaseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserCaseRecordServiceImpl implements UserCaseRecordService {
    @Autowired
    private UserCaseRecordDao userCaseRecordDao;

    @Override
    public List<UserCaseRecord> findAllByUserId(Integer userId) {
        return userCaseRecordDao.findAllByUserId(userId);
    }
}
