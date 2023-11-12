package com.mh.mapper;

import com.mh.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /*
    * 用户登录，通过账号和密码查询用户所有信息*/
    User selectAllByUidAndPassword(@Param("uid") String uid, @Param("password") String password);
    /*查询所有用户信息*/
    List<User> selectAllUser();
    /*查询信息条数*/
    int getAllUserCount();
    /*添加用户信息*/
    int addUser(User user);
    /*使用模糊查询用户信息*/
    List<User> fuzzy(@Param("fuzzy") String fuzzy);
    //筛选用户的在线状态
    List<User> fuzzy1(@Param("fuzzy") String fuzzy);
    /*通过id实现对用户的删除 */
    int delectUserById(@Param("uid") int uid);
    /*通过uid实现对用户信息的查询*/
    User getUserById(int uid);
    /*修改用户信息*/
    int updateUserInfoById(User user);
    /*通过uid完成对用户名字的查询*/
    User getUserNameByUid(@Param("uid") String uid);
    /*通过分布查询查询表字段*/
    User byCardGetUname(@Param("uid") int uid);
    /*验证用户是否激活*/
    int getUserActivation(@Param("uid") int uid);
    /*修改用户激活状态*/
    int exitUserActivation(@Param("uid") String uid,@Param("activation") int activation);
    //清空用户登陆状态
    int clearUser();
}
