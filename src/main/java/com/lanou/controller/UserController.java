package com.lanou.controller;

import com.lanou.entity.CutPage;
import com.lanou.entity.Orders;
import com.lanou.entity.User;
import com.lanou.service.OrdersService;
import com.lanou.service.UserService;
import com.lanou.util.FastJson;
import com.lanou.util.LimitPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private OrdersService ordersService;

    //    根据ID查找用户信息
    @RequestMapping(value = "/select.do")
    public void selectUser(Integer userId, HttpServletResponse response) {
        User user = userService.selectUser(userId);
        FastJson.toJson(user, response);
    }

    //登录
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public void login(String userName, String password, HttpServletResponse response, HttpSession httpSession) {

        List<User> users = userService.login(userName, password);
        boolean result = false;
        if (users.size() == 1) {
           Date date1 =  new Date();// new Date()为获取当前系统时间
            User user = users.get(0);
            List<Orders> orderss = ordersService.findorders(user);
            for (int i = 0; i<orderss.size() ; i++){
                Orders orders = orderss.get(i);
                if (orders.getStartTime()==null){
                    continue;
                }
                Date date2 =orders.getStartTime();
                long l = date1.getTime() - date2.getTime();
                long hour = l / (60 * 60 * 1000);
                if (hour>=6){
                    ordersService.updateBuyId1(orders);
                }
            }
            httpSession.setAttribute("user", user);
            httpSession.setMaxInactiveInterval(7 * 24 * 60 * 60);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", user.getUserId());
            map.put("name", user.getName());
            FastJson.toJson(map, response);

        } else {
            FastJson.toJson(result, response);
        }


    }

    @RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
    public void addUser(User user, HttpServletResponse response) {
        boolean result = userService.addUser(user);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", user.getUserId());
        map.put("mes", result);
        FastJson.toJson(map, response);
    }

    //用户名存在为:false 可用:true
    @RequestMapping(value = "/selectUserName.do", method = RequestMethod.POST)
    public void selectUserName(String userName, HttpServletResponse response) {
        boolean result = userService.selectUserName(userName);
        FastJson.toJson(result, response);
    }

    //成功true 失败false
    @RequestMapping(value = "/updateUser.do")
    public void updateUser(User user, HttpServletResponse response) {

        if (user.getName() != null) {
            boolean result = userService.updateUser(user);
            FastJson.toJson(result, response);
        } else {
            boolean result = false;
            FastJson.toJson(result, response);

        }

    }

    //修改成功 true 失败(原密码不正确 false)
    @RequestMapping(value = "/updatePassword.do", method = RequestMethod.POST)
    public void updatePassword(String password, String password1, Integer userId, HttpServletResponse response) {
        boolean result = userService.updatePassword(userId, password, password1);

        FastJson.toJson(result, response);
    }

    @RequestMapping(value = "/updateName.do", method = RequestMethod.POST)
    public void updateName(User user, HttpServletResponse response) {
        if (user.getName() != null) {
            boolean result = userService.updateName(user);

            FastJson.toJson(result, response);
        } else {
            boolean result = false;
            FastJson.toJson(result, response);

        }

    }

    @RequestMapping(value = "/updateTelephoneNumber.do", method = RequestMethod.POST)
    public void updateTelephoneNumber(User user, HttpServletResponse response) {
        System.out.println("user:" + user);
        if (user.getTelephoneNumber() != null) {
            boolean result = userService.updateTelephoneNumber(user);
            FastJson.toJson(result, response);
        } else {
            boolean result = false;
            FastJson.toJson(result, response);

        }

    }

    //后台管理;
    @RequestMapping(value = "/selectAllUser.do")
    public void selectAllUser(CutPage cutPage, HttpServletResponse response) {

        Integer count = 4;
        cutPage.setCOUNT(count);
        LimitPage limitPage = new LimitPage();
        List<User> users = userService.selectAllUser();
        List<User> users1 = limitPage.limitList(cutPage,users);
        int totalPage  =  users.size()%cutPage.getCOUNT() == 0
                ? users.size()/cutPage.getCOUNT()
                : users.size()/cutPage.getCOUNT() + 1 ;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("总页数:", totalPage);
        map.put("第"+cutPage.getPage()+"页:",users1);
        FastJson.toJson(map, response);
    }
    @RequestMapping(value = "deleteUser.do")
    public  void deleteUser(Integer[] userId , HttpServletResponse response){
        boolean  result =  userService.deleteUser(userId);
        FastJson.toJson(result,response);

    }

}
