package com.bear.dto.request;

import lombok.ToString;

import java.io.Serializable;

/**
 * Created by zhangxiong on 2017/2/25.
 */
@ToString
public class LoginDto implements Serializable {
    private String accountName;
    private String password;
    private String captcha;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
