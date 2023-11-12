package com.mh.service.impl;

import com.github.pagehelper.PageHelper;
import com.mh.mapper.UserMapper;
import com.mh.po.User;
import com.mh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //CardServiceImpl的set方法
    public void setUserMapper(UserMapper userMapper){this.userMapper=userMapper;}

    @Override
    public User selectAllByUidAndPassword(String uid,String password) {
        User user = userMapper.selectAllByUidAndPassword(uid,password);
        return user;
    }
    /*查询所有的用户信息*/
    @Override
    public List<User> selectAllUser(int pn) {
        PageHelper.startPage(pn,8);
        List<User> userList = userMapper.selectAllUser();
        return userList;
    }

    @Override
    public int getAllUserCount() {
        return userMapper.getAllUserCount();
    }

    @Override
    public int insertUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<User> getUserByFuzzy(String info,int pn) {
        PageHelper.startPage(pn,4);
        if (info==null){
            info="1";
        }
        List<User> fuzzy = userMapper.fuzzy(info);
        return fuzzy;
    }
    @Override
    public List<User> getUserByFuzzy1(String info,int pn) {
        PageHelper.startPage(pn,4);
        if (info==null){
            info="1";
        }
        List<User> fuzzy = userMapper.fuzzy1(info);
        return fuzzy;
    }


    @Override
    public int delectUserById(int uid) {
        return userMapper.delectUserById(uid);
    }

    @Override
    public User getUserById(int uid) {
        return userMapper.getUserById(uid);
    }

    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserInfoById(user);
    }

    @Override
    public User getUnameById(String uid) {
        return userMapper.getUserNameByUid(uid);
    }

    @Override
    public int updateUserActivation(String uid, int activation) {
        return userMapper.exitUserActivation(uid,activation);
    }

    @Override
    public int getUserActivationByUid(int uid) {
        return userMapper.getUserActivation(uid);
    }

    @Override
    public int clearUser() {
        return userMapper.clearUser();
    }
}
