package com.mh.service;

import com.mh.po.Log;

import java.util.List;

public interface LogService {
    //添加日志
    void addLog(int type,int uid,String uname);
    //获取所有的日志信息
    List<Log> getAllLog();

}
