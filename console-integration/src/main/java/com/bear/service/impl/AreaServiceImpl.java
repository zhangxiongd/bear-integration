package com.bear.service.impl;

import com.bear.manager.AreaManager;
import com.bear.model.City;
import com.bear.model.District;
import com.bear.model.Province;
import com.bear.service.AreaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangxiong on 2017/2/26.
 */
@Service
@Transactional(readOnly = false)
public class AreaServiceImpl implements AreaService {

    @Resource
    private AreaManager areaManager;

    @Override
    public List<Province> getProvince() {
        return areaManager.getProvince();
    }

    @Override
    public List<City> getCityByProvince(String provinceId) {
        return areaManager.getCityByProvince(provinceId);
    }

    @Override
    public List<District> getDistrictByCity(String cityId) {
        return areaManager.getDistrictByCity(cityId);
    }
}
