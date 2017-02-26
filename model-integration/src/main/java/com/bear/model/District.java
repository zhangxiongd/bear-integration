package com.bear.model;

import lombok.ToString;

import java.io.Serializable;

/**
 * Created by zhangxiong on 2017/2/16.
 */
@ToString
public class District implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 市id
     */
    private String cityId;

    private String districtId;

    private String districtName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
