package com.wm.po;

import lombok.Data;
import lombok.ToString;

/**
 * @author bilie
 * @author km
 * 影片类型实体类
 */
@Data
@ToString
public class MovieType {

    /**
     * 影片类型编号
     */
    private int mtid;

    /**
     * 影片类型名称
     */
    private String mtname;

    public MovieType() {
    }
}
