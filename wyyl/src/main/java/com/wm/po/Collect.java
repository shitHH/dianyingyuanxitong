package com.wm.po;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author bilie
 * 收藏表实体类
 */
@Data
@ToString
@Component
public class Collect {

    /**
     * 收藏编号
     */
    private int cid;

    /**
     * 电影编号
     */
    private int mid;

    /**
     * 收藏类型
     */
    private String collectType;

    /**
     * 账号编号
     */
    private int aid;

    public Collect() {
    }

    public Collect(int cid, int mid, String conllectType, int aid) {
        this.cid = cid;
        this.mid = mid;
        this.collectType = conllectType;
        this.aid = aid;
    }

}
