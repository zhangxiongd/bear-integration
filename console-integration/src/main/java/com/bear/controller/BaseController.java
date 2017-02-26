package com.bear.controller;

import com.bear.model.User;
import com.bear.shiro.ShiroUtils;

/**
 * Created by zhangxiong on 2017/2/25.
 */
public class BaseController {
    protected User getUser() {
        return ShiroUtils.getUser();
    }

}
