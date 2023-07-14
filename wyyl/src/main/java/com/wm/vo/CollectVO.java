package com.wm.vo;

/**
 * @author bilie
 * 收藏表实体类
 */

public class CollectVO {

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
    private String conllectType;

    /**
     * 账号编号
     */
    private int aid;

    /**
     * 影片名称
     */
    private String manme;

    public CollectVO() {
    }

    public CollectVO(int cid, int mid, String conllectType, int aid, String manme) {
        this.cid = cid;
        this.mid = mid;
        this.conllectType = conllectType;
        this.aid = aid;
        this.manme = manme;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getConllectType() {
        return conllectType;
    }

    public void setConllectType(String conllectType) {
        this.conllectType = conllectType;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getManme() {
        return manme;
    }

    public void setManme(String manme) {
        this.manme = manme;
    }
}
