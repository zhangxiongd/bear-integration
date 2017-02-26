package com.bear.dto.request;

import lombok.ToString;

import java.io.Serializable;

/**
 * Created by zhangxiong on 2017/2/25.
 */
@ToString
public class ListUserReqDto implements Serializable {
    private String accountName;
    private String mobile;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
