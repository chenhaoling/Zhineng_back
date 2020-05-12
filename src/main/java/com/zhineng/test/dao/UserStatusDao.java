package com.zhineng.test.dao;


import com.zhineng.test.domain.po.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStatusDao extends JpaRepository<UserStatus,Integer> {
    List<UserStatus> findAllByUserId(Integer UserId);
}
