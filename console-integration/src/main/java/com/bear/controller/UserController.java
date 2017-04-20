package com.bear.controller;

import com.bear.dto.request.CreateUserReqDto;
import com.bear.dto.request.ListUserReqDto;
import com.bear.dto.request.ModifyPwdDto;
import com.bear.dto.response.UserInfoRespDto;
import com.bear.enums.ResultCode;
import com.bear.model.User;
import service.UserService;
import com.bear.shiro.ShiroUtils;
import com.bear.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by zhangxiong on 2017/2/25.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/modifyPwd")
    @ResponseBody
    public Result modifyPwd(@RequestBody ModifyPwdDto modifyPwdDto) {
        logger.info("UserController modifyPwd modifyPwdDto = {}", modifyPwdDto);
        User user = getUser();
        if (!StringUtils.equals(user.getAccountName(), modifyPwdDto.getAccountName()) || !StringUtils.equals(user.getPassword(), new Sha256Hash(modifyPwdDto.getOldPwd()).toHex())) {
            return Result.errorResult(ResultCode.ACCOUNT_PW_ERROR);
        }

        try {
            userService.modifyPwd(user.getId(), new Sha256Hash(modifyPwdDto.getNewPwd()).toHex());
            ShiroUtils.logout();
        } catch (Exception e) {
            logger.error("修改密码异常", e);
            return Result.errorResult(ResultCode.FAIL);
        }

        return Result.success();
    }


    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Result<UserInfoRespDto> getUserInfo() {
        User user = ShiroUtils.getUser();
        UserInfoRespDto userInfo = new UserInfoRespDto();
        userInfo.setAccountName(user.getAccountName());
        return Result.createResult(userInfo);
    }


    @RequestMapping("/list")
    @ResponseBody
    public Result list(@RequestBody ListUserReqDto listUserReqDto) {
        logger.info("list listUserReqDto = {}", listUserReqDto);
        return userService.list(listUserReqDto);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody CreateUserReqDto createUserReqDto) {
        return userService.save(createUserReqDto);
    }

    @RequestMapping(value = "/checkExist", method = RequestMethod.GET)
    @ResponseBody
    public Result checkExist(@Param("checkAccount") String checkAccount, @Param("type") Integer type) {
        return userService.checkExist(checkAccount, type);
    }

}
