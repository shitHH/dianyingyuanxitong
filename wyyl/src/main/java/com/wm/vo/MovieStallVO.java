package com.wm.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author km
 * 档期视图
 */
@Data
@ToString
@Component
public class MovieStallVO {

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
     * 影厅名称
     */
    private String hname;

    /**
     * 影厅类型编号
     */
    private int htid;
    private String htname;
    /**
     * 布局编号
     */
    private int loid;
    /**
     * 排
     */
    private int row;

    /**
     * 列
     */
    private int col;
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
    private String caddress;
    /**
     * 7. 影片编号(mid) int 外键
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

    public MovieStallVO() {
    }
}
