package com.zoufanqi.realm;

import com.zoufanqi.bean.User;
import com.zoufanqi.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;

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
        if (userName != null) return null;

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //根据此用户名查询是否拥有   此角色  
        //返回的是一个字符串集合
        Set<String> a = userService.getRoles(userName);
        authorizationInfo.setRoles(a);
        //根据用户名查询是否拥有   此权限
        Set<String> b = userService.getPermissions(userName);
        authorizationInfo.setStringPermissions(b);
        return authorizationInfo;
    }

    /**
     * 验证当前登录的用户
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken uToken = (UsernamePasswordToken)token;
        String userName = uToken.getUsername();
        char[] passwords = uToken.getPassword();

        if (userName == null || passwords == null) return null;

        StringBuilder sb = new StringBuilder();
        for (char c : passwords) {
            sb.append(c);
        }
        String password = sb.toString();

        //根据用户名查询此用户是否存在
        User user = userService.getByUserName(userName);
        if (user == null || !password.equals(user.getPassword())) return null;

        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userName, user.getPassword(), getName());
        return authcInfo;
    }
} 