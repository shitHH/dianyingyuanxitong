package com.wm.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author awei
 * 回复实体类
 */
@Data
@ToString
@AllArgsConstructor
@Document(collection = "reply")
public class Reply {

    /**
     * 回复编号
     */
    @Id
    private ObjectId _id;
    /**
     * 帖子编号
     */
    private String iid;
    /**
     * 影评编号
     */
    private int mcid;
    /**
     * 账号编号
     */
    private int aid;

    private String aname;
    /**
     * 回复时间
     */
    private Date rtime;
    /**
     * 影评回复
     */
    private String mccontent;
    /**
     * 帖子回复
     */
    private String icontent;

    public Reply() {
    }


}
