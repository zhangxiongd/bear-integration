package com.bear.facade;

import com.bear.service.UserService;

/**
 * Created by zhangxiong on 2017-04-12.
 */
public class UserServiceFacade implements UserService {
    @Override
    public String getName(String name) {
        System.out.println("Dubbo 服务被调name =" + name);
        return name;
    }
}
