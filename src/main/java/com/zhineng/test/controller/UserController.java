package com.zhineng.test.controller;


import com.alibaba.fastjson.JSONObject;
import com.zhineng.test.biz.UserService;
import com.zhineng.test.dao.UserDao;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    String appid = "wx032fe59c23a2521c";
    String appsecret ="31137e7d4914d422f304684a1de202ad";
    String openid;
    String session_key;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestParam(value = "code",required = false)String code){
        Map res = new HashMap<String,Object>();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + appsecret + "&js_code=" + code + "&grant_type=authorization_code";
        try {
            //创建uri
            URIBuilder builder = new URIBuilder(url);
            URI uri = builder.build();

            //创建http get请求
            HttpGet httpGet = new HttpGet(uri);

            //执行请求
            response = httpClient.execute(httpGet);
            //判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //解析json
        JSONObject jsonObject = (JSONObject) JSONObject.parse(resultString);
        session_key = jsonObject.get("session_key").toString();
        openid = jsonObject.get("openid").toString();
        
        System.out.println("session_key = " + session_key);
        System.out.println("openid = " + openid);
        User user = userService.findByOpenId(openid);
        if(user != null)res.put("user",user);
        else res.put("openid",openid);
        return res;
    }

    @RequestMapping("/login2")
    @ResponseBody
    public Map<String,Object> login2(@RequestParam(value = "openid")String openid,@RequestParam(value = "idcard")String idcard){
        Map res = new HashMap<String,Object>();
        User user = userService.findByUserIdCard(idcard);
        if(user != null){
            user.setOpenId(openid);
            userService.save(user);
        }
        res.put("user",user);
        return res;

    }

    @GetMapping("/getInfo")
    @ResponseBody
    public User getInfo(User user){
        System.out.println("userINfo:"+user);
        System.out.println(user.getOpenId());
        return userService.findByOpenId(user.getOpenId());

    }
}
