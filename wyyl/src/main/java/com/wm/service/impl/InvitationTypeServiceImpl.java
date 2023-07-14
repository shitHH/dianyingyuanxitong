package com.wm.service.impl;

import com.wm.dao.InvitationTypeDao;
import com.wm.po.InvitationType;
import com.wm.service.InvitationTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bilie
 * 帖子类型业务逻辑实现类
 */
@Service
public class InvitationTypeServiceImpl implements InvitationTypeService {

    @Resource
    InvitationTypeDao invitationTypeDao;

    @Override
    public List<InvitationType> findAll() {
        return invitationTypeDao.findAll();
    }

    @Override
    public InvitationType findByItid(int itid) {
        return invitationTypeDao.findByItid(itid);
    }

    @Override
    public boolean add(InvitationType invitationType) {
        return invitationTypeDao.add(invitationType)>0?true:false;
    }

    @Override
    public boolean update(InvitationType invitationType) {
        return invitationTypeDao.update(invitationType)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return invitationTypeDao.delete(array)>0?true:false;
    }
}
