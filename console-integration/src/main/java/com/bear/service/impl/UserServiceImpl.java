package com.bear.service.impl;

import com.bear.dto.request.CreateUserReqDto;
import com.bear.dto.request.ListUserReqDto;
import com.bear.enums.ResultCode;
import com.bear.manager.UserManager;
import com.bear.model.User;
import com.bear.service.UserService;
import com.bear.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangxiong on 2017/2/23.
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserManager userManager;

    @Override
    public User queryByAccountName(String accountName) {
        return userManager.queryByAccountName(accountName);
    }

    @Override
    @Transactional(readOnly = false)
    public void modifyPwd(Long id, String newPwd) {
        userManager.modifyPwd(id, newPwd);
    }

    @Override
    public Result list(ListUserReqDto listUserReqDto) {
        try {
            List<User> list = userManager.list(listUserReqDto);
            return Result.createResult(list);
        } catch (Exception e) {
            logger.error("list 查询用户列表异常", e);
            return Result.errorResult(ResultCode.FAIL);
        }

    }


    @Override
    public Result save(CreateUserReqDto createUserReqDto) {
        return null;
    }

    @Override
    public Result checkExist(String checkAccount, Integer type) {
        return null;
    }
}
