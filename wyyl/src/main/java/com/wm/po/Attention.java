package com.wm.po;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yy
 * 关注记录实体类
 */
@Data
@ToString
@Document(collection = "attention")
public class Attention {

    /**
     * 关注记录编号
     */
    @Id
    private ObjectId atid;

    /**
     * 关注人账号编号
     */
    private int aid1;

    /**
     * 被关注人账号编号
     */
    private int aid2;

    /**
     * 关注人姓名
     */
    private String aname1;

    /**
     * 被关注人姓名
     */
    private String aname2;

    /**
     * 关注时间
     */
    private Date attentionTime;



    public Attention() {
    }

    public Attention(ObjectId atid, int aid1, int aid2, Date attentionTime) {
        this.atid = atid;
        this.aid1 = aid1;
        this.aid2 = aid2;
        this.attentionTime = attentionTime;
    }
}
