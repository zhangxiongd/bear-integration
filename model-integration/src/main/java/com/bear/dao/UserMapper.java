package com.bear.dao;

import com.bear.dto.request.ListUserReqDto;
import com.bear.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangxiong on 2017/2/16.
 */
public interface UserMapper {
    User queryByAccountName(@Param("accountName") String accountName);

    void modifyPwd(@Param("id") Long id, @Param("newPwd") String newPwd);

    List<User> list(ListUserReqDto listUserReqDto);
}
