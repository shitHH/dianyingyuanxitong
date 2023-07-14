package com.wm.service;

import com.wm.po.MovieType;

import java.util.List;

/**
 * @author km
 * 影片类型业务逻辑接口
 */
public interface MovieTypeService {

    /**
     * 查询所有影片类型
     * @return
     */
    public List<MovieType> findAll();

    /**
     * 根据影片类型编号查询影片类型
     * @param mtid 影片类型编号
     * @return 影片类型对象
     */
    public MovieType findById(int mtid);

    /**
     * 添加影片类型
     * @param movieType 影片类型对象
     * @return 是否成功
     */
    public boolean add(MovieType movieType);

    /**
     * 修改影片类型
     * @param movieType 影片类型对象
     * @return 是否成功
     */
    public boolean update(MovieType movieType);

    /**
     * 删除影片类型
     * @param mtids 影片类型编号数组
     * @return 是否成功
     */
    public boolean delete(int[] mtids);

}
