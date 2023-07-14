package com.wm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author bilie
 * 影厅视图的实体类
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class HallVO {

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
    private String htname;

    private int loid;

    private int cinemaid;

    /**
     * 排
     */
    private int row;

    /**
     * 列
     */
    private int col;

    /**
     * 影厅状态
     */
    private String hallState;

}
