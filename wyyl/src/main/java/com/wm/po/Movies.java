package com.wm.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author bilie
 * @author km
 * 影片实体类
 */
@Data
@ToString
@AllArgsConstructor
@Component
public class  Movies {

    /**
     * 影片编号
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

    /**
     * 影片介绍
     */
    private String introduce;

    /**
     * 影片状态
     */
    private String moviestate;

    /**
     * 影片评分
     */
    private double score;

    /**
     * 影片类型编号
     */
    private int mtid;

    /**
     * 影片海报地址
     */
    private String coveraddress;

    /**
     * 影片预告片地址
     */
    private String previewaddress;

    /**
     * 导演
     */
    private String director;

    /**
     * 电影上映时间
     */
    private Timestamp releaseTime;

    public Movies() {
    }
}
