package com.wm.po;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author km
 * 影池实体类
 */
@Data
@ToString
@Document(collection = "moviepool")
public class MoviePool {
    /**
     * 1. 影池编号(mpid)
     */
    @Id
    private ObjectId _id;
    /**
     * 2.影池名称(mpname)  String
     */
    @Indexed
    private String mpname;
    /**
     * 3. 影池简介(mpcontent)
     */
    private String mpcontent;
    /**
     * 4. 创建人(founder)  数组
     */
    private int [] founder;
    /**
     * 5. 热度(hotNumber)
     */
    private int hotnumber;
    /**
     * 6. 创建时间(createTime)
     */
    private Date createtime;
    /**
     * 7. 管理员(Manager)  数组
     */
    private int[] manager;
    /**
     * 8. 黑名单(blackList)    数组
     */
    private int[] blacklist;
    /**
     * 影池状态
     */
    private String state;
}
