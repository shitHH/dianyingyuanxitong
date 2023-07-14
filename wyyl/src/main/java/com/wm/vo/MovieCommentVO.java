package com.wm.vo;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author awei
 * 影评视图类
 */
@ToString
@Data
public class MovieCommentVO {

    /**
     * 影评编号
     */
    private int mcid;
    /**
     * 影评内容
     */
    private String moviecontent;
    /**
     * 影评时间
     */
    private Timestamp commenttime;

    /**
     * 影片评分
     */
    private int movierating;

    /**
     * 影片编号(外键)
     */
    private int mid;
    /**
     * 影片名称
     */
    private String mname;
    /**
     * 发言状态编号（外键）
     */
    private int ssid;
    /**
     * 发言状态
     */
    private String saystate;
    /**
     * 热度值
     */
    private int hotnumber;
    /**
     * 账号编号
     */
    private int aid;
    /**
     * 账号名称
     */
    private String aname;
    /**
     * 用户头像地址
     */
    private String headshotaddress;
    public MovieCommentVO() {
    }

    public MovieCommentVO(int mcid, String moviecontent, Timestamp commenttime, int movierating, int mid, String mname, int ssid, String saystate, int hotnumber, int aid, String aname) {
        this.mcid = mcid;
        this.moviecontent = moviecontent;
        this.commenttime = commenttime;
        this.movierating = movierating;
        this.mid = mid;
        this.mname = mname;
        this.ssid = ssid;
        this.saystate = saystate;
        this.hotnumber = hotnumber;
        this.aid = aid;
        this.aname = aname;
    }
}
