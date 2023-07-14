package com.wm.po;


import lombok.Data;
import lombok.ToString;

/**
 * @author bilie
 * 创作记录实体类
 */
@Data
@ToString
public class Creation {

    /**
     * 创作编号
     */
    private int ctid;

    /**
     * 创作者编号
     */
    private int fid;

    /**
     * 影片编号
     */
    private int mid;

    /**
     * 创作类型编号
     */
    private int creationTypeid;

    public Creation() {
    }

    public Creation(int ctid, int fid, int mid, int creationTypeid) {
        this.ctid = ctid;
        this.fid = fid;
        this.mid = mid;
        this.creationTypeid = creationTypeid;
    }

}
