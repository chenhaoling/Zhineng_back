package com.zhineng.test.biz;

import com.zhineng.test.domain.po.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User save(User user);
    List<User> findAll();
    User findByOpenId(String openId);
    User findByUserIdCard(String userIdCard);
}
