package com.wm.dao;

import com.wm.po.Account;
import com.wm.vo.AccountVo;

import java.util.List;

/**
 * @author 陈晨
 * 账号数据访问接口
 */
public interface AccountDao {

    /**
     * 查找所有账号对象
     * @return 账号对象集合
     */
    public List<Account> findAll();

    /**
     * @return 账号视图对象集合
     */
    public List<AccountVo> findVoAll();

    /**
     * 根据角色编号查找账号对象
     * @param rid 角色编号
     * @return 账号对象集合
     */
    public List<Account> findByRid(int rid);

    /**
     * 根据角色编号查找账号视图对象
     * @param rid 角色编号
     * @return 账号对象集合
     */
    public List<AccountVo> findVoByRid(int rid);

    /**
     * @return 管理员列表
     * 查询所有管理员
     */
    public List<AccountVo> findVoByRid1();

    /**
     * 根据账号状态查找查找账号对象
     * @param asid 账号状态编号
     * @return 账号对象集合
     */
    public List<Account> findByAsid(int asid);

    /**
     * 根据账号编号查找账号视图对象
     * @param asid 账号状态编号
     * @return 账号视图对象集合
     */
    public List<AccountVo> findVoByAsid(int asid);

    /**
     * 根据账号名称模糊查询账号对象
     * @param aname 账号名称
     * @return 账号对象集合
     */
    public List<Account> findByAname(String aname);

    /**
     * 根据账号名称模糊查找账号视图对象
     * @param aname 账号名称
     * @return 账号视图对象集合
     */
    public List<AccountVo> findVoByAname(String aname);

    /**
     * 根据账号编号查找账号对象
     * @param aid 账号编号
     * @return 账号对象
     */
    public Account findByAid(int aid);

    /**
     * 根据电话查找对应账号对象
     * @param tel 账号电话
     * @return 账号对象
     */
    public Account findByTel(String tel);

    /**
     * 根据账号所属Ip查找账号对象
     * @param ip Ip地址
     * @return 账号对象
     */
    public Account findByIp(String ip);

    /**
     * 根据电话与密码查找账号对象
     * @param tel 账号电话
     * @param pass 账号密码
     * @return 账号对象
     */
    public Account findByIelAndPass(String tel,String pass);

    /**
     * 根据电话与密码查找账号对象
     * @param tel 账号电话
     * @param pass 账号密码
     * @return 账号视图对象
     */
    public AccountVo findVoByTelAndPass(String tel,String pass);

    /**
     * 根据账号编号与密码查找账号对象
     * @param aid 账号编号
     * @param pass 账号密码
     * @return 账号对象
     */
    public Account findByAidAndPass(int aid,String pass);
    /**
     * 根据账号编号与密码查找账号对象
     * @param aid 账号编号
     * @param pass 账号密码
     * @return 账号视图对象
     */
    public AccountVo findVoByAidAndPass(int aid,String pass);

    /**
     * 新增账号
     * @param account 账号对象
     * @return 受影响的行数
     */
    public int add(Account account);
    public int addCinemaAccount(Account account);
    public int addAdmin(Account account);

    /**
     * 修改当前已有账号信息
     * @param account 账号对象
     * @return 受影响的行数
     */
    public int update(Account account);

    /**
     * 删除账号
     * @param array 账号对象数组
     * @return 受影响的行数
     */
    public int delete(int[] array);

    public AccountVo findVOByAid(int aid);

    public Account findByCinemaid(int cinemaid);
}
