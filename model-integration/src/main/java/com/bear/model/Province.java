package com.bear.model;

import lombok.ToString;

import java.io.Serializable;

/**
 * Created by zhangxiong on 2017/2/16.
 */
@ToString
public class Province implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 省id
     */
    private String provinceId;

    private String provinceName;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
}
