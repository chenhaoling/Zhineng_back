package com.zhineng.test.dao;


import com.zhineng.test.domain.po.UserCaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCaseRecordDao extends JpaRepository<UserCaseRecord,Integer> {
    List<UserCaseRecord> findAllByUserId(Integer UserId);

}
