package com.zhineng.test.controller;

import com.zhineng.test.domain.po.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Administrator")
public class AdministratorController {

    @RequestMapping("/createOrganization")
    @ResponseBody
    Integer createOrganization(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/deleteOrganization")
    @ResponseBody
    Integer deleteOrganization(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/modifyOrganization")
    @ResponseBody
    Integer modifyOrganization(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/getAllOrganization")
    @ResponseBody
    List<Activity> getAllOrganization(@RequestParam Map<String, Object> params) {
        return null;
    }

    @RequestMapping("/createGroup")
    @ResponseBody
    Integer createGroup(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/deleteGroup")
    @ResponseBody
    Integer deleteGroup(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/modifyGroup")
    @ResponseBody
    Integer modifyGroup(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/getAllGroup")
    @ResponseBody
    List<GroupOfOrg> getAllGroup(@RequestParam Map<String, Object> params) {
        return null;
    }

    @RequestMapping("/createUser")
    @ResponseBody
    Integer createUser(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    Integer deleteUser(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/modifyUser")
    @ResponseBody
    Integer modifyUser(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/getAllUser")
    @ResponseBody
    List<User> getAllUser(@RequestParam Map<String, Object> params) {
        return null;
    }

    @RequestMapping("/createArticle")
    @ResponseBody
    Integer createArticle(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/deleteArticle")
    @ResponseBody
    Integer deleteArticle(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/modifyArticle")
    @ResponseBody
    Integer modifyArticle(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/getAllArticle")
    @ResponseBody
    List<Activity> getAllArticle(@RequestParam Map<String, Object> params) {
        return null;
    }

    @RequestMapping("/createUserStatus")
    @ResponseBody
    Integer createUserStatus(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/deleteUserStatus")
    @ResponseBody
    Integer deleteUserStatus(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/modifyUserStatus")
    @ResponseBody
    Integer modifyUserStatus(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/getAllUserStatus")
    @ResponseBody
    List<UserStatus> getAllUserStatus(@RequestParam Map<String, Object> params) {
        return null;
    }

    @RequestMapping("/createCaseRecord")
    @ResponseBody
    Integer createCaseRecord(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/deleteCaseRecord")
    @ResponseBody
    Integer deleteCaseRecord(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/modifyCaseRecord")
    @ResponseBody
    Integer modifyCaseRecord(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/getAllCaseRecord")
    @ResponseBody
    List<UserCaseRecord> getAllCaseRecord(@RequestParam Map<String, Object> params) {
        return null;
    }

    @RequestMapping("/createUserConnection")
    @ResponseBody
    Integer createUserConnection(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/deleteUserConnection")
    @ResponseBody
    Integer deleteUserConnection(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/modifyUserConnection")
    @ResponseBody
    Integer modifyUserConnection(@RequestParam Map<String, Object> params) {
        return 1;
    }

    @RequestMapping("/getAllUserConnection")
    @ResponseBody
    List<UserConnection> getAllUserConnection(@RequestParam Map<String, Object> params) {
        return null;
    }

}
