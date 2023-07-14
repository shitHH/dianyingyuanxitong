package com.wm.po;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author bilie
 * 帖子类型实体类
 */
@ToString
@Data
@Component
public class InvitationType {

    /**
     * 帖子类型编号
     */
    private int itid;

    /**
     * 帖子类型名称
     */
    private String itname;

    public InvitationType() {
    }

    public InvitationType(int itid, String itname) {
        this.itid = itid;
        this.itname = itname;
    }
}
