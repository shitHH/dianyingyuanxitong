package com.wm.service.impl;

import com.wm.dao.MovieStallDao;
import com.wm.dao.MoviesDao;
import com.wm.po.MovieStall;
import com.wm.service.MovieStallService;
import com.wm.vo.MovieStallVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author km
 * 影院档期业务逻辑实现类
 */
@Service
public class MovieStallServiceImpl implements MovieStallService {
    @Resource
    MovieStallDao movieStallDao;
    @Resource
    MoviesDao moviesDao;
    @Override
    public List<MovieStall> findAll() {
        return movieStallDao.findAll();
    }

    @Override
    public MovieStall findByMsid(int msid) {
        return movieStallDao.findByMsid(msid);
    }

    @Override
    public List<MovieStall> findByMid(int mid) {
        return movieStallDao.findByMid(mid);
    }

    @Override
    public List<MovieStall> findByMidAndHid(int hid, int mid) {
        return movieStallDao.findByMidAndHid(hid,mid);
    }

    @Override
    public List<MovieStallVO> findVOAll() {
        return movieStallDao.findVOAll();
    }

    @Override
    public MovieStallVO findVOByMsid(int msid) {
        return movieStallDao.findVOByMsid(msid);
    }

    @Override
    public List<MovieStallVO> findVOByMid(int mid) {
        return movieStallDao.findVOByMid(mid);
    }

    @Override
    public List<MovieStallVO> findVOByMidAndHid(int hid, int mid) {
        return movieStallDao.findVOByMidAndHid(hid, mid);
    }

    @Override
    public List<MovieStallVO> findVOByMidAndCinemaid(int cinemaid, int mid) {
        return movieStallDao.findVOByMidAndCinemaid(cinemaid, mid);
    }

    @Override
    public boolean insert(MovieStall movieStall) {
        movieStall.setEndTime(new Timestamp(((movieStall.getBeginTime().getTime())+moviesDao.findByMid(movieStall.getMid()).getTime()*60*1000)));
        movieStall.setState("即将开始");
        return movieStallDao.insert(movieStall)>0?true:false;
    }

    @Override
    public boolean update(MovieStall movieStall) {
        return movieStallDao.update(movieStall)>0?true:false;
    }

    @Override
    public boolean delete(int[] msids) {

        return movieStallDao.delete(msids)>0?true:false;
    }

    @Override
    public List<MovieStallVO> findVOByCinemaid(int cinemaid) {
        return movieStallDao.findVOByCinemaid(cinemaid);
    }

    @Override
    public List<MovieStallVO> findByHid(int hid) {
        return movieStallDao.findVOByHid(hid);
    }

    @Override
    public List<MovieStallVO> findVOByCity(String city) {
        return movieStallDao.findVOByCity(city);
    }

    @Override
    public List<MovieStallVO> findVOByMidOnly(int mid) {
        return movieStallDao.findVOByMidOnly(mid);
    }

}
