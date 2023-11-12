package com.mh.service.impl;

import com.mh.mapper.LogMapper;
import com.mh.po.Log;
import com.mh.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    /*添加日志功能*/
    public void addLog(int type,int uid,String uname){
        String info = new Date()+uname+" finished checking in";
        System.out.println(info);
        Date date = new Date();
        logMapper.addLog(type,uid,info,date);
    }

    @Override
    public List<Log> getAllLog() {
        List<Log> list = logMapper.getAllLog();
        return list;
    }

}
