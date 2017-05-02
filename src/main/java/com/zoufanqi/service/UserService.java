package com.zoufanqi.service;

import com.zoufanqi.bean.User;

import java.util.Set;

public interface UserService {

    /**
     * 通过用户名查询用户
     *
     * @param userName
     *
     * @return
     */
    User getByUserName(String userName);

    /**
     * 通过用户名查询角色信息
     *
     * @param userName
     *
     * @return
     */
    Set<String> getRoles(String userName);

    /**
     * 通过用户名查询权限信息
     *
     * @param userName
     *
     * @return
     */
    Set<String> getPermissions(String userName);
} 