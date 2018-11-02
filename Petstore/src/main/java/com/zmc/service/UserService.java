package com.zmc.service;

import com.zmc.dao.UserMapper;
import com.zmc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(String username) {
        return userMapper.deleteByPrimaryKey(username);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(Integer uId) {
        return userMapper.selectByPrimaryKey(uId);
    }

    @Override
    public User selectByUserNumber(String username) {
        return userMapper.selectByUserNumber(username);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
