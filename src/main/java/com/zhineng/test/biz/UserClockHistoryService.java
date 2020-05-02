package com.zhineng.test.biz;

import com.zhineng.test.domain.po.UserClockHistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserClockHistoryService {
    List<UserClockHistory> getUserClockHistory(Integer userId);
}
