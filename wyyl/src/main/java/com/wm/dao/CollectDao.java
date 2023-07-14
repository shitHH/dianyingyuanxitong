package com.wm.dao;

import com.wm.po.Collect;

import java.util.List;

/**
 * @author yy
 * @version 1.0
 * @project java0613-3-group-project-3
 * @date 2022/10/8 09:38:15
 */
public interface CollectDao {

    /**
     * 查看收藏
     * @return 收藏对象集合
     */
    public List<Collect> findAll();

    /**
     * @param collecttype 影片收藏类型
     * @return 影片收藏对象集合
     */
    public List<Collect> findByCollectType(String collecttype);

    /**
     * 添加收藏
     * @param collect 收藏的对象
     * @return 受影响行数
     */
    public int add(Collect collect);

    /**
     * 删除收藏
     * @param ids 收藏对象编号数组
     * @return 受影响行数
     */
    public int delete(int[] ids);

    /**
     * @param mid 影片编号
     * @param aid 账号编号
     * @return 收藏对象
     */
    public Collect findByMidAndAid(int mid, int aid);

    public List<Collect> findByMid(int mid);
}
