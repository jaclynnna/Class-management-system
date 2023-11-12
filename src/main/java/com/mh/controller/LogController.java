package com.mh.controller;

import com.mh.po.Log;
import com.mh.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LogController {
    @Autowired
    private LogService logService;
    /*展示所有日志信息*/
    @RequestMapping("/showAllLog")
    public String showAllLog(Model model){
        List<Log> allLog = logService.getAllLog();
        model.addAttribute("allLog",allLog);
        return "log";
    }
}
