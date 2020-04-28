package com.zhineng.test.biz;


import com.zhineng.test.domain.po.UserCaseRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserCaseRecordService {
    List<UserCaseRecord> findAllByUserId(Integer userId);
}
