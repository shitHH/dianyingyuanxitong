package com.wm.po;

import lombok.Data;
import lombok.ToString;

/**
 * @author bilie
 * @author 陈晨
 * 影院实体类
 */
@ToString
@Data
public class Cinema {

    /**
     * 编号
     */
    private int id;
    /**
     * 影院编号
     */
    private int cinemaid;

    /**
     * 影院申请编号
     */
    private int caid;


    /**
     * 影院状态
     */
    private String openstate;

    public Cinema() {
    }

    public Cinema(int cinemaid, int caid,String openstate) {
        this.cinemaid = cinemaid;
        this.caid = caid;
        this.openstate = openstate;
    }

}
