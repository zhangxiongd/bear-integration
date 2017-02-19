package com.bear.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Shiro权限标签(Velocity版)
 * Created by zhangxiong on 2017/2/18.
 */
public class VelocityShiro {

    /**
     * 判断是否有权限
     *
     * @param permission 权限字符串
     * @return ture: 有权限  false:没权限
     */
    public boolean hasPermission(String permission) {
        Subject subject = SecurityUtils.getSubject();
        return subject != null && subject.isPermitted(permission);
    }
}
