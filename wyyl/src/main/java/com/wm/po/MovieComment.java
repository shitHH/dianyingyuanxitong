package com.wm.po;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author awei
 * 影评实体类
 */
@ToString
@Data
public class MovieComment {

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
     * 电影编号(外键)
     */
    private int mid;

    /**
     * 发言状态编号（外键）
     */
    private int ssid;

    /**
     * 热度值
     */
    private int hotnumber;

    /**
     * 账号编号
     */
    private int aid;

    public MovieComment() {
    }

    public MovieComment(int mcid, String moviecontent, Timestamp commenttime, int movierating, int mid, int ssid, int hotnumber, int aid) {
        this.mcid = mcid;
        this.moviecontent = moviecontent;
        this.commenttime = commenttime;
        this.movierating = movierating;
        this.mid = mid;
        this.ssid = ssid;
        this.hotnumber = hotnumber;
        this.aid = aid;
    }
}
