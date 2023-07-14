package com.wm.po;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author bilie
 * @author 陈晨
 * 账号的实体类
 */
@ToString
@Data
@Component
public class Account {

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
    private Date birthday;

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
     * 用户状态编号
     */
    private int asid;

    /**
     * 用户注册时间
     */
    private Timestamp creattime;

    /**
     * 用户注册ip
     */
    private String ip;
    /**
     * 影院编号
     */
    private int cinemaid;

    public Account() {
    }

    public Account(int aid, String tel, String aname, String sex, Timestamp birthday, String headshotaddress, String describe, String pass, int rid, int asid, Timestamp creattime, String ip, int cinemaid) {
        this.aid = aid;
        this.tel = tel;
        this.aname = aname;
        this.sex = sex;
        this.birthday = birthday;
        this.headshotaddress = headshotaddress;
        this.describe = describe;
        this.pass = pass;
        this.rid = rid;
        this.asid = asid;
        this.creattime = creattime;
        this.ip = ip;
        this.cinemaid = cinemaid;
    }
}
