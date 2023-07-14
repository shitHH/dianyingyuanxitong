package com.wm.service.impl;

import com.wm.dao.ComplaintDao;
import com.wm.po.Complaint;
import com.wm.service.ComplaintService;
import com.wm.vo.ComplaintVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author km
 * 投诉业务逻辑实现类
 */
@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Resource
    ComplaintDao complaintDao;
    @Override
    public List<Complaint> findAll() {
        return complaintDao.findAll();
    }

    @Override
    public Complaint findByCpid(int cpid) {
        return complaintDao.findByCpid(cpid);
    }

    @Override
    public List<Complaint> findByCinemaid(int cinemaid) {
        return complaintDao.findByCinemaid(cinemaid);
    }

    @Override
    public List<Complaint> findByAid(int aid) {
        return complaintDao.findByAid(aid);
    }

    @Override
    public List<ComplaintVO> findVOAll() {
        return complaintDao.findVOAll();
    }

    @Override
    public ComplaintVO findVOByCpid(int cpid) {
        return complaintDao.findVOByCpid(cpid);
    }

    @Override
    public List<ComplaintVO> findVOByCinemaid(int cinemaid) {
        return complaintDao.findVOByCinemaid(cinemaid);
    }

    @Override
    public List<ComplaintVO> findVOByAid(int aid) {
        return complaintDao.findVOByAid(aid);
    }

    @Override
    public boolean insert(Complaint complaint) {
        complaint.setCreatetime(new Timestamp(System.currentTimeMillis()));
        complaint.setCpState("未反馈");
        return complaintDao.insert(complaint)>0?true:false;
    }

    @Override
    public boolean update(Complaint complaint) {
        return complaintDao.update(complaint)>0?true:false;
    }

    @Override
    public boolean delete(int[] cpids) {
        return complaintDao.delete(cpids)>0?true:false;
    }

    @Override
    public List<Complaint> findByCpstate(String cpstate) {
        return complaintDao.findByCpstate(cpstate);
    }
}
