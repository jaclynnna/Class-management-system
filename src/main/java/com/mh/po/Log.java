package com.mh.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    /*日志id*/
    private int id;
    /*当前操作人id*/
    private int uid;
    /*当前操作类型*/
    private int type;
    /*操作时间*/
    private Date createTime;
    /*到底做了什么*/
    private String info;
}
