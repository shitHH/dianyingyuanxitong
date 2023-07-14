package com.wm.service.impl;

import com.wm.dao.AccountDao;
import com.wm.po.Account;
import com.wm.service.AccountService;
import com.wm.vo.AccountVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author 陈晨
 * 账号业务逻辑实现类
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public List<AccountVo> findVoAll() {
        return accountDao.findVoAll();
    }

    @Override
    public List<Account> findByRid(int rid) {
        return accountDao.findByRid(rid);
    }

    @Override
    public List<AccountVo> findVoByRid(int rid) {
        return accountDao.findVoByRid(rid);
    }

    @Override
    public List<Account> findByAsid(int asid) {
        return accountDao.findByAsid(asid);
    }

    @Override
    public List<AccountVo> findVoByAsid(int asid) {
        return accountDao.findVoByAsid(asid);
    }

    @Override
    public List<Account> findByAname(String aname) {
        return accountDao.findByAname(aname);
    }

    @Override
    public List<AccountVo> findVoByAname(String aname) {
        return accountDao.findVoByAname(aname);
    }

    @Override
    public Account findByAid(int aid) {
        return accountDao.findByAid(aid);
    }

    @Override
    public Account findByTel(String tel) {
        return accountDao.findByTel(tel);
    }

    @Override
    public Account findByIp(String ip) {
        return accountDao.findByIp(ip);
    }

    @Override
    public Account findByIelAndPass(String tel, String pass) {
        return accountDao.findByIelAndPass(tel,pass);
    }

    @Override
    public AccountVo findVoByTelAndPass(String tel, String pass) {
        return accountDao.findVoByTelAndPass(tel,pass);
    }

    @Override
    public Account findByAidAndPass(int aid, String pass) {
        return accountDao.findByAidAndPass(aid, pass);
    }

    @Override
    public AccountVo findVoByAidAndPass(int aid, String pass) {
        return accountDao.findVoByAidAndPass(aid,pass);
    }

    @Override
    public boolean add(Account account) {
        try {
            account.setIp(Inet4Address.getLocalHost().getHostAddress());
            account.setAsid(1);
            account.setDescribe("新人");
            account.setRid(4);
            account.setCinemaid(1);
            account.setHeadshotaddress("http://localhost:8080/wyyl/starter/images/headers/defaultheader.png");
            account.setCreattime(new Timestamp(System.currentTimeMillis()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return accountDao.add(account)>0?true:false;
    }

    @Override
    public boolean update(Account account) {
        return accountDao.update(account)>0?true:false;
    }

    @Override
    public boolean delete(int[] array) {
        return accountDao.delete(array)>0?true:false;
    }

    @Override
    public int addCinemaAccount(Account account) {
        account.setCreattime(new Timestamp(System.currentTimeMillis()));
        account.setDescribe("暂无");
        account.setRid(3);
        account.setAsid(1);
        account.setHeadshotaddress("http://localhost:8080/wyyl/starter/images/headers/defaultheader.png");
        return accountDao.addCinemaAccount(account);
    }

    @Override
    public boolean addAdmin(Account account) {
        account.setHeadshotaddress("http://localhost:8080/wyyl/starter/images/headers/defaultheader.png");
        account.setDescribe("暂无");
        account.setRid(5);
        account.setAsid(1);
        account.setCreattime(new Timestamp(System.currentTimeMillis()));
        accountDao.addAdmin(account);
        return false;
    }

    @Override
    public Account findByCinemaid(int cinemaid) {
        return accountDao.findByCinemaid(cinemaid);
    }

    @Override
    public AccountVo findVOByAid(int aid) {
        return accountDao.findVOByAid(aid);
    }

    @Override
    public List<AccountVo> findVoByRid1() {
        return accountDao.findVoByRid1();
    }
}
