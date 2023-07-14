package com.wm.service.impl;

import com.wm.po.Invitation;
import com.wm.po.Reply;
import com.wm.service.ReplyService;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author awei
 * 回复业务逻辑实现类
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    MongoTemplate mongoTemplate;
    @Override
    public List<Reply> findAll() {
        Sort sort = new Sort(Sort.Direction.DESC,"rtime");
        Query query = new Query();
        return mongoTemplate.find(query.with(sort), Reply.class,"reply");
    }

    @Override
    public Reply findById(ObjectId _id) {
        return mongoTemplate.findById(_id,Reply.class,"reply");
    }

    @Override
    public List<Reply> findByIid(String iid) {
        return mongoTemplate.find(Query.query(Criteria.where("iid").is(iid)),Reply.class,"reply");
    }

    @Override
    public List<Reply> findByMcid(int mcid) {
        return mongoTemplate.find(Query.query(Criteria.where("mcid").is(mcid)),Reply.class,"reply");
    }

    @Override
    public List<Reply> findByAid(int aid) {
        return mongoTemplate.find(Query.query(Criteria.where("aid").is(aid)),Reply.class,"reply");
    }

    @Override
    public void add(Reply reply) {
        reply.setRtime(new Date(System.currentTimeMillis()));
        mongoTemplate.insert(reply,"reply");
    }

    @Override
    public void delete(String _id) {
        mongoTemplate.remove(Query.query(Criteria.where("_id").is(_id)),Reply.class,"reply");
    }
}
