package com.wm.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author bilie
 * 帖子的实体类
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "invitation")
@Component
public class Invitation {

    /**
     * 帖子编号
     */
    @Id
    private ObjectId _id;

    /**
     * 帖子标题
     */
    private String title;

    /**
     * 帖子概要
     */
    private String summary;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 发言状态编号
     */
    private int ssid;

    /**
     * 帖子权限
     */
    private String limit;

    /**
     * 帖子创建时间
     */
    private Date createTime;

    /**
     * 帖子热度值
     */
    private int hotNumber;

    /**
     * 账号编号
     */
    private int aid;

    /**
     * 帖子类型编号
     */
    private int itid;

    /**
     * 影池编号  (外键)
     */
    private String mpid;

}
