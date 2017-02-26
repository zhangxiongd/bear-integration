package com.bear.utils;

import com.bear.enums.ResultCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * 通用结果类
 * Created by zhangxiong on 2017/2/19.
 */
@ToString
public class Result<T> implements Serializable {
    private T resultData;
    private ResultCode resultCode;
    private boolean isSuccess;
    private String resultMsg;
    private Map<String, Object> ext;

    public boolean isSuccess() {
        return resultCode == ResultCode.SUCCESS;
    }


    public Result() {
        this.isSuccess = true;
        this.resultCode = ResultCode.SUCCESS;
    }

    public Result(T resultData) {
        this.isSuccess = true;
        this.resultData = resultData;
        this.resultCode = ResultCode.SUCCESS;
    }

    public Result(T resultData, Map<String, Object> ext) {
        this.isSuccess = true;
        this.resultData = resultData;
        this.resultCode = ResultCode.SUCCESS;
        this.ext = ext;
    }


    public Result(ResultCode resultCode, String resultMsg) {
        this.isSuccess = false;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }


    public Result(Result errorResult) {
        this.resultCode = errorResult.resultCode;
        this.resultMsg = errorResult.resultMsg;
    }

    public static <T> Result<T> success() {
        return new Result();
    }

    public static <T> Result<T> createResult(T result) {
        return new Result<T>(result);
    }

    public static <T> Result<T> createResult(T result, Map<String, Object> ext) {
        return new Result<T>(result, ext);
    }

    public static <T> Result<T> errorResult(Result errorResult) {
        return new Result<T>(errorResult);
    }

    public static <T> Result<T> errorResult(ResultCode resultCode) {
        return new Result(resultCode, resultCode.getDesc());
    }

    public static <T> Result<T> errorResult(String errorMsg) {
        return new Result(null, errorMsg);
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public String getResultMsg() {
        return (resultMsg != null) ? resultMsg :
                (resultCode != null ? resultCode.getDesc() : null);
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }


}
