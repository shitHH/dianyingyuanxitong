package com.wm.dao;


import com.wm.po.Role;

import java.util.List;

/**
 * @author 陈晨
 * 角色数据访问接口
 */
public interface RoleDao {
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
     * 根据角色名称查找角色对象
     * @param rname 角色名称
     * @return 角色对象
     */
    public Role findByRname(String rname);

    /**
     * @param role 角色对象
     * @return 受影响的行数
     */
    public int add(Role role);

    /**
     * 更改已存在的角色对象信息
     * @param role 角色对象
     * @return 受影响的行数
     */
    public int update(Role role);

    /**
     * 删除角色
     * @param array 角色对象数组
     * @return 受影响的行数
     */
    public int delete(int[] array);
}
