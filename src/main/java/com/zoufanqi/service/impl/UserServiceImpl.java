package com.zoufanqi.service.impl;

import com.zoufanqi.bean.User;
import com.zoufanqi.mapper.UserMapper;
import com.zoufanqi.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public User getByUserName(String userName) {
        return this.userMapper.getByUserName(userName);
    }

    public Set<String> getRoles(String userName) {
        return this.userMapper.getRoles(userName);
    }

    public Set<String> getPermissions(String userName) {
        return this.userMapper.getPermissions(userName);
    }

}  