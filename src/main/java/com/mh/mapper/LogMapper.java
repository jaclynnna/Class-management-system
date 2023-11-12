package com.mh.mapper;

import com.mh.po.Log;
import lombok.Data;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface LogMapper {
    /*添加日志信息*/
    int addLog(@Param("type") int type, @Param("uid") int uid, @Param("info") String info, @Param("date") Date date);
    /*获取所有日志信息*/
    List<Log> getAllLog();

}
