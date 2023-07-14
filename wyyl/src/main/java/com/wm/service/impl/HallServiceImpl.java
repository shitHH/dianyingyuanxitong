package com.wm.service.impl;

import com.wm.dao.HallDao;
import com.wm.po.Hall;
import com.wm.service.HallService;
import com.wm.vo.HallVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bilie
 * 影厅业务逻辑实现类
 */
@Service
public class HallServiceImpl implements HallService {

    @Resource
    HallDao hallDao;

    @Override
    public List<Hall> findAll() {
        return hallDao.findAll();
    }

    @Override
    public List<Hall> findByCinemaid(int cinemaid) {
        return hallDao.findByCinemaid(cinemaid);
    }

    @Override
    public Hall findById(int hid) {
        return hallDao.findById(hid);
    }

    @Override
    public boolean add(Hall hall) {
        return hallDao.add(hall)>0?true:false;
    }

    @Override
    public boolean update(Hall hall) {
        return hallDao.update(hall)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return hallDao.delete(array)>0?true:false;
    }

    @Override
    public List<HallVO> findVOByCinemaid(int cinemaid) {
        return hallDao.findVOByCinemaid(cinemaid);
    }

    @Override
    public HallVO findVOByHid(int hid) {
        return hallDao.findVOByHid(hid);
    }
}
