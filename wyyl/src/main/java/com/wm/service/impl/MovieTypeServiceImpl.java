package com.wm.service.impl;

import com.wm.dao.MovieTypeDao;
import com.wm.po.MovieType;
import com.wm.service.MovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author km
 * 影片类型业务逻辑实现类
 */
@Service
public class MovieTypeServiceImpl implements MovieTypeService {

    @Autowired
    MovieTypeDao movieTypeDao;

    @Override
    public List<MovieType> findAll() {
        return movieTypeDao.findAll();
    }

    @Override
    public MovieType findById(int mtid) {
        return movieTypeDao.findById(mtid);
    }

    @Override
    public boolean add(MovieType movieType) {
        return movieTypeDao.add(movieType)>0?true:false;
    }

    @Override
    public boolean update(MovieType movieType) {
        return movieTypeDao.update(movieType)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return movieTypeDao.delete(array)>0?true:false;
    }
}
