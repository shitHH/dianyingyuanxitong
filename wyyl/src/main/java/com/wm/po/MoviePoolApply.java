package com.wm.po;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author km
 * 影池创建申请实体类sql
 */
@Data
@ToString
public class MoviePoolApply {
    /**
     * 申请编号
     */
    private int mpaid;
    /**
     * 影池名称
     */
    private String mpname;
    /**
     * 申请人
     */
    private int aid;
    /**
     * 申请时间
     */
    private Timestamp applytime;
}
