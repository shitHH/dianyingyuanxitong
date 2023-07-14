package com.wm.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author 陈晨
 * 账号视图类
 */
@Data
@ToString
public class AccountVo {
    /**
     * 用户编号
     */
    private int aid;

    /**
     * 用户电话
     */
    private String tel;

    /**
     * 用户姓名
     */
    private String aname;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户生日
     */
    private Timestamp birthday;

    /**
     * 用户头像地址
     */
    private String headshotaddress;

    /**
     * 用户描述
     */
    private String describe;

    /**
     * 用户密码
     */
    private String pass;

    /**
     * 用户角色编号(外键)
     */
    private int rid;
    /**
     * 用户角色名称
     */
    private String rname;

    /**
     * 用户状态编号
     */
    private int asid;
    /**
     * 账号状态名称
     */
    private String accountstate;

    /**
     * 用户注册时间
     */
    private Timestamp creattime;

    /**
     * 用户注册ip
     */
    private String ip;
    private int cinemaid;

    public AccountVo() {
    }

    public AccountVo(int aid, String tel, String aname, String sex, Timestamp birthday, String headshotaddress, String describe, String pass, int rid, String rname, int asid, String accountstate, Timestamp creattime, String ip, int cinemaid) {
        this.aid = aid;
        this.tel = tel;
        this.aname = aname;
        this.sex = sex;
        this.birthday = birthday;
        this.headshotaddress = headshotaddress;
        this.describe = describe;
        this.pass = pass;
        this.rid = rid;
        this.rname = rname;
        this.asid = asid;
        this.accountstate = accountstate;
        this.creattime = creattime;
        this.ip = ip;
        this.cinemaid = cinemaid;
    }
}
