package com.zmc.dao;

import com.zmc.model.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String username);

    int insert(User record);

    User selectByPrimaryKey(Integer uId);

    User selectByUserNumber(String username);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User login(User user);

}