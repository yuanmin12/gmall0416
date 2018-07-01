package com.aitiguigu.gmall0416.usermanager.service;

import com.aitiguigu.gmall0416.usermanager.bean.UserInfo;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    public UserInfo getUserInfo(String id);

    //查询所有人员
    public List<UserInfo> getAllUserInfo();

    //查询符合条件的人员
    public List<UserInfo> getQueryUserInfo(UserInfo userInfoQuery);


    public List<UserInfo> getUserInfo(UserInfo userInfo);
    //按主键查找
    public UserInfo getUserInfoPrimary(UserInfo userInfo);
    //按非空查找
    public UserInfo getUserInfoone(UserInfo userInfo);
    //增加用户
    public void adduserInfo(UserInfo userInfo);
    //修改用户
    public void updateUser(UserInfo userInfo);

    public void delete(UserInfo userInfo);
    public void updateInfo(UserInfo userInfo, UserInfo userQuery);
}
