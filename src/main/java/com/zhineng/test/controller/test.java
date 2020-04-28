package com.zhineng.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping("/comment")
public class test {
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
      return "hello";
    }
}
