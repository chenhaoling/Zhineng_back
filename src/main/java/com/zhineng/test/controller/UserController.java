package com.zhineng.test.controller;


import com.alibaba.fastjson.JSONObject;
import com.zhineng.test.Util.WeChatUtil;
import com.zhineng.test.biz.UserService;
import com.zhineng.test.domain.po.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Null;
import java.net.URI;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public User login(@RequestParam(value = "code",required = false)String code,@RequestParam(value = "idcard",required = false)
    String idCard){
        //1.接收小程序发送的code
        //2.开发者服务器 登录凭证校验接口 appID  + appsecreet + code
        JSONObject SessionKeyOrOpenId = WeChatUtil.getSessionKeyOrOpenId(code);
        //3.接收微信接口服务 获取返回的参数
        String openId = SessionKeyOrOpenId.getString("openid");
        String sessionKey = SessionKeyOrOpenId.getString("session_key");

        User user = userService.findByOpenId(openId);
        if(user == null){
            user = userService.findByUserIdCard(idCard);
            user.setOpenId(openId);
        }else{
            user = userService.findByOpenId(openId);
        }
        return  user;
    }


    @RequestMapping("/getInfo")
    public User getInfo(User user){
        return userService.findByOpenId(user.getOpenId());
    }
}
