package com.wm.dao;

import com.wm.po.*;

import java.util.List;

/**
 * @author 陈晨
 * 账号状态数据访问接口
 */
public interface AccountStateDao {
    /**
     * 查找所有账号状态对象
     * @return 账号状态对象集合
     */
    public List<AccountState> findAll();

    /**
     * 根据账号状态编号查找对应的账号对象
     * @param asid 账号状态编号
     * @return 账号状态对象
     */
    public AccountState findByAsid(int asid);

    /**
     * 增加账号状态
     * @param accountstate 账号状态对象
     * @return 受影响的行数
     */
    public int add(AccountState accountstate);

    /**
     * 更改已存在的账号状态对象信息
     * @param accountstate 账号状态对象
     * @return 受影响的行数
     */
    public int update(AccountState accountstate);

    /**
     * 删除账号状态对象
     * @param array 账号状态对象数组
     * @return 受影响的行数
     */
    public int delete(int[] array);
}
