package com.bear.dto.request;

import lombok.ToString;

import java.io.Serializable;

/**
 * Created by zhangxiong on 2017/2/25.
 */
@ToString
public class ModifyPwdDto implements Serializable {
    private String accountName;
    private String oldPwd;
    private String newPwd;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
