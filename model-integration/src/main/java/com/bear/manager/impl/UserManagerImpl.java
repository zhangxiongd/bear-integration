package com.bear.manager.impl;

import com.bear.dao.UserMapper;
import com.bear.dto.request.ListUserReqDto;
import com.bear.manager.UserManager;
import com.bear.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangxiong on 2017/2/23.
 */
@Service
public class UserManagerImpl implements UserManager {

    private Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryByAccountName(String accountName) {
        return userMapper.queryByAccountName(accountName);
    }

    @Override
    public void modifyPwd(Long id, String newPwd) {
        userMapper.modifyPwd(id, newPwd);
    }

    @Override
    public List<User> list(ListUserReqDto listUserReqDto) {
        return userMapper.list(listUserReqDto);
    }
}
