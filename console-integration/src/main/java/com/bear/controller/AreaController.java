package com.bear.controller;

import com.bear.model.City;
import com.bear.model.District;
import com.bear.model.Province;
import com.bear.service.AreaService;
import com.bear.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangxiong on 2017/2/26.
 */
@Controller
@RequestMapping("/area")
public class AreaController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Resource
    private AreaService areaService;

    @RequestMapping("/getProvince")
    @ResponseBody
    public Result<List<Province>> getProvince() {
        return Result.createResult(areaService.getProvince());

    }

    @RequestMapping("/getCityByProvince")
    @ResponseBody
    public Result<List<City>> getCityByProvince(@RequestParam("provinceId") String provinceId) {
        return Result.createResult(areaService.getCityByProvince(provinceId));
    }

    @RequestMapping("/getDistrictByCity")
    @ResponseBody
    public Result<List<District>> getDistrictByCity(@RequestParam("cityId") String cityId) {
        return Result.createResult(areaService.getDistrictByCity(cityId));
    }
}
