package com.wm.dao;

import com.wm.po.Cinema;
import com.wm.vo.CinemaVO;

import java.util.List;

/**
 * @author 陈晨
 * 电影院数据访问接口
 */
public interface CinemaDao {

    /**
     * 查找所有电影院
     * @return 电影院对象集合
     */
    public List<Cinema> findAll();

    /**
     * 根据电影院编号查找电影院对象
     * @param cinemaid 电影院编号
     * @return 电影院对象
     */
    public Cinema findByCinemaid(int cinemaid);

    /**
     * 根据电影院申请编号查找电影院
     * @param caid 电影院申请编号
     * @return 电影院对象
     */
    public Cinema findByCaid(int caid);

    /**
     * 增加电影院
     * @param cinema 电影院对象
     * @return 受影响的行数
     */
    public int add(Cinema cinema);

    /**
     * 更改电影院对象
     * @param cinema 电影院对象
     * @return 受影响的行数
     */
    public int update(Cinema cinema);

    /**
     * 删除电影院
     * @param array 电影院对象数组
     * @return 受影响的行数
     */
    public int delete(int[] array);

    public List<CinemaVO> findVOAll();
    public List<CinemaVO> findVOAllCom();
}
