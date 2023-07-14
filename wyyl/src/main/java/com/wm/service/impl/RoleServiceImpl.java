package com.wm.service.impl;

import com.wm.dao.RoleDao;
import com.wm.po.Role;
import com.wm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈晨
 * 角色业务逻辑实现类
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Role findByRid(int rid) {
        return roleDao.findByRid(rid);
    }

    @Override
    public Role findByRname(String rname) {
        return roleDao.findByRname(rname);
    }

    @Override
    public boolean add(Role role) {
        return roleDao.add(role)>0?true:false;
    }

    @Override
    public boolean update(Role role) {
        return roleDao.update(role)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return roleDao.delete(array)>0?true:false;
    }
}
