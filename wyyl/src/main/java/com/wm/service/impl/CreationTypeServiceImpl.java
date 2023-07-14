package com.wm.service.impl;

import com.wm.dao.CreationTypeDao;
import com.wm.po.CreationType;
import com.wm.service.CreationTypeService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author awei
 * 创作类型业务逻辑实现类
 */
@Service
public class CreationTypeServiceImpl implements CreationTypeService{

    Logger logger=Logger.getLogger(CreationTypeServiceImpl.class);
    @Resource
    CreationTypeDao creationTypeDao;
    @Override
    public List<CreationType> findAll() {
        return creationTypeDao.findAll();
    }

    @Override
    public CreationType findByCreationTypeId(int creationTypeid) {
        return creationTypeDao.findByCreationTypeId(creationTypeid);
    }

    @Override
    public boolean add(CreationType creationType) {
        return creationTypeDao.add(creationType)>0?true:false;
    }

    @Override
    public boolean update(CreationType creationType) {
        return creationTypeDao.update(creationType)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return creationTypeDao.delete(array)>0?true:false;
    }
}
