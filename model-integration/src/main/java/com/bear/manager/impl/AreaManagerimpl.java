package com.bear.manager.impl;

import com.bear.dao.CityMapper;
import com.bear.dao.DistrictMapper;
import com.bear.dao.ProvinceMapper;
import com.bear.manager.AreaManager;
import com.bear.model.City;
import com.bear.model.District;
import com.bear.model.Province;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangxiong on 2017/2/26.
 */
@Service
public class AreaManagerimpl implements AreaManager {
    @Resource
    private ProvinceMapper provinceMapper;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private DistrictMapper districtMapper;


    @Override
    public List<Province> getProvince() {
        return provinceMapper.getProvince();
    }

    @Override
    public List<City> getCityByProvince(String provinceId) {
        return cityMapper.getCityByProvince(provinceId);
    }

    @Override
    public List<District> getDistrictByCity(String cityId) {
        return districtMapper.getDistrictByCity(cityId);
    }
}
