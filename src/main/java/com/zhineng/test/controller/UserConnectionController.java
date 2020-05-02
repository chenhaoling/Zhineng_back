package com.zhineng.test.controller;


import com.zhineng.test.biz.UserConnectionService;
import com.zhineng.test.domain.po.User;
import com.zhineng.test.domain.po.UserConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/UserConnection")
public class UserConnectionController {

    @Autowired
    private UserConnectionService userConnectionService;

    @RequestMapping("getUserConnection")
    public List<UserConnection> getUserConnection(User user){
        return userConnectionService.findAllByLeaveId(user.getUserId());
    }
}
