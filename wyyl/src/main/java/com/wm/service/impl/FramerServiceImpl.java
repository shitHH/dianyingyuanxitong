package com.wm.service.impl;

import com.wm.dao.FramerDao;
import com.wm.po.Framer;
import com.wm.service.FramerService;
import com.wm.vo.FramerVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author awei
 * 创作者业务逻辑实现类
 */
@Service
public class FramerServiceImpl implements FramerService{
    @Resource
    FramerDao framerDao;

    @Override
    public List<Framer> findAll() {
        return framerDao.findAll();
    }

    @Override
    public FramerVO findVOByFid(int fid) {
        return framerDao.findVOByFid(fid);
    }

    @Override
    public Framer findByFid(int fid) {
        return framerDao.findByFid(fid);
    }

    @Override
    public boolean add(Framer framer) {
        return framerDao.add(framer)>0?true:false;
    }

    @Override
    public boolean update(Framer framer) {
        return framerDao.update(framer)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return framerDao.delete(array)>0?true:false;
    }

}
