package com.wm.service.impl;

import com.wm.dao.AccountStateDao;
import com.wm.po.AccountState;
import com.wm.service.AccountStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈晨
 * 账号状态业务逻辑实现类
 */
@Service
public class AccountStateServiceImpl implements AccountStateService {

    @Autowired
    AccountStateDao accountStateDao;

    @Override
    public List<AccountState> findAll() {
        return accountStateDao.findAll();
    }

    @Override
    public AccountState findByAsid(int asid) {
        return accountStateDao.findByAsid(asid);
    }

    @Override
    public boolean add(AccountState accountstate) {
        return accountStateDao.add(accountstate)>0?true:false;
    }

    @Override
    public boolean update(AccountState accountstate) {
        return accountStateDao.update(accountstate)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return accountStateDao.delete(array)>0?true:false;
    }
}
