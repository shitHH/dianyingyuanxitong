package com.wm.service.impl;

import com.wm.dao.MoviePoolApplyDao;
import com.wm.po.MoviePoolApply;
import com.wm.service.MoviePoolApplyService;
import com.wm.vo.MoviePoolApplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author km
 * 影池申请yewuluojishixianlei
 */
@Service
public class MoviePoolApplyServiceImpl  implements MoviePoolApplyService {
    @Autowired
    MoviePoolApplyDao moviePoolApplyDao;
    @Override
    public List<MoviePoolApply> findAll() {
        return moviePoolApplyDao.findAll();
    }

    @Override
    public List<MoviePoolApplyVO> findVOAll() {
        return moviePoolApplyDao.findVOAll();
    }

    @Override
    public List<MoviePoolApplyVO> findVOByMpname(String mpname) {
        return moviePoolApplyDao.findVOByMpname(mpname);
    }

    @Override
    public List<MoviePoolApplyVO> findVOByAid(int aid) {
        return moviePoolApplyDao.findVOByAid(aid);
    }

    @Override
    public MoviePoolApply findByMpaid(int mpaid) {
        return moviePoolApplyDao.findByMpaid(mpaid);
    }

    @Override
    public MoviePoolApplyVO findVOByMpaid(int mpaid) {
        return moviePoolApplyDao.findVOByMpaid(mpaid);
    }

    @Override
    public boolean insert(MoviePoolApply moviePoolApply) {
        return moviePoolApplyDao.insert(moviePoolApply)>0?true:false;
    }

    @Override
    public boolean delete(int mpaid) {
        return moviePoolApplyDao.delete(mpaid)>0?true:false;
    }
}
