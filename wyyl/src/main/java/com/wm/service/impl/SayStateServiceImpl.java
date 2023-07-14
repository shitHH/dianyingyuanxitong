package com.wm.service.impl;

import com.wm.dao.SayStateDao;
import com.wm.po.SayState;
import com.wm.service.SayStateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SayStateServiceImpl implements SayStateService {

    @Resource
    SayStateDao sayStateDao;

    @Override
    public SayState findBySsid(int ssid) {
        return sayStateDao.findBySsid(ssid);
    }

    @Override
    public List<SayState> findAll() {
        return sayStateDao.findAll();
    }

    @Override
    public boolean add(SayState sayState) {
        return sayStateDao.add(sayState)>0?true:false;
    }

    @Override
    public boolean update(SayState sayState) {
        return sayStateDao.update(sayState)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return sayStateDao.delete(array)>0?true:false;
    }
}
