package com.wm.dao;

import com.wm.po.Creation;

import java.util.List;

/**
 * @author awei
 * 创作记录数据访问接口
 */
public interface CreationDao {
    /**
     * 查询所有创作记录
     * @return 创作记录集合
     */
    public List<Creation> findAll();

    /**
     * 通过创作记录编号查询所有创作记录
     * @param ctid 创作记录编号
     * @return 创作记录对象
     */
    public Creation findByCtid(int ctid);

    /**
     * 通过创作者编号查询创作记录
     * @param fid 创作者编号
     * @return 创作记录集合
     */
    public List<Creation> findByFid(int fid);

    /**
     * 通过影片编号查询创作记录
     * @param mid 影片编号
     * @return 创作记录集合
     */
    public List<Creation> findByMid(int mid);

    /**
     * 通过创作类型编号查询创作记录
     * @param creationTypeid 创作类型编号
     * @return 创作记录集合
     */
    public List<Creation> findByCreationTypeId(int creationTypeid);

    /**
     * 添加创作记录
     * @param creation 创作记录
     * @return 受影响的行数
     */
    public int add(Creation creation);
    /**
     * 更新创作记录
     * @param creation 创作记录
     * @return 受影响的行数
     */
    public int update(Creation creation);

    /**
     * 删除创作记录
     * @param array 创作记录编号数组
     * @return 受影响的行数
     */
    public int delete(int[] array);
}
