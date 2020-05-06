package com.zhineng.test.controller;


import com.zhineng.test.biz.UserCaseRecordService;
import com.zhineng.test.domain.po.User;
import com.zhineng.test.domain.po.UserCaseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/UserCaseRecord")
public class UserCaseRecordController {
    @Autowired
    private UserCaseRecordService userCaseRecordService;

    @RequestMapping("/getUserCaseRecord")
    @ResponseBody
    public List<UserCaseRecord> getUserCaseRecord(User user){
        System.out.println(user.getUserId());
        return userCaseRecordService.findAllByUserId(user.getUserId());
    }
}
