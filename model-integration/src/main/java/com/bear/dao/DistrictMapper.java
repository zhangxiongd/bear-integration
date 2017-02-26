package com.bear.dao;

import com.bear.model.District;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangxiong on 2016/12/20.
 */
public interface DistrictMapper {
    List<District> getDistrictByCity(@Param("cityId") String cityId);
}
