package com.lanou.dao;

import com.lanou.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by lanou on 2017/12/2.
 */
public interface UserMapper {
    public List<User> login(@Param("userName") String userName, @Param("password") String password);

    public List<String> selectPasswordByUserId(@Param("userId") Integer userId, @Param("password") String password);

    public int updatePassword(@Param("userId") Integer userId, @Param("password1") String password);
    public int updateName(User user);
    public int updateTelephoneNumber(User user);

    public User selectUser(Integer userId);

    public int addUser(@Param("userName") String userName, @Param("password") String password);

    public List<User> selectUserName(String userName);

    public int updateUser(@Param("name") String name, @Param("userName") String userName,
                          @Param("email") String email, @Param("city") String city,
                          @Param("address") String address, @Param("telephone") String telephone,
                          @Param("userId") Integer userId);
}
