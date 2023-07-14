package com.wm.service;


import com.wm.po.Complaint;
import com.wm.vo.ComplaintVO;

import java.util.List;

/**
 * @author km
 * 投诉建议业务逻辑接口
 */
public interface ComplaintService {
    /**
     * 查询所有
     * @return 投诉集合
     */
    public List<Complaint> findAll();

    /**
     * 根据投诉编号查询投诉对象
     * @param cpid 投诉编号
     * @return 投诉对象
     */
    public Complaint findByCpid(int cpid);
    /**
     * 根据影院编号查询投诉对象
     * @param cinemaid 影院编号
     * @return 投诉集合
     */
    public  List<Complaint> findByCinemaid(int cinemaid);

    /**
     * 根据账号编号查询投诉
     * @param aid 账号编号
     * @return 投诉集合
     */
    public  List<Complaint> findByAid(int aid);

    /**
     * 查询所有
     * @return 投诉视图集合
     */
    public List<ComplaintVO> findVOAll();

    /**
     * 根据投诉编号查询投诉视图对象
     * @param cpid 投诉编号
     * @return 投诉视图对象
     */
    public ComplaintVO findVOByCpid(int cpid);
    /**
     * 根据影院编号查询投诉视图对象
     * @param cinemaid 影院编号
     * @return 投诉视图集合
     */
    public  List<ComplaintVO> findVOByCinemaid(int cinemaid);

    /**
     * 根据账号编号查询投诉视图
     * @param aid 账号编号
     * @return 投诉视图集合
     */
    public  List<ComplaintVO> findVOByAid(int aid);

    /**
     * 添加投诉
     * @param complaint 投诉对象
     * @return 是否成功
     */
    public boolean insert(Complaint complaint);

    /**
     * 更新投诉
     * @param complaint 投诉对象
     * @return 是否成功
     */
    public boolean update(Complaint complaint);

    /**
     * 批量删除
     * @param cpids 投诉编号的数组
     * @return 是否成功
     */
    public boolean delete(int[] cpids);
    public List<Complaint> findByCpstate(String cpstate);
}
