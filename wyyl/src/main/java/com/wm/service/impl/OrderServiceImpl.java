package com.wm.service.impl;

import com.wm.dao.OrderDao;
import com.wm.dao.TicketDao;
import com.wm.po.Order;
import com.wm.po.Ticket;
import com.wm.service.OrderService;
import com.wm.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

/**
 * @author km
 * 订单业务逻辑实现类
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderDao orderDao;
    @Resource
    TicketDao ticketDao;
    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public List<Order> findByAid(int aid) {
        return orderDao.findByAid(aid);
    }

    @Override
    public List<Order> findByMsid(int msid) {
        return orderDao.findByMsid(msid);
    }

    @Override
    public Order findByOid(int oid) {
        return orderDao.findByOid(oid);
    }

    @Override
    public List<OrderVO> findVOAll() {
        return orderDao.findVOAll();
    }

    @Override
    public List<OrderVO> findVOByAid(int aid) {
        return orderDao.findVOByAid(aid);
    }

    @Override
    public List<OrderVO> findVOByMsid(int msid) {
        return orderDao.findVOByMsid(msid);
    }

    @Override
    public OrderVO findVOByOid(int oid) {
        return orderDao.findVOByOid(oid);
    }

    @Override
    public boolean insert(Order order) {
        order.setOrderState("待支付");
        order.setTicketState("未取票");
        order.setOrderTime(new Timestamp(System.currentTimeMillis()));
        return orderDao.insert(order)>0?true:false;
    }

    @Override
    public boolean update(Order order) {
        return orderDao.update(order)>0?true:false;
    }

    @Override
    public boolean delete(int[] oids) {
        List<Integer> list=new ArrayList<>();
        for (int oid:oids){
            for (Ticket ticket: ticketDao.findByOid(oid)){
                list.add(ticket.getTid());
            }
        }
        ticketDao.delete(list);
        return orderDao.delete(oids)>0?true:false;
    }

    @Override
    public OrderVO findVOByOrderNumber(String orderNumber) {
        return orderDao.findVOByOrderNumber(orderNumber);
    }

    @Override
    public Order findByOrderNumber(String orderNumber) {
        return orderDao.findByOrderNumber(orderNumber);
    }

    @Override
    public List<OrderVO> findVOByMid(int mid) {
        return orderDao.findVOByMid(mid);
    }

    @Override
    public List<OrderVO> findVOByCinemaid(int cinemaid) {
        return orderDao.findVOByCinemaid(cinemaid);
    }

    @Override
    public List<OrderVO> findVOByMidAndCinemaid(int mid, int cinemaid) {
        return orderDao.findVOByMidAndCinemaid(mid,cinemaid);
    }

    @Override
    public List<OrderVO> findState() {
        return orderDao.findState();
    }

    @Override
    public Map<String, List> findBar() {
        Map<String, List> map = new HashMap<>();
        List<OrderVO> orderVOS = orderDao.findState();
        List<String> name = new ArrayList<>();
        List<Double> value = new ArrayList<>();
        for (OrderVO orderVO: orderVOS){
            name.add(orderVO.getMname());
            value.add(orderVO.getMoneyall());
        }
        map.put("name",name);
        map.put("value",value);
        return map;
    }
}
