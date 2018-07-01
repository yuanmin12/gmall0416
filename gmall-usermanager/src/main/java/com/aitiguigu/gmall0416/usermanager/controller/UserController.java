package com.aitiguigu.gmall0416.usermanager.controller;

import com.aitiguigu.gmall0416.usermanager.bean.UserInfo;
import com.aitiguigu.gmall0416.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/finduser/{id}")
     public UserInfo getUserInfo(@PathVariable("id") String id){
        UserInfo info = userService.getUserInfo(id);
        return info;

    }
    //查询所有人员
    @RequestMapping("/findalluser")
    public List<UserInfo> getUserAllList(){
        List<UserInfo> allUserInfo = userService.getAllUserInfo();
        return allUserInfo;
    }


    @RequestMapping("/finduserdefine")
    public List<UserInfo> getUserInfo(HttpServletRequest request){

        String name = request.getParameter("name");

        UserInfo userInfo = new UserInfo();

        userInfo.setName(name);

        List<UserInfo> userInfo1 = userService.getUserInfo(userInfo);
        return  userInfo1;
    }



    @RequestMapping("/finduserC")
    public List<UserInfo> getConditionUser(UserInfo userInfo){

        List<UserInfo> queryUserInfo = userService.getQueryUserInfo(userInfo);

        return queryUserInfo;
    }

    @RequestMapping("/finduserP")
    public UserInfo getuserP(UserInfo userInfo){
        UserInfo userInfoPrimary = userService.getUserInfoPrimary(userInfo);
        return userInfoPrimary;
    }

    @RequestMapping("/finduserone")
    public UserInfo getuserone(UserInfo userInfo){
        UserInfo userInfoone = userService.getUserInfoone(userInfo);
        return userInfoone;
    }
    @RequestMapping(value="/adduser",method = RequestMethod.POST)
    public String adduser(UserInfo userInfo){

        userService.adduserInfo(userInfo);
        return "SUCCESS";
    }
    @RequestMapping(value="/updateuser",method = RequestMethod.POST)
    public String updateUser(UserInfo userInfo){

        userService.updateUser(userInfo);
        return "SUCCESS";
    }
    @RequestMapping(value="/updateuserS",method = RequestMethod.PUT)
    public String updateUserS(UserInfo userInfo){

        userService.updateUser(userInfo);
        return "SUCCESS";
    }
    @RequestMapping(value="/deleteuser",method =RequestMethod.DELETE)
    public String deleteUser(UserInfo userInfo){
        userService.delete(userInfo);
        return "SUCCESS";
    }

    @RequestMapping(value = "/u",method = RequestMethod.PUT)
    public String updateM(UserInfo userInfo){
        UserInfo info = new UserInfo();
        info.setName(userInfo.getName());
        userInfo.setName(null);
        userService.updateInfo(userInfo,info);
        return "SUCCESS";
    }

}
