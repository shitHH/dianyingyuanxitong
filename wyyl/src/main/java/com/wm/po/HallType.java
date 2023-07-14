package com.wm.po;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author bilie
 * 影厅类型实体类
 */
@ToString
@Data
@Component
public class HallType {

    /**
     * 影厅类型编号
     */
    private int htid;

    /**
     * 影厅类型名称
     */
    private String htname;

    public HallType() {
    }

    public HallType(int htid, String htname) {
        this.htid = htid;
        this.htname = htname;
    }

}
