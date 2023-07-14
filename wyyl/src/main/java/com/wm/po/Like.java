package com.wm.po;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * @author yy
 * @version 1.0
 * @project java0613-3-group-project-3
 * @date 2022/10/8 14:54:25
 */
@Data
@Component
@Document(collection = "like")
@ToString
public class Like {

    /**
     * 点赞编号
     */
    @Id
    private ObjectId _Id;

    /**
     * 被点赞帖子编号
     */
    private String iid;

    /**
     * 帖子标题
     */
    private String title;

    /**
     * 被点赞影评编号
     */
    private int mcid;

    /**
     * 被点赞回复编号
     */
    private String reply_id;

    /**
     * 点赞的人的编号
     */
    private int aid;

}
