package com.wm.service;

import com.wm.po.MoviePool;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * @author km
 * 影池业务逻辑接口
 */
public interface MoviePoolService {
    /**
     * 查询所有影池
     * @return 影池集合
     */
    public List<MoviePool> findAll();

    /**
     * 根据影池名称查询影池对象
     * @param mpname 影池名称
     * @return 影池对象
     */
    public List<MoviePool> findByMpname(String mpname);
    /**
     * 根据影池编号查询影池对象
     * @param mpid 影池编号
     * @return 影池对象
     */
    public MoviePool findById(String mpid);

    /**
     * 增加
     * @param moviePool 影池对象
     */
    public void insert(MoviePool moviePool);
    /**
     * 更新热度
     * @param moviePool 影池对象
     */
    public void updateHotNumber(MoviePool moviePool);
    /**
     * 更新基本内容，
     * @param moviePool 影池对象
     */
    public void updateMpcontent(MoviePool moviePool);
    /**
     * 更新管理员
     * @param moviePool 影池对象
     */
    public void updateManager(MoviePool moviePool);
    /**
     * 更新黑名单
     * @param moviePool 影池对象
     */
    public void updateBlacklist(MoviePool moviePool);
    /**
     * 更新状态
     * @param moviePool 影池对象
     */
    public void updateState(MoviePool moviePool);
}
