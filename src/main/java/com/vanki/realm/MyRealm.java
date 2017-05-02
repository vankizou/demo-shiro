package com.vanki.realm;

import com.vanki.bean.User;
import com.vanki.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    /**
     * 为当限前登录的用户授予角色和权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取当前登入的用户名  
        String userName = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //根据此用户名查询是否拥有   此角色  
        //返回的是一个字符串集合  
        authorizationInfo.setRoles(userService.getRoles(userName));
        //根据用户名查询是否拥有   此权限  
        authorizationInfo.setStringPermissions(userService.getPermissions(userName));
        return authorizationInfo;
    }

    /**
     * 验证当前登录的用户
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取当前登入的用户名  
        String userName = (String) token.getPrincipal();
        //根据用户名查询此用户是否存在
        User user = userService.getByUserName(userName);
        if (user != null) {
            //如果存在就
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), "xx");
            return authcInfo;
        } else {
            return null;
        }
    }
} 