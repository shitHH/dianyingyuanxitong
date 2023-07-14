package com.wm.dao;

import com.wm.po.Movies;
import com.wm.vo.MoviesVO;

import java.util.List;
import java.util.Map;

/**
 * @author km
 * 影片数据访问接口
 */
public interface MoviesDao {
    /**
     * 查询所有
     * @return 影片集合
     */
    public List<Movies> findAll();

    /**
     * 根据影片编号查询影片
     * @param mid 影片编号
     * @return 影片
     */
    public Movies findByMid(int mid);

    /**
     * 根据影片编号查询影片视图
     * @param mid 影片编号
     * @return 影片视图
     */
    public MoviesVO findVOByMid(int mid);

    /**
     * 根据影片类型查询影片
     * @param mtid 影片类型编号
     * @return 影片视图集合
     */
    public List<MoviesVO> findVOByMtid(int mtid);

    /**
     * 查询所有
     * @return 影片视图集合
     */
    public List<MoviesVO> findVOAll();

    /**
     * 根据影片名查询影片视图
     * @param mname 影片名
     * @return 影片视图集合
     */
    public List<MoviesVO> findVOByManme(String mname);
    /**
     * 根据影片名查询影片
     * @param mname 影片名
     * @return 影片集合
     */
    public  List<Movies> findByManme(String mname);
    /**
     * 根据影片状态查询影片
     * @param moviestate 影片状态
     * @return 影片
     */
    public  List<Movies> findByMovieState(String moviestate);
    /**
     * 根据影片状态查询影片视图
     * @param moviestate 影片状态
     * @return 影片视图集合
     */
    public  List<MoviesVO> findVOByMovieState(String moviestate);
    /**
     * 添加
     * @param movies 影片对象
     * @return 受影响的行数
     */
    public int  insert(Movies movies);

    /**
     * 更新影片
     * @param movies 影片对象
     * @return 受影响的行数
     */
    public int update(Movies movies);

    /**
     * 批量删除
     * @param mids 影片编号的数组
     * @return 受影响的行数
     */
    public int delete(int[] mids);

    /**
     * 查询影片的总评分
     * @return
     */
    public List<MoviesVO> findByMoviereating();

}
