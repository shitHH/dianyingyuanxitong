package com.wm.service.impl;

import com.wm.dao.HallTypeDao;
import com.wm.po.HallType;
import com.wm.service.HallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bilie
 * 影厅类型业务逻辑实现类
 */
@Service
public class HallTypeServiceImpl implements HallTypeService {

    @Resource
    HallTypeDao hallTypeDao;

    @Override
    public List<HallType> findAll() {
        return hallTypeDao.findAll();
    }

    @Override
    public HallType findById(int htid) {
        return hallTypeDao.findById(htid);
    }

    @Override
    public boolean add(HallType hallType) {
        return hallTypeDao.add(hallType)>0?true:false;
    }

    @Override
    public boolean update(HallType hallType) {
        return hallTypeDao.update(hallType)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return hallTypeDao.delete(array)>0?true:false;
    }
}
