package com.wm.dao;

import com.wm.po.MovieType;

import java.util.List;

/**
 * @author km
 * 影片类型数据访问接口
 */
public interface MovieTypeDao {

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
     * @return 受影响的行数
     */
    public int add(MovieType movieType);

    /**
     * 修改影片类型
     * @param movieType 影片类型对象
     * @return 受影响的行数
     */
    public int update(MovieType movieType);

    /**
     * 删除影片类型
     * @param mtids 影片类型编号数组
     * @return 受影响的行数
     */
    public int delete(int[] mtids);

}
