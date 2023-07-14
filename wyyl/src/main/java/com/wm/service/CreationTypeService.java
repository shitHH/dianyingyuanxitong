package com.wm.service;

import com.wm.po.CreationType;

import java.util.List;

/**
 * @author awei
 * 创作类型业务逻辑接口
 */
public interface CreationTypeService {
    /**
     * 查询所有创作类型
     * @return 创作类型集合
     */
    public List<CreationType> findAll();

    /**
     * 通过创作类型编号查询创作类型对象
     * @param creationTypeid 创作类型编号
     * @return 创作类型对象
     */
    public CreationType findByCreationTypeId(int creationTypeid);

    /**
     * 添加创作类型
     * @param creationType 创作类型对象
     * @return 是否成功
     */
    public boolean add(CreationType creationType);

    /**
     * 更新创作类型
     * @param creationType 创作类型对象
     * @return 是否成功
     */
    public boolean update(CreationType creationType);

    /**
     * 删除创作类型
     * @param array 创作类型编号数组
     * @return 是否成功
     */
    public boolean delete(int[] array);
}
