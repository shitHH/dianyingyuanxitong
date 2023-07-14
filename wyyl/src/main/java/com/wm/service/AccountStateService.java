package com.wm.service;

import com.wm.po.AccountState;

import java.util.List;

/**
 * @author 陈晨
 * 账号状态业务逻辑接口
 */
public interface AccountStateService {
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
     * @return 是否添加成功
     */
    public boolean add(AccountState accountstate);

    /**
     * 更改已存在的账号状态对象信息
     * @param accountstate 账号状态对象
     * @return 是否更新成功
     */
    public boolean update(AccountState accountstate);

    /**
     * 删除账号状态对象
     * @param array 账号状态对象数组
     * @return 是否删除成功
     */
    public boolean delete(int[] array);
}
