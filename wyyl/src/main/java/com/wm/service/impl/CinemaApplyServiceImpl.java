package com.wm.service.impl;

import com.wm.dao.AccountDao;
import com.wm.dao.CinemaApplyDao;
import com.wm.po.Account;
import com.wm.po.CinemaApply;
import com.wm.service.CinemaApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 陈晨
 * 电影院申请业务逻辑实现类
 */
@Service
public class CinemaApplyServiceImpl implements CinemaApplyService {

    @Autowired
    CinemaApplyDao cinemaApplyDao;

    @Autowired
    AccountDao accountDao;


    @Override
    public List<CinemaApply> findAll() {
        return cinemaApplyDao.findAll();
    }

    @Override
    public CinemaApply findByCaid(int caid) {
        return cinemaApplyDao.findByCaid(caid);
    }

    @Override
    public boolean add(CinemaApply cinemaApply) {
        cinemaApply.setCastate("待审核");
        return cinemaApplyDao.add(cinemaApply)>0?true:false;
    }

    @Override
    public boolean update(CinemaApply cinemaApply) {
        return cinemaApplyDao.update(cinemaApply)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return cinemaApplyDao.delete(array)>0?true:false;
    }

    @Override
    public List<CinemaApply> findByCastate(String castate) {
        return cinemaApplyDao.findByCastate(castate);
    }
}
