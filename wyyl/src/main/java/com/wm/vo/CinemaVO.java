package com.wm.vo;

import com.wm.po.CinemaApply;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author km
 * 电影院视图
 */
@Component
@Data
@ToString
public class CinemaVO {
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


    /**
     * 影院名称
     */
    private String cname;

    /**
     * 影院地址
     */
    private String caddress;

    public CinemaVO() {
    }

    public CinemaVO(int id, int cinemaid, int caid, String openstate, String cname, String caddress) {
        this.id = id;
        this.cinemaid = cinemaid;
        this.caid = caid;
        this.openstate = openstate;
        this.cname = cname;
        this.caddress = caddress;
    }
}
