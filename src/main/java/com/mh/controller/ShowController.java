package com.mh.controller;


import com.mh.po.User;
import com.mh.service.LogService;
import com.mh.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Component
@Controller
public class ShowController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private LogService logService;
    /*用户登录方法*/
    @RequestMapping(value = "/index")
    public String login(String uid, String password, HttpSession session, Model model) throws Exception {
        User user = userService.selectAllByUidAndPassword(uid,password);
        System.out.println(user);
        session.setAttribute("user",user);
        model.addAttribute("uid",uid);
        if (user==null){
            return "register";
        }
        if (user.getRole()==1){
            userService.updateUserActivation(uid,1);
            logService.addLog(12,user.getUid(),user.getUname());
            return "success";
        }
//        Email email1 = new Email();
//        email1.emil(email,uid);
        return "/index";
    }
    /*默认跳转，跳转至登录页*/
    @RequestMapping("/")
    public String loginOne(){
        return "register";
    }
    @RequestMapping("/blank")
    public String blank(){
        return "blank";
    }
    /*跳转首页*/
    @RequestMapping("/go/index")
    public String index(){
        return "redirect:/goindex";
    }
    /*跳转到日历界面*/
    @RequestMapping("/calendar")
    public String calendar(){
        return "calendar";
    }
    /*跳转到日志界面*/
    @RequestMapping("/log")
    public String log(){
        return "log";
    }
    /*退出系统*/
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        User user = (User) session.getAttribute("user");
        int uid =  user.getUid();
        userService.updateUserActivation(Integer.toString(uid),0);
        session.removeAttribute("user");
        return "register";
    }
}
