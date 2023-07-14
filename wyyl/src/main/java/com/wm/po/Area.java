package com.wm.po;

/**
 * @author km
 * 城区实体类
 */
public class Area {
    private int id;
    private String areaId;
    private String areas;
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public Area(int id, String areaId, String areas, int cityId) {
        this.id = id;
        this.areaId = areaId;
        this.areas = areas;
        this.cityId = cityId;
    }

    public Area() {
    }
}
