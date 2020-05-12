package com.zhineng.test.controller;


import com.zhineng.test.biz.UserConnectionService;
import com.zhineng.test.biz.impl.UserConnectionServiceImp;
import com.zhineng.test.dao.UserConnectionDao;
import com.zhineng.test.domain.po.User;
import com.zhineng.test.domain.po.UserConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/UserConnection")
public class UserConnectionController {

    @Autowired
    private UserConnectionServiceImp userConnectionService;


    @RequestMapping("/getUserConnection")
    @ResponseBody
    public List<UserConnection> getUserConnection(User user){
        System.out.println(user.getUserId());

        return userConnectionService.findAllByLeaveId(user.getUserId());
    }
}
