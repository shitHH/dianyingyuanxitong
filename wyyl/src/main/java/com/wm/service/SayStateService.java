package com.wm.service;

import com.wm.po.SayState;

import java.util.List;

/**
 * @author awei
 * 发言状态业务逻辑接口
 */
public interface SayStateService {
    /**
     * 通过发言状态编号查询发言状态
     * @param ssid 发言状态编号
     * @return 影评对象
     */
    public SayState findBySsid(int ssid);

    /**
     * 查询所有发言状态
     * @return 发言状态名称
     */
    public List<SayState> findAll();

    /**
     * 添加发言状态
     * @param sayState 发言状态
     * @return 受影响的行数
     */
    public boolean add(SayState sayState);

    /**
     * 更新发言状态
     * @param sayState 发言状态
     * @return 受影响的行数
     */
    public boolean update(SayState sayState);

    /**
     * 删除发言状态
     * @param array 发言状态数组
     * @return 受影响的行数
     */
    public boolean delete(int[] array);
}
