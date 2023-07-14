package com.wm.po;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author bilie
 * @author km
 * 投诉表的实体类
 */
@ToString
@Data
public  class Complaint {

    /**
     * 投诉编号
     */
    private int cpid;

    /**
     * 影院编号
     */
    private int cinemaid;

    /**
     * 账号编号
     */
    private int aid;

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

    public Complaint() {
    }


}
