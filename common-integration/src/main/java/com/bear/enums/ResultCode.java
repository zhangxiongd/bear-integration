package com.bear.enums;

/**
 * Created by zhangxiong on 2017/2/19.
 */
public enum ResultCode {
    SUCCESS("0000", "操作成功"),
    FAIL("2000", "网络异常"),

    CAPTCHA_ERROR("1001", "验证码错误"),
    ACCOUNT_PW_BLANK_ERROR("1002", "账号密码必填"),
    ACCOUNT_PW_ERROR("1003", "账号或者密码错误");


    private String code, desc;

    ResultCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultCode parse(String resultCode) {
        for (ResultCode code : ResultCode.values()) {
            if (code.getCode().equals(resultCode)) {
                return code;
            }
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
