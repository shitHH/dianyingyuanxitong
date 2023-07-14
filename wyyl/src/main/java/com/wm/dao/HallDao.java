package com.wm.dao;

import com.wm.po.Hall;
import com.wm.vo.HallVO;

import java.util.List;

/**
 * @author bilie
 * 影厅的数据访问接口
 */
public interface HallDao {

    /**
     * 查看所有影厅
     * @return 影厅的集合
     */
    public List<Hall> findAll();

    /**
     * 查询影院中的所有影厅
     * @param cinemaid 影院编号
     * @return 影厅集合
     */
    public List<Hall> findByCinemaid(int cinemaid);

    /**
     * 根据影厅编号查询影厅
     * @param hid 影厅编号
     * @return 影厅对象
     */
    public Hall findById(int hid);


    /**
     * 查询影厅视图
     * @param hid 影厅编号
     * @return 影厅视图对象
     */
    public HallVO findVOByHid(int hid);

    /**
     * 添加影厅
     * @param hall 影厅对象
     * @return 受影响的行数
     */
    public int add(Hall hall);

    /**
     * 修改影厅
     * @param hall 影厅对象
     * @return 受影响的行数
     */
    public int update(Hall hall);

    /**
     * 删除影厅
     * @param array 影厅编号数组
     * @return 受影响的行数
     */
    public int delete(int[] array);

    public List<HallVO> findVOByCinemaid(int cinemaid);
}
