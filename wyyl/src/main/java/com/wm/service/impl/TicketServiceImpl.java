package com.wm.service.impl;

import com.wm.dao.TicketDao;
import com.wm.po.Ticket;
import com.wm.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author km
 *电影票的业务逻辑及实现类
 */
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketDao ticketDao;
    @Override
    public List<Ticket> findAll() {
        return ticketDao.findAll();
    }

    @Override
    public Ticket findByTid(int tid) {
        return ticketDao.findByTid(tid);
    }

    @Override
    public List<Ticket> findByOid(int oid) {
        return ticketDao.findByOid(oid);
    }

    @Override
    public boolean insert(Ticket ticket) {
        return ticketDao.insert(ticket)>0?true:false;
    }

    @Override
    public boolean delete(List<Integer> tids) {
        return ticketDao.delete(tids)>0?true:false;
    }
}
