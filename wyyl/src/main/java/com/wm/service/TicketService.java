package com.wm.service;

import com.wm.po.Ticket;

import java.util.List;

/**
 * @author km
 * 电影票业务逻辑接口
 */
public interface TicketService {
    /**
     * 查询所有的电影票
     * @return 电影票集合
     */
    public List<Ticket> findAll();

    /**
     * 根据电影票编号查询电影票对象
     * @param tid 点影票编号
     * @return 电影票对象
     */
    public Ticket findByTid(int tid);

    /**
     * 根据订单编号查询电影票
     * @param oid 订单编号
     * @return 电影票对象的集合
     */
    public List<Ticket> findByOid(int oid);

    /**
     * 新增影票对象
     * @param ticket 电影票对象
     * @return 是否成功
     */
    public boolean insert(Ticket ticket);

    /**
     * 删除影票
     * @param tids 影票编号
     * @return 是否成功
     */
    public boolean delete(List<Integer> tids);
}
