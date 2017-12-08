package com.lanou.controller;

import com.lanou.entity.User;
import com.lanou.service.UserService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2017/12/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    //    根据ID查找用户信息
    @RequestMapping(value = "/select.do" ,method = RequestMethod.POST)
    public void selectUser(Integer userId, HttpServletResponse response) {
        User user = userService.selectUser(userId);
        FastJson.toJson(user, response);
    }
    //登录
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public void login(String userName , String password, HttpServletResponse response, HttpSession httpSession) {

        List<User> users = userService.login(userName,password);
        boolean result= false;
        if (users.size()==1){
            User user = users.get(0);
            httpSession.setAttribute("user",user);
            httpSession.setMaxInactiveInterval(7*24*60*60);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId" ,user.getUserId());
            map.put("name",user.getName());
            FastJson.toJson(map , response);

        }else {
            FastJson.toJson(result,response);
        }


    }

    @RequestMapping(value = "/addUser.do" ,method = RequestMethod.POST)
    public void addUser(User user , HttpServletResponse response) {
        boolean result = userService.addUser(user);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId" ,user.getUserId());
        map.put("mes",result);
        FastJson.toJson(map,response);
    }
    //用户名存在为:false 可用:true
    @RequestMapping(value ="/selectUserName.do",method = RequestMethod.POST)
    public void selectUserName(String userName,HttpServletResponse response){
        boolean result = userService.selectUserName(userName);
        FastJson.toJson(result,response);
    }
    //成功true 失败false
    @RequestMapping(value ="/updateUser.do",method = RequestMethod.POST)
    public void updateUser(User user,HttpServletResponse response){

        if (user.getName()!=null){
            boolean result = userService.updateUser(user);
            FastJson.toJson(result,response);
        }else {
            boolean result = false;
            FastJson.toJson(result,response);

        }

    }
    //修改成功 true 失败(原密码不正确 false)
    @RequestMapping(value ="/updatePassword.do",method = RequestMethod.POST)
    public void  updatePassword(String password , String password1 ,Integer userId,HttpServletResponse response){
        boolean result = userService.updatePassword(userId,password,password1);

        FastJson.toJson(result,response);
    }
    @RequestMapping(value ="/updateName.do" ,method = RequestMethod.POST)
    public void  updateName(User user,HttpServletResponse response){
        if (user.getName()!=null){
            boolean result = userService.updateName(user);

            FastJson.toJson(result,response);
        }else {
            boolean result = false;
            FastJson.toJson(result,response);

        }

    }
    @RequestMapping(value ="/updateTelephoneNumber.do" ,method = RequestMethod.POST)
    public void  updateTelephoneNumber(User user,HttpServletResponse response){
        System.out.println("user:"+user);
        if(user.getTelephoneNumber()!=null){
            boolean result = userService.updateTelephoneNumber(user);
            FastJson.toJson(result,response);
        }else {
            boolean result = false;
            FastJson.toJson(result,response);

        }

    }

}
