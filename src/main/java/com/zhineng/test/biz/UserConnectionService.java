package com.zhineng.test.biz;

import com.zhineng.test.domain.po.UserConnection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserConnectionService {

    List<UserConnection> findAllByConnectionId(Integer connectionId);
    List<UserConnection> findAllByLeaveId(Integer leaveId);
}
