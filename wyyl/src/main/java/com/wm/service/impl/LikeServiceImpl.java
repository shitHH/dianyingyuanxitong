package com.wm.service.impl;

import com.wm.po.Invitation;
import com.wm.po.Like;
import com.wm.service.LikeService;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yy
 * @version 1.0
 * @project java0613-3-group-project-3
 * @date 2022/10/8 15:21:15
 * 点赞业务逻辑接口实现类
 */
@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void add(Like like) {
        mongoTemplate.insert(like,"like");
    }

    @Override
    public void delete(ObjectId _Id) {
        mongoTemplate.remove(Query.query(Criteria.where("_Id").is(_Id.toString())),Like.class,"like");
    }

    @Override
    public Like findBymcidAndaid(int mcid, int aid) {
        Query query = Query.query(Criteria.where("aid").is(aid));
        List<Like> likes=mongoTemplate.find(query,Like.class,"like");
        for (Like like:likes){
            if (like.getMcid()>0){
                if (like.getMcid()==mcid){
                    return like;
                }
            }
        }
        return null;
    }

    @Override
    public Like findByiidAndaid(String _id, int aid) {
        Query query = Query.query(Criteria.where("aid").is(aid));
        List<Like> likes=mongoTemplate.find(query,Like.class,"like");
        System.out.println(likes);
        for (Like like:likes){
            if (like.getIid()!=null){
                if (like.getIid().equals(_id)){
                    return like;
                }
            }

        }
        return null;
    }

    @Override
    public Like findByreply_idAndaid(String _id, int aid) {
        Query query = Query.query(Criteria.where("aid").is(aid));
        List<Like> likes=mongoTemplate.find(query,Like.class,"like");
        System.out.println(likes);
        for (Like like:likes){
            if (like.getReply_id()!=null){
                if (like.getReply_id().equals(_id)){
                    return like;
                }
            }
        }
        return null;
    }
}
