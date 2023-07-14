package com.wm.service.impl;

import com.wm.dao.MovieCommentDao;
import com.wm.po.MovieComment;
import com.wm.service.MovieCommentService;
import com.wm.vo.MovieCommentVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
public class MovieCommentServiceImpl implements MovieCommentService {

    @Resource
    MovieCommentDao movieCommentDao;

    @Override
    public List<MovieComment> findAll() {
        return movieCommentDao.findAll();
    }

    @Override
    public List<MovieCommentVO> findAllVO() {
        return movieCommentDao.findAllVO();
    }

    @Override
    public MovieComment findByMcid(int mcid) {
        return movieCommentDao.findByMcid(mcid);
    }

    @Override
    public MovieCommentVO findByMcidVO(int mcid) {
        return movieCommentDao.findByMcidVO(mcid);
    }

    @Override
    public List<MovieComment> findByMid(int mid) {
        return movieCommentDao.findByMid(mid);
    }

    @Override
    public List<MovieCommentVO> findByMidVO(int mid) {
        return movieCommentDao.findByMidVO(mid);
    }

    @Override
    public List<MovieComment> findByAid(int aid) {
        return movieCommentDao.findByAid(aid);
    }

    @Override
    public List<MovieCommentVO> findByAidVO(int aid) {
        return movieCommentDao.findByAidVO(aid);
    }

    @Override
    public boolean add(MovieComment movieComment) {
        movieComment.setCommenttime(new Timestamp(System.currentTimeMillis()));
        movieComment.setSsid(1);
        return movieCommentDao.add(movieComment)>0?true:false;
    }

    @Override
    public boolean update(MovieComment movieComment) {
        return movieCommentDao.update(movieComment)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return movieCommentDao.delete(array)>0?true:false;
    }

    @Override
    public double score(int mid) {
        return movieCommentDao.score(mid);
    }
}
