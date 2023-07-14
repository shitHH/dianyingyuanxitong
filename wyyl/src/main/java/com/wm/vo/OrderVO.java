package com.wm.vo;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author km
 * 订单视图
 */
@Data
@ToString
public class OrderVO {
    /**
     * 1. 订单编号:(oid) int
     */
    private int oid;
    /**
     * 2. 订票单号(orderNumber)  varchar(20)
     */
    private String ordernumber;
    /**
     * 3. 订单时间(orderTime)  datetime
     */
    private Timestamp ordertime;

    /**
     * 4. 订单状态(orderstate) varchar(10)
     */
    private String orderstate;
    /**
     * 5. 取票状态(ticketState)  varchar(10)
     */
    private String ticketstate;

    /**
     * 6. 支付状态(payState)  varchar(10)
     */
    private String paystate;
    /**
     * 7. 排档记录编号(msid) int  外键
     */
    private int msid;
    /**
     * 开始时间(beginTime) dateTime
     */
    private Timestamp begintime;
    /**
     * 结束时间(endTime)  datetime
     */
    private Timestamp endtime;
    /**
     *  单价金额(money) double
     */
    private double moneyone;
    /**
     *  账号编号(aid) int  外键
     */

    private int aid;
    /**
     * 用户昵称
     */
    private String aname;
    /**
     * 用户电话
     */
    private String tel;
    /**
     * 订单总金额
     */
    private double moneyall;
    /**
     * 影厅编号(hid) int 外键
     */
    private int hid;
    /**
     * 影厅名
     */
    private String hname;
    /**
     * 影院编号
     */
    private int cinemaid;
    /**
     * 影院申请编号
     */
    private int caid;
    /**
     * 影院名称
     */
    private String cname;

    /**
     * 影院地址
     */
    private String caddress;
    /**
     * 影院对公电话
     */
    private String ctel;
    /**
     * 影厅类型编号
     */
    private int htid;
    /**
     * 影厅类型
     */
    private String htname;

    /**
     * 影片编号(mid) int 外键
     */
    private int mid;
    /**
     * 影片名称
     */
    private String mname;
    /**
     * 影片时长
     */
    private int time;
    private int mtid;
    private String mtname;

    public OrderVO() {
    }

}
