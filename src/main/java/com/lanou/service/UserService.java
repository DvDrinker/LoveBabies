package com.lanou.service;

import com.lanou.entity.User;

import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
public interface UserService {
    public List<User> login(String userName,String password);
    public boolean updatePassword(Integer userId, String password ,String password1);
    public User selectUser(Integer userId);
    public boolean updateUser(User user);
    public boolean addUser(String userName , String password);
    public boolean selectUserName(String userName);
}
