package com.wm.service;



import com.wm.po.Area;
import com.wm.po.City;
import com.wm.po.Province;

import java.util.List;

/**
 * @author km
 * 省市区的业务逻辑接口
 */
public interface PCAService {
    /**
     * 查询所有省
     * @return 省的对象集合
     */
    public List<Province> findAll();
    /**
     * 根据省的编号查询市的集合
     * @param provinceId 省的编号
     * @return 市的集合
     */
    public List<City> findCityByPid(String provinceId);

    /**
     * 根据市的编号查询区县的集合
     * @param cityId 市的编号
     * @return 区县的集合
     */
    public List<Area> findAreaByCid(String cityId);

}
