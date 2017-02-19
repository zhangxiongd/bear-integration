package com.bear.controller;

import com.bear.shiro.ShiroUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/login")
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

}
