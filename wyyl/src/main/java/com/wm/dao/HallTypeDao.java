package com.wm.dao;

import com.wm.po.HallType;

import java.util.List;

/**
 * @author bilie
 * 影厅类型数据访问接口
 */
public interface HallTypeDao {

    /**
     * 查询所有影厅类型
     * @return
     */
    public List<HallType> findAll();

    /**
     * 根据影厅类型编号查询影厅类型
     * @param htid 影厅类型编号
     * @return 影厅类型对象
     */
    public HallType findById(int htid);

    /**
     * 添加影厅类型
     * @param hallType 影厅类型对象
     * @return 受影响的行数
     */
    public int add(HallType hallType);

    /**
     * 修改影厅类型
     * @param hallType 影厅类型对象
     * @return 受影响的行数
     */
    public int update(HallType hallType);

    /**
     * 删除影厅类型
     * @param array 影厅类型编号数组
     * @return 受影响的行数
     */
    public int delete(int[] array);

}
