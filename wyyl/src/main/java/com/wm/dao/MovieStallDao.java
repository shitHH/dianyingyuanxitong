package com.wm.dao;

import com.wm.po.MovieStall;
import com.wm.vo.MovieStallVO;

import java.util.List;

/**
 * @author km
 * 影片档期数据访问接口
 */
public interface MovieStallDao {
    /**
     * 查询所有
     * @return 影片档期集合
     */
    public List<MovieStall> findAll();

    /**
     * 根据影片档期编号查询影片档期
     * @param msid 影片档期编号
     * @return 影片档期
     */
    public MovieStall findByMsid(int msid);

    /**
     * 根据影片编号查询影片档期集合
     * @param mid 影片编号
     * @return 影片档期集合
     */
    public  List<MovieStall> findByMid(int mid);

    /**
     * 根据影片及影厅编号查询影片档期集合
     * @param hid 影厅编号
     * @param mid 影片编号
     * @return 影片档期记录
     */
    public  List<MovieStall> findByMidAndHid(int hid,int mid);

    /**
     * 查询所有
     * @return 影片档期视图集合
     */
    public List<MovieStallVO> findVOAll();

    /**
     * 根据影片档期编号查询影片档期视图
     * @param msid 影片档期编号
     * @return 影片档期视图
     */
    public MovieStallVO findVOByMsid(int msid);

    /**
     * 根据影片编号查询影片档期视图集合
     * @param mid 影片编号
     * @return 影片档期视图集合
     */
    public  List<MovieStallVO> findVOByMid(int mid);

    /**
     * 根据影片及影厅编号查询影片档期视图集合
     * @param hid 影厅编号
     * @param mid 影片编号
     * @return 影片档期记录视图
     */
    public  List<MovieStallVO> findVOByMidAndHid(int hid,int mid);
    /**
     * 根据影片及影院编号查询影片档期视图集合
     * @param cinemaid 影院编号
     * @param mid 影片编号
     * @return 影片档期记录视图
     */
    public  List<MovieStallVO> findVOByMidAndCinemaid(int cinemaid,int mid);

    /**
     * 添加档期
     * @param movieStall 影片档期对象
     * @return 受影响的行数
     */
    public int  insert(MovieStall movieStall);

    /**
     * 更新影片档期
     * @param movieStall 影片档期对象
     * @return 受影响的行数
     */
    public int update(MovieStall movieStall);

    /**
     * 批量删除
     * @param msids 影片档期编号的数组
     * @return 受影响的行数
     */
    public int delete(int[] msids);

    public List<MovieStallVO> findVOByCinemaid(int cinemaid);

    public List<MovieStallVO> findVOByHid(int hid);

    public List<MovieStallVO> findVOByCity(String city);

    public List<MovieStallVO> findVOByMidOnly(int mid);
}
