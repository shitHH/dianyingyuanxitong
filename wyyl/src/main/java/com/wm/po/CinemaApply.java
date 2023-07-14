package com.wm.po;

import lombok.Data;
import lombok.ToString;

/**
 * @author bilie
 * @author 陈晨
 * 影院申请实体类
 */
@ToString
@Data
public class CinemaApply {

    /**
     * 申请编号
     */
    private int caid;

    /**
     * 影院名称
     */
    private String cname;

    /**
     * 影院地址
     */
    private String caddress;

    /**
     * 申请资料地址
     */
    private String dataaddress;

    /**
     * 影院对公邮箱
     */
    private String cemail;

    /**
     * 影院对公电话
     */
    private String ctel;

    /**
     * 申请状态
     */
    private String castate;
    /**
     * 申请人姓名
     */
    private String name;
    /**
     * 申请人身份证号
     */
    private String identity;
    /**
     * 账号编号
     */
    private int aid;

    public CinemaApply() {
    }

    public CinemaApply(int caid, String cname, String caddress, String dataaddress, String cemail, String ctel, String castate, String name, String identity) {
        this.caid = caid;
        this.cname = cname;
        this.caddress = caddress;
        this.dataaddress = dataaddress;
        this.cemail = cemail;
        this.ctel = ctel;
        this.castate = castate;
        this.name = name;
        this.identity = identity;
    }
}
