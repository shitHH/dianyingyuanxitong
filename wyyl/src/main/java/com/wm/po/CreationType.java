package com.wm.po;


import lombok.Data;
import lombok.ToString;

/**
 * @author bilie
 * 创作类型实体类
 */
@Data
@ToString
public class CreationType {

    /**
     * 创作类型编号
     */
    private int creationTypeid;

    /**
     * 创作类型
     */
    private String creationType;

    public CreationType() {
    }

    public CreationType(int creationTypeid, String creationType) {
        this.creationTypeid = creationTypeid;
        this.creationType = creationType;
    }

}
