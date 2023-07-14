package com.wm.po;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author km
 * 档期实体类
 */
@Data
@ToString
public class MovieStall {

    /**
     * 1. 排档编号(msid) int
     */
    private  int msid;

    /**
     * 2. 开始时间(beginTime) dateTime
     */
    private Timestamp beginTime;
    /**
     * 3. 结束时间(endTime)  datetime
     */
    private Timestamp endTime;

    /**
     *  4. 单价金额(money) double
     */
    private double money;


    /**
     * 5. 状态(state) varchar(10)
     */
    private String state;
    /**
     *  6. 影厅编号(hid) int 外键
     */
    private int hid;

    /**
     * 7. 影片编号(mid) int 外键
     */
    private int mid;

    public MovieStall() {
    }

    public MovieStall(int msid, Timestamp beginTime, Timestamp endTime, double money, String state, int hid, int mid) {
        this.msid = msid;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.money = money;
        this.state = state;
        this.hid = hid;
        this.mid = mid;
    }

    public MovieStall(Timestamp beginTime, Timestamp endTime, double money, String state, int hid, int mid) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.money = money;
        this.state = state;
        this.hid = hid;
        this.mid = mid;
    }
}
