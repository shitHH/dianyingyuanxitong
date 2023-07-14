package com.wm.dao;

import com.wm.po.Movies;
import com.wm.po.Order;
import com.wm.vo.OrderVO;

import java.util.List;
import java.util.Map;

/**
 * @author km
 * 订单数据访问接口
 */
public interface OrderDao {
    /**
     * 查询所有订单
     * @return 所有订单集合
     */
    public List<Order> findAll();

    /**
     * 根据账号编号查询订单
     * @param aid 账号编号
     * @return 订单集合
     */
    public List<Order> findByAid(int aid);

    /**
     * 根据档期编号查询订单
     * @param msid 影片档期编号
     * @return 订单集合
     */
    public List<Order>  findByMsid(int msid);

    /**
     * 根据订单编号查询订单对象
     * @param oid 订单编号
     * @return订单对象
     */
    public Order findByOid(int oid);

    /**
     * 查询所有订单视图
     * @return 所有订单视图集合
     */
    public List<OrderVO> findVOAll();

    /**
     * 根据账号编号查询订单视图
     * @param aid 账号编号
     * @return 订单视图集合
     */
    public List<OrderVO> findVOByAid(int aid);

    /**
     * 根据档期编号查询订单视图
     * @param msid 影片档期编号
     * @return 订单视图集合
     */
    public List<OrderVO>  findVOByMsid(int msid);

    /**
     * 根据订单编号查询订单视图对象
     * @param oid 订单编号
     * @return订单视图对象
     */
    public OrderVO findVOByOid(int oid);


    /**
     * 新增订单
     * @param order 订单对象
     * @return 受影响的行数
     */
    public int insert(Order order);

    /**
     * 更新订单
     * @param order 订单对象
     * @return 受影响的行数
     */
    public int update(Order order);

    /**
     * 批量删除订单
     * @param oids 订单编号数组
     * @return 受影响的行数
     */
    public int delete(int[] oids);


    public OrderVO findVOByOrderNumber(String orderNumber);

    public Order findByOrderNumber(String orderNumber);

    public List<OrderVO> findVOByMid(int mid);

    public List<OrderVO> findVOByCinemaid(int cinemaid);

    public List<OrderVO> findVOByMidAndCinemaid(int mid, int cinemaid);

    /**
     * 查询所有订单
     * @return 所有订单的集合
     */
    public List<OrderVO> findState();

    /**
     * 获得电影的名称和金额
     * @return map类型的对象
     */
    public Map<String,List> findBar();

}
