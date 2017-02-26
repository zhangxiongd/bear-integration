package com.bear.manager;

import com.bear.dto.request.ListUserReqDto;
import com.bear.model.User;

import java.util.List;

/**
 * Created by zhangxiong on 2017/2/23.
 */
public interface UserManager {

    User queryByAccountName(String accountName);

    void modifyPwd(Long id, String newPwd);

    List<User> list(ListUserReqDto listUserReqDto);

}
