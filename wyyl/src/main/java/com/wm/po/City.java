package com.wm.po;

/**
 * @author km
 * 市的实体类
 */
public class City {
    private int id;
    private String cityId;
    private String city;
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public City(int id, String cityId, String city, int provinceId) {
        this.id = id;
        this.cityId = cityId;
        this.city = city;
        this.provinceId = provinceId;
    }

    public City() {
    }
}
