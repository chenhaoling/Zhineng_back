package com.zhineng.test.controller;


import com.zhineng.test.biz.UserStatusService;
import com.zhineng.test.domain.po.User;
import com.zhineng.test.domain.po.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/UserStatus")
public class UserStatusController {

    @Autowired
    private UserStatusService userStatusService;

    @RequestMapping("/getUserStatus")
    @ResponseBody
    public List<UserStatus> getUserStatus(User user){
        return userStatusService.findAllByUserId(user.getUserId());
    }

}
