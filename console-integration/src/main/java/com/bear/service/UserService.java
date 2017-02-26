package com.bear.service;

import com.bear.dto.request.CreateUserReqDto;
import com.bear.dto.request.ListUserReqDto;
import com.bear.model.User;
import com.bear.utils.Result;

/**
 * Created by zhangxiong on 2017/2/23.
 */
public interface UserService {
    User queryByAccountName(String accountName);

    void modifyPwd(Long id, String newPwd);

    Result list(ListUserReqDto listUserReqDto);

    Result save(CreateUserReqDto createUserReqDto);

    Result checkExist(String checkAccount, Integer type);

}
