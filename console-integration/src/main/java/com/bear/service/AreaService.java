package com.bear.service;

import com.bear.model.City;
import com.bear.model.District;
import com.bear.model.Province;

import java.util.List;

/**
 * Created by zhangxiong on 2017/2/26.
 */
public interface AreaService {
    List<Province> getProvince();

    List<City> getCityByProvince(String provinceId);

    List<District> getDistrictByCity(String cityId);
}
