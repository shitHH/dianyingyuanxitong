package com.wm.service;

import com.wm.po.MoviePoolApply;
import com.wm.vo.MoviePoolApplyVO;

import java.util.List;

/**
 * @author km
 * 创建影池业务逻辑接口
 */
public interface MoviePoolApplyService {
    /**
     * 查看所有
     * @return 影池申请集合
     */
    public List<MoviePoolApply> findAll();

    /**
     * 查看所有
     * @return 影池申请视图集合
     */
    public List<MoviePoolApplyVO> findVOAll();

    /**
     * 根据影池名称查询影池申请视图集合
     * @param mpname 影池名称
     * @return 影池申请视图集合
     */
    public List<MoviePoolApplyVO> findVOByMpname(String mpname);

    /**根据账号编号查询影池申请视图集合
     * @param aid 账号编号
     * @return 影池申请视图集合
     */
    public List<MoviePoolApplyVO> findVOByAid(int aid);
    /**
     * 根据影池申请编号查询影池申请
     * @param mpaid 影池申请编号
     * @return 影池申请
     */
    public MoviePoolApply findByMpaid(int mpaid);

    /**
     * 根据影池申请编号查询影池申请视图
     * @param mpaid 影池申请编号
     * @return 影池申请视图
     */
    public MoviePoolApplyVO findVOByMpaid( int mpaid);

    /**
     * 增加
     * @param moviePoolApply 影池申请
     * @return 是否成功
     */
    public boolean insert(MoviePoolApply moviePoolApply);

    /**
     * 删除
     * @param mpaid 影池申请编号
     * @return 是否成功
     */
    public boolean delete(int mpaid);

}
