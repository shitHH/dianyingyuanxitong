package com.wm.po;

import lombok.Data;
import lombok.ToString;

/**
 * @author awei
 * 发言状态实体类
 */
@Data
@ToString
public class SayState {

    /**
     * 发言状态编号
     */
    private int ssid;

    /**
     * 发言状态
     */
    private String saystate;

    public SayState() {
    }


}
