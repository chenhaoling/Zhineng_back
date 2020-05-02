package com.zhineng.test.biz.impl;

import com.zhineng.test.biz.UserService;
import com.zhineng.test.dao.UserDao;
import com.zhineng.test.domain.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User save(User user) {
        User x = userDao.save(user);
        return x;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByOpenId(String openId) {
        return userDao.findByOpenId(openId);
    }

    @Override
    public User findByUserIdCard(String userIdCard) {
        return userDao.findByUserIdCard(userIdCard);
    }
}
