package com.mh.service;

import com.mh.po.User;

import java.util.List;

public interface UserService {
    /*登录时，查询当前所有用户信息*/
    User selectAllByUidAndPassword(String uid,String password);
    /*查询所有用户的信息*/
    List<User> selectAllUser(int pn);
    /*查询用户数据条数*/
    int getAllUserCount();
    /*执行增加用户操作*/
    int insertUser(User user);
    /*执行查询操作，仅通过姓名或uid*/
    List<User> getUserByFuzzy(String info,int pn);

    List<User> getUserByFuzzy1(String info, int pn);

    /*通过uid完成对学生的删除*/
    int delectUserById(int uid);
    /*通过uid完成对学生信息的查询*/
    User getUserById(int uid);
    /*实现对用户信息的修改*/
    int updateUserById(User user);
    /*通过uid完成对用户姓名的查询*/
    User getUnameById(String uid);
    /*完成对用户状态的修改*/
    int updateUserActivation(String uid,int activation);
    /*通过uid完成对用户状态的查询*/
    int getUserActivationByUid(int uid);
    //清空某所有用户的登录状态
    int clearUser();
}
