package com.wm.po;

import lombok.Data;
import lombok.ToString;

/**
 * @author km
 * 电影票实体类
 */
@Data
@ToString
public class Ticket {
    /**
     * 影票编号
     */
    private int tid;
    /**
     * 订单编号
     */
    private int oid;
    /**
     * 第几排
     */
    private int row;
    /**
     * 第几列
     */
    private int col;

    public Ticket() {
    }

    public Ticket(int oid, int row, int col) {
        this.oid = oid;
        this.row = row;
        this.col = col;
    }

    public  Ticket(int tid, int oid, int row, int col) {
        this.tid = tid;
        this.oid = oid;
        this.row = row;
        this.col = col;
    }
}
