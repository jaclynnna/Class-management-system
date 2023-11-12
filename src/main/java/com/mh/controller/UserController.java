package com.mh.controller;

import com.github.pagehelper.PageInfo;
import com.mh.po.User;
import com.mh.service.LogService;
import com.mh.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
@Component
@Controller
//@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    private LogService logService;
    //跳转到用户界面
    @RequestMapping(value = "/userShow/{pn}" , method = RequestMethod.GET)
    public String showUser(Model model, @PathVariable("pn") Integer pn, String search){
        int count = userService.getAllUserCount();
        if (count%4==0)
            count=count/4;
        else
            count=count/4+1;
        if (pn<1){
            pn=1;
        }else if(pn>count){
            pn=count;
        }
        List<User> userAll = userService.getUserByFuzzy(search,pn);
        PageInfo<User> pageInfo = new PageInfo<User>(userAll,5);
        model.addAttribute("pageInfo",pageInfo);
        return "orders";
    }
    //通过下拉框筛选用户在线状态
    @RequestMapping(value = "/userShow1/{pn}" , method = RequestMethod.GET)
    public String showUser1(Model model, @PathVariable("pn") Integer pn, String status){
        int count = userService.getAllUserCount();
        if (count%4==0)
            count=count/4;
        else
            count=count/4+1;
        if (pn<1){
            pn=1;
        }else if(pn>count){
            pn=count;
        }
        List<User> userAll = userService.getUserByFuzzy1(status,pn);
        System.out.println("user=="+userAll);
        System.out.println("Model=="+status);
        PageInfo<User> pageInfo = new PageInfo<User>(userAll,5);
        model.addAttribute("pageInfo",pageInfo);
        return "orders";
    }
    //跳转到添加页面
    @RequestMapping("/go/add")
    public String addUser(){
        return "profile";
    }
    //添加用户功能
    @RequestMapping( "/addUserInfo")
    public String addUserInfo(User user, HttpSession session){
        user.setCreateTime(new Date());
        int count = userService.insertUser(user);
        if (count>0){
            System.out.println("添加成功");
            User user1 =(User) session.getAttribute("user");
            logService.addLog(5,user1.getUid(),user1.getUname());
        }else
            System.out.println("添加失败");
        return "redirect:/userShow/1";
    }
    //清空用户登录信息
    @RequestMapping( "/clearUser")
    public String clearUser(User user, HttpSession session){
        userService.clearUser();
        return "redirect:/userShow/1";
    }
    //删除用户功能
    @RequestMapping("/delect/{uid}")
    public String delectUserById(@PathVariable("uid") int uid,HttpSession session){
        int count = userService.delectUserById(uid);
        if (count>0){
            System.out.println("删除成功");
            User user1 =(User) session.getAttribute("user");
            logService.addLog(6,user1.getUid(),user1.getUname());
        }else
            System.out.println("删除失败");
        return "redirect:/userShow/1";
    }
    /*跳转修改用户界面*/
    @RequestMapping("/editUser/{uid}")
    public String updateUserById(@PathVariable("uid") int uid,Model model){
        User userById = userService.getUserById(uid);
        model.addAttribute("userById",userById);
        return "editProfile";
    }
    /*修改用户信息*/
    @RequestMapping("/editUser")
    public String editUser(User user,HttpSession session){
        System.out.println(user);
        int count = userService.updateUserById(user);
        if (count>0){
            System.out.println("修改用户成功");
            User user1 =(User) session.getAttribute("user");
            logService.addLog(7,user1.getUid(),user1.getUname());
        }else
            System.out.println("修改用户失败");
        return "redirect:/userShow/1";
    }
    /*通过uid查询所有学生信息*/
    @RequestMapping("/getUnameById/{uid}")
    public void getUnameById(@PathVariable("uid") String uid, HttpServletResponse response) throws IOException {
        User user = userService.getUnameById(uid);
        response.getWriter().println(user == null ? "" : user.getUname());
    }

}
