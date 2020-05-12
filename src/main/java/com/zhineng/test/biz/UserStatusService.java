package com.zhineng.test.biz;


import com.zhineng.test.domain.po.UserStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserStatusService {
    List<UserStatus> findAllByUserId(Integer userId);
}
