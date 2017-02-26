package com.bear.shiro;

import com.bear.model.User;
import com.bear.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * 认证
 * Created by zhangxiong on 2017/2/18.
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;


    /**
     * 授权(验证权限时调用)
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        Long id = user.getId();
        //系统管理员身份,获取所有权限
        if (user.getIsAdmin() == 1) {
                
        } else {

        }
        return null;
    }


    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accountName = token.getPrincipal() != null ? token.getPrincipal().toString() : "";
        String password = new String((char[]) token.getCredentials());

        User user = userService.queryByAccountName(accountName);

        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }

        if (!StringUtils.equals(password, user.getPassword())) {
            throw new IncorrectCredentialsException("密码不正确");
        }

        if (user.getIsDelete() == 1) {
            throw new LockedAccountException("账户已被锁定，请联系管理员");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());

        return info;
    }
}
