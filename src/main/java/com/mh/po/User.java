package com.mh.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 用户表(User)实体类
 *
 * @author makejava
 * @since 2022-10-21 14:23:53
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 用户id（账号）
     */
    private Integer uid;
    /**
     * 用户名称
     */
    private String uname;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 开户时间
     */
    private Date createTime;
    /**
     * 类型：0-管理员，1-普通用户
     */
    private Integer role;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 家庭住址
     */
    private String address;
    /**
     * 账户激活状态
     */
    private int activation;

}

