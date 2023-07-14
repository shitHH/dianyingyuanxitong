package com.wm.dao;

import com.wm.po.CinemaApply;

import java.util.List;

/**
 * @author 陈晨
 * 电影院申请数据访问接口
 */
public interface CinemaApplyDao {
    /**
     * 查找所有电影院申请对象
     * @return 电影院申请对象集合
     */
    public List<CinemaApply> findAll();

    /**
     * 根据电影院申请编号查找电影院申请对象
     * @param caid 电影院申请编号
     * @return 电影院申请对象
     */
    public CinemaApply findByCaid(int caid);

    /**
     * 电影院申请
     * @param cinemaApply 电影院申请对象
     * @return 受影响的行数
     */
    public int add(CinemaApply cinemaApply);

    /**
     * 更改电影院申请信息
     * @param cinemaApply 电影院申请对象
     * @return 受影响的行数
     */
    public int update(CinemaApply cinemaApply);

    /**
     * 删除电影院申请对象
     * @param array 电影院申请对象数组
     * @return 受影响的行数
     */
    public int delete(int[] array);
    public List<CinemaApply> findByCastate(String castate);
}
