package com.bear.controller;

import com.bear.dto.request.LoginDto;
import com.bear.enums.ResultCode;
import com.bear.shiro.ShiroUtils;
import com.bear.utils.Result;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * 登录类
 * Created by zhangxiong on 2017/2/19.
 */
@Controller
@RequestMapping("/account")
public class LoginController {
    @Resource
    private Producer producer;

    private Logger loggr = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //文字验证码
        String text = producer.createText();
        //图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro sesion
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        try {
            ServletOutputStream out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
        } catch (Exception e) {
            loggr.error("生成图片验证码异常", e);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody LoginDto loginDto) {

        loggr.info("login loginDto = {}", loginDto);

        String accountName = loginDto.getAccountName();
        String password = loginDto.getPassword();
        String captcha = loginDto.getCaptcha();

        if (StringUtils.isBlank(accountName) || StringUtils.isBlank(password) || StringUtils.isBlank(captcha)) {
            return Result.errorResult(ResultCode.ACCOUNT_PW_BLANK_ERROR);
        }
        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if (!StringUtils.equalsIgnoreCase(captcha, kaptcha)) {
            loggr.info("验证码错误");
            return Result.errorResult(ResultCode.CAPTCHA_ERROR);
        }

        try {
            Subject subject = ShiroUtils.getSubject();
            password = new Sha256Hash(password).toHex();
            UsernamePasswordToken token = new UsernamePasswordToken(accountName, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return Result.errorResult(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return Result.errorResult(e.getMessage());
        } catch (LockedAccountException e) {
            return Result.errorResult(e.getMessage());
        } catch (AuthenticationException e) {
            return Result.errorResult("账户验证失败");
        }
        return Result.success();
    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    @ResponseBody
    public Result loginOut() {
        ShiroUtils.logout();
        return Result.success();
    }


}
