package com.lanou.controller;

import com.lanou.entity.User;
import com.lanou.service.UserService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    //    根据ID查找用户信息
    @RequestMapping(value = "/select.do")
    public void selectUser(Integer userId, HttpServletResponse response) {
        User user = userService.selectUser(userId);
        FastJson.toJson(user, response);
    }
    //    根据Id查找用户信息QWERTYUIOPASDFGHJKLZXCVBNM
    @RequestMapping(value = "/login.do")
    public void login(String userName ,String password, HttpServletResponse response) {
        List<User> users = userService.login(userName,password);
        boolean result= false;
        if (users.size()==1){
            FastJson.toJson(users, response);

        }
        FastJson.toJson(result,response);

    }

    @RequestMapping(value = "/addUser.do")
    public void addUser(String userName, String password, HttpServletResponse response) {

        boolean result = userService.addUser(userName, password);
       FastJson.toJson(result,response);

    }
    //用户名存在为:false 可用:true
    @RequestMapping(value ="/selectUserName.do" )
    public void selectUserName(String userName,HttpServletResponse response){
        boolean result = userService.selectUserName(userName);
        FastJson.toJson(result,response);
    }
    //成功true 失败false
    @RequestMapping(value ="/updateUser.do")
    public void updateUser(User user,HttpServletResponse response){
        boolean result = userService.updateUser(user);
        FastJson.toJson(result,response);
    }
    //修改成功 true 失败(原密码不正确 false)
    @RequestMapping(value ="/updatePassword.do")
    public void  updatePassword(String password , String password1 ,Integer userId,HttpServletResponse response){
        boolean result = userService.updatePassword(userId,password,password1);
        FastJson.toJson(result,response);
    }
}
