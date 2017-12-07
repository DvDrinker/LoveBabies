package com.lanou.service.impl;

import com.lanou.dao.UserMapper;
import com.lanou.entity.User;
import com.lanou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    public List<User> login(String userName, String password) {
        List<User> users = userMapper.login(userName,password);
        System.out.println(users);
            return users;

    }

    @Transactional
    public boolean updatePassword(Integer userId, String password,String password1) {
        System.out.println(password);
        System.out.println(userId);
        System.out.println(password1);

        List<String> a = userMapper.selectPasswordByUserId(userId,password);
        System.out.println("a的值:"+a);
        boolean result = false;
        if (a.size()==1){
            userMapper.updatePassword(userId,password1);
            result = true;
            return result;
        }
        return result;
    }

    @Transactional
    public User selectUser(Integer userId) {
        User user = userMapper.selectUser(userId);
        return user;
    }
    @Transactional
    public boolean updateUser(User user) {
        System.out.println("haha:"+user);

        int a = userMapper.updateUser(user.getName(), user.getUserName() ,user.getEmail() ,
        user.getCity() , user.getAddress() ,user.getTelephone(),user.getUserId());
        boolean result = false;
        if (a != 0) {
            result = true;
        }
        return result;
    }

    @Transactional
    public boolean addUser(User user) {
        System.out.println("我去"+user);

        boolean result = false;
        List<User> users =  userMapper.selectUserName(user.getUserName());
        System.out.println("user的"+users.size());
        if (users.size()==0){
            int a = userMapper.addUser(user);
            if (a == 1) {
                result = true;
                return result;
            }
        }
        return result;
    }

    @Transactional
    public boolean selectUserName(String userName) {
        List<User> users =  userMapper.selectUserName(userName);
        System.out.println("user的"+users.size());
        if (users.size()==0){
            return true;
        }

        return false;
    }

    public boolean updateName(User user) {
        boolean result = false;
        int a =  userMapper.updateName(user);

        if (a == 1) {
            result = true;
            return result;
        }

        return result;
    }

    public boolean updateTelephoneNumber(User user) {
        boolean result = false;
        int a =  userMapper.updateTelephoneNumber(user);

        if (a == 1) {
            result = true;
            return result;
        }

        return result;
    }
}
