package com.wm.vo;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author km
 * 投诉表的视图
 */
@ToString
@Data
public  class ComplaintVO {

    /**
     * 投诉编号
     */
    private int cpid;

    /**
     * 影院编号
     */
    private int cinemaid;
    /**
     * 申请编号
     */
    private int caid;

    /**
     * 影院名称
     */
    private String cname;

    /**
     * 影院地址
     */
    private String cAddress;
    /**
     * 影院对公邮箱
     */
    private String cEmail;

    /**
     * 影院对公电话
     */
    private String cTel;

    /**
     * 账号编号
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
     * 投诉内容
     */
    private String reason;
    /**
     * 投诉时间
     */
    private Timestamp createtime;
    /**
     * 投诉状态
     */
    private String cpState;

    public ComplaintVO() {
    }


}
