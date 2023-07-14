package com.wm.service;

import com.wm.po.Role;

import java.util.List;

/**
 * @author 陈晨
 * 角色业务逻辑接口
 */
public interface RoleService {
    /**
     * 查找所有角色对象
     * @return 角色对象集合
     */
    public List<Role> findAll();

    /**
     * 根据角色编号查找对应的角色对象
     * @param rid 角色编号
     * @return 角色对象
     */
    public Role findByRid(int rid);
    /**
     * 根据角色名称查找对应的角色对象
     * @param rname 角色名称
     * @return 角色对象
     */
    public Role findByRname(String rname);

    /**
     * 添加角色
     * @param role 角色对象
     * @return 是否添加成功
     */
    public boolean add(Role role);

    /**
     * 更改已存在的角色对象信息
     * @param role 角色对象
     * @return 是否更新成功
     */
    public boolean update(Role role);

    /**
     * 删除角色
     * @param array 角色对象数组
     * @return 是否删除成功
     */
    public boolean delete(int[] array);
}
