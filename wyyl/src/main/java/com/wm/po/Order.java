package com.wm.po;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author km
 * 订单实体类
 */
@Data
@ToString
public class Order {
    /**
     * 1. 订单编号:(oid) int
     */
    private int oid;
    /**
     * 2. 订票单号(orderNumber)  varchar(20)
     */
    private String orderNumber;
    /**
     * 3. 订单时间(orderTime)  datetime
     */
    private Timestamp orderTime;

    /**
     * 4. 订单状态(orderstate) varchar(10)
     */
    private String orderState;
    /**
     * 5. 取票状态(ticketState)  varchar(10)
     */
    private String ticketState;

    /**
     * 7. 排档记录编号(msid) int  外键
     */
    private int msid;
    /**
     * 8. 账号编号(aid) int  外键
     */

    private int aid;
    /**
     * 订单金额
     */
    private double money;

    public Order() {
    }



}
