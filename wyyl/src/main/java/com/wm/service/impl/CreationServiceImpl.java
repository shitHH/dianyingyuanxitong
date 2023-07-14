package com.wm.service.impl;

import com.wm.dao.CreationDao;
import com.wm.po.Creation;
import com.wm.service.CreationService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author awei
 * 创作记录业务逻辑实现类
 */
@Service
public class CreationServiceImpl implements CreationService {

    Logger logger=Logger.getLogger(CreationServiceImpl.class);
    @Resource
    CreationDao creationDao;
    @Override
    public List<Creation> findAll() {
        return creationDao.findAll();
    }

    @Override
    public Creation findByCtid(int ctid) {
        return creationDao.findByCtid(ctid);
    }

    @Override
    public List<Creation> findByFid(int fid) {
        return creationDao.findByFid(fid);
    }

    @Override
    public List<Creation> findByMid(int mid) {
        return creationDao.findByMid(mid);
    }

    @Override
    public List<Creation> findByCreationTypeId(int creationTypeid) {
        return creationDao.findByCreationTypeId(creationTypeid);
    }

    @Override
    public boolean add(Creation creation) {
        return creationDao.add(creation)>0?true:false;
    }

    @Override
    public boolean update(Creation creation) {
        return creationDao.update(creation)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return creationDao.delete(array)>0?true:false;
    }
}
