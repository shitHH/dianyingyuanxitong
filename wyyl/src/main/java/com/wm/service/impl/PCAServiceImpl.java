package com.wm.service.impl;


import com.wm.dao.PCADao;
import com.wm.po.Area;
import com.wm.po.City;
import com.wm.po.Province;
import com.wm.service.PCAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author km
 * 省市区的业务逻辑接口
 */
@Service
public class PCAServiceImpl implements PCAService {

    @Autowired
    private PCADao pcaDao;
    @Override
    public List<Province> findAll() {
        return pcaDao.findAll();
    }

    @Override
    public List<City> findCityByPid(String provinceId) {
        return pcaDao.findCityByPid(provinceId);
    }

    @Override
    public List<Area> findAreaByCid(String cityId) {
        return pcaDao.findAreaByCid(cityId);
    }
}
