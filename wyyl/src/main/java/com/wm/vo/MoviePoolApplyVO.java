package com.wm.vo;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author km
 * 影池创建申请实体类sql
 */
@Data
@ToString
public class MoviePoolApplyVO {
    /**
     * 申请编号
     */
    private int mpaid;
    /**
     * 影池名称
     */
    private String mpname;

    /**
     * 申请者编号
     */
    private int aid;
    /**
     * 申请人
     */
    private String aname;
    /**
     * 申请时间
     */
    private Timestamp applytime;

}
