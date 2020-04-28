package com.zhineng.test.dao;


import com.zhineng.test.domain.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUserName(String name);
    User findByUserIdCard(String userIdCard);
    User findByOpenId(Integer openid);
    List<User> findAllByGroupId(Integer groupId);
    List<User> findAll();
}
