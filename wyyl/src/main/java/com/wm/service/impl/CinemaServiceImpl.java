package com.wm.service.impl;

import com.wm.dao.CinemaDao;
import com.wm.po.Cinema;
import com.wm.service.CinemaService;
import com.wm.vo.CinemaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈晨
 * 电影院业务逻辑实现类
 */
@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    CinemaDao cinemaDao;

    @Override
    public List<Cinema> findAll() {
        return cinemaDao.findAll();
    }

    @Override
    public Cinema findByCinemaid(int cinemaid) {
        return cinemaDao.findByCinemaid(cinemaid);
    }

    @Override
    public Cinema findByCaid(int caid) {
        return cinemaDao.findByCaid(caid);
    }

    @Override
    public int add(Cinema cinema) {
        cinema.setCinemaid(cinema.getCaid()+(int)(5000*Math.random()));
        cinema.setOpenstate("营业");
        cinemaDao.add(cinema);
        return cinema.getCinemaid();
    }

    @Override
    public boolean update(Cinema cinema) {
        return cinemaDao.update(cinema)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return cinemaDao.delete(array)>0?true:false;
    }

    @Override
    public List<CinemaVO> findVOAll() {
        return cinemaDao.findVOAll();
    }

    @Override
    public List<CinemaVO> findVOAllCom() {
        return cinemaDao.findVOAllCom();
    }
}
