package com.wm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author bilie
 * 帖子视图实体类
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class InvitationVO {

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

    private int hotNumber;

    /**
     * 账号编号
     */
    private int aid;

    /**
     * 账号名称
     */
    private String aname;

    /**
     * 用户头像地址
     */
    private String headshotaddress;

    /**
     * 2.影池名称(mpname)  String
     */
    private String mpname;

    /**
     * 帖子创建时间
     */
    private Date createTime;


}
