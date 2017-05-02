package com.vanki.service.impl;

import com.vanki.bean.User;
import com.vanki.mapper.UserMapper;
import com.vanki.service.UserService;
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