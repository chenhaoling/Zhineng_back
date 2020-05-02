package com.zhineng.test.controller;


import com.zhineng.test.biz.UserClockHistoryService;
import com.zhineng.test.domain.po.User;
import com.zhineng.test.domain.po.UserClockHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/UserClockHistory")
public class UserClockHistoryController {

    @Autowired
    private UserClockHistoryService userClockHistoryService;

    @RequestMapping("/getUserClockHistory")
    public List<UserClockHistory> getUserClockHistory(User user){
        return userClockHistoryService.getUserClockHistory(user.getUserId());
    }
}
