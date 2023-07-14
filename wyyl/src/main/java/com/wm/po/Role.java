package com.wm.po;

import lombok.Data;
import lombok.ToString;

/**
 * @author bilie
 * @author 陈晨
 * 角色实体类
 */
@ToString
@Data
public class Role {

    /**
     * 角色编号
     */
    private int rid;

    /**
     * 角色名称
     */
    private String rname;

    public Role() {
    }

    public Role(int rid, String rname) {
        this.rid = rid;
        this.rname = rname;
    }

}
