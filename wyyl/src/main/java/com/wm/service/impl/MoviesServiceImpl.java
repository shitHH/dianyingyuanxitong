package com.wm.service.impl;

import com.wm.dao.MoviesDao;
import com.wm.po.Movies;
import com.wm.service.MoviesService;
import com.wm.vo.MoviesVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Resource
    MoviesDao moviesDao;

    @Override
    public List<Movies> findAll() {
        return moviesDao.findAll();
    }

    @Override
    public Movies findByMid(int mid) {
        return moviesDao.findByMid(mid);
    }

    @Override
    public MoviesVO findVOByMid(int mid) {
        return moviesDao.findVOByMid(mid);
    }

    @Override
    public List<MoviesVO> findVOAll() {
        return moviesDao.findVOAll();
    }

    @Override
    public List<MoviesVO> findVOByMtid(int mtid) {
        return moviesDao.findVOByMtid(mtid);
    }

    @Override
    public List<MoviesVO> findVOByManme(String mname) {
        return moviesDao.findVOByManme(mname);
    }

    @Override
    public List<Movies> findByManme(String mname) {
        return moviesDao.findByManme(mname);
    }

    @Override
    public List<Movies> findByMovieState(String movieState) {
        return moviesDao.findByMovieState(movieState);
    }

    @Override
    public List<MoviesVO> findVOByMovieState(String movieState) {
        return moviesDao.findVOByMovieState(movieState);
    }

    @Override
    public boolean insert(Movies movies) {
        movies.setScore(0);
        movies.setMoviestate("即将上映");
        return moviesDao.insert(movies)>0?true:false;
    }

    @Override
    public boolean update(Movies movies) {
        return moviesDao.update(movies)>0?true:false;
    }

    @Override
    public boolean delete(int[] mids) {
        return moviesDao.delete(mids)>0?true:false;
    }

    @Override
    public List<MoviesVO> findByMoviereating() {
        return moviesDao.findByMoviereating();
    }
}
