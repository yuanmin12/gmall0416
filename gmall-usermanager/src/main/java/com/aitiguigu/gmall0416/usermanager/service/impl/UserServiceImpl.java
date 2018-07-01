package com.aitiguigu.gmall0416.usermanager.service.impl;

import com.aitiguigu.gmall0416.usermanager.bean.UserInfo;
import com.aitiguigu.gmall0416.usermanager.mapper.UserInfoMapper;
import com.aitiguigu.gmall0416.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfo(String id) {

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        return userInfo;
    }

    @Override
    public List<UserInfo> getAllUserInfo() {

        List<UserInfo> userInfo = userInfoMapper.selectAll();

        return userInfo;
    }

    @Override
    public List<UserInfo> getQueryUserInfo(UserInfo userInfoQuery) {

        List<UserInfo> userInfos = userInfoMapper.select(userInfoQuery);
        //输入特殊匹配条件
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%"+userInfoQuery.getLoginName()+"%");
        List<UserInfo> infos = userInfoMapper.selectByExample(example);

        return infos;
    }

    @Override
    public List<UserInfo> getUserInfo(UserInfo userInfo) {

        List<UserInfo> userInfoList = userInfoMapper.select(userInfo);

        return userInfoList;
    }

    @Override
    public UserInfo getUserInfoPrimary(UserInfo userInfo) {

        UserInfo userInfo1 = userInfoMapper.selectByPrimaryKey(userInfo.getId());

        return userInfo1;
    }

    @Override
    public UserInfo getUserInfoone(UserInfo userInfo) {
        //只能通过一个属性进行查询，如果有重的则会报错

        UserInfo selectOne = userInfoMapper.selectOne(userInfo);

        return selectOne;
    }

    //增加用户
    @Override
    public void adduserInfo(UserInfo userInfo) {
        //userInfoMapper.insert(userInfo);
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
//        userInfoMapper.updateByPrimaryKey(userInfo);
//        userInfoMapper.updateByPrimaryKeySelective(userInfo);

        //用户自定义修改
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%"+userInfo.getLoginName()+"%");
//        userInfoMapper.updateByExample(userInfo,example);
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    @Override
    public void delete(UserInfo userInfo) {
        //按非空值匹配删除
//        userInfoMapper.delete(userInfo);
        //按条件删除
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%"+userInfo.getLoginName()+"%");
        userInfoMapper.deleteByExample(example);
    }

    @Override
    public void updateInfo(UserInfo userInfo, UserInfo userQuery) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("name","%"+userQuery.getName()+"%");
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }


}
