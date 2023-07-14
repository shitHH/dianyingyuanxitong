package com.wm.po;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author bilie
 * 影厅的实体类
 */
@ToString
@Data
@Component
public class  Hall {

    /**
     * 影厅编号
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

    /**
     * 布局编号
     */
    private int loid;

    /**
     * 影厅状态
     */
    private String hallState;

    /**
     * 影院编号
     */
    private int cinemaid;

    public Hall() {
    }

    public Hall(int hid, String hname, int htid, int loid, String hallState, int cinemaid) {
        this.hid = hid;
        this.hname = hname;
        this.htid = htid;
        this.loid = loid;
        this.hallState = hallState;
        this.cinemaid = cinemaid;
    }

}
