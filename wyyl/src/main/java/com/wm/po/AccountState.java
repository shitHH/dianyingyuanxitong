package com.wm.po;

import lombok.Data;
import lombok.ToString;

/**
 * @author bilie
 * @author 陈晨
 * 用户状体实体类
 */
@ToString
@Data
public class AccountState {

    /**
     * 账号状态编号
     */
    private int asid;

    /**
     * 账号状态
     */
    private String accountstate;

    public AccountState() {
    }

    public AccountState(int asid, String accountstate) {
        this.asid = asid;
        this.accountstate = accountstate;
    }

}
