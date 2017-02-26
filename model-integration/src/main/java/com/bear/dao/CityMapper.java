package com.bear.dao;

import com.bear.model.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangxiong on 2016/12/20.
 */
public interface CityMapper {
    List<City> getCityByProvince(@Param("provinceId") String provinceId);
}
