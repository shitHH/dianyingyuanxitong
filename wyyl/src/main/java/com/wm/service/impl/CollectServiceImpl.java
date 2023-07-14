package com.wm.service.impl;

import com.wm.dao.CollectDao;
import com.wm.po.Collect;
import com.wm.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yy
 * @version 1.0
 * @project java0613-3-group-project-3
 * @date 2022/10/8 09:58:12
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectDao collectDao;

    @Override
    public List<Collect> findAll() {
        return collectDao.findAll();
    }

    @Override
    public List<Collect> findByCollectType(String collecttype) {
        return collectDao.findByCollectType(collecttype);
    }

    @Override
    public boolean add(Collect collect) {
        return collectDao.add(collect)>0?true:false;
    }

    @Override
    public boolean delete(int[] ids) {
        return collectDao.delete(ids)>0?true:false;
    }

    @Override
    public Collect findByMidAndAid(int mid, int aid) {
        return collectDao.findByMidAndAid(mid,aid);
    }

    @Override
    public List<Collect> findByMid(int mid) {
        return collectDao.findByMid(mid);
    }
}
