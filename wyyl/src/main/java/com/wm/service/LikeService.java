package com.wm.service;

import com.wm.po.Invitation;
import com.wm.po.Like;
import org.bson.types.ObjectId;

/**
 * @author yy
 * @version 1.0
 * @project java0613-3-group-project-3
 * @date 2022/10/8 15:13:51
 * 点赞功能业务逻辑接口
 */
public interface LikeService {

    /**
     * @param like 点赞的对象
     */
    public void add(Like like);

    /**
     * @param _Id 点赞记录编号--取消点赞
     */
    public void delete(ObjectId _Id);




    public Like findByiidAndaid(String _id, int aid);
    public Like findBymcidAndaid(int mcid, int aid);
    public Like findByreply_idAndaid(String _id, int aid);
}
