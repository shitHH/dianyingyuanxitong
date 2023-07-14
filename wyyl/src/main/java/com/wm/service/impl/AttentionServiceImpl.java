package com.wm.service.impl;

import com.wm.po.Account;
import com.wm.po.Attention;
import com.wm.service.AttentionService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yy
 * @version 1.0
 * @project java0613-3-group-project-3
 * @date 2022/10/8 11:03:35
 * 关注功能业务逻辑实现
 */
@Service
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Attention> findAll() {
        return mongoTemplate.findAll(Attention.class,"attention");
    }

    @Override
    public Attention findByname1(String aname1) {
        return mongoTemplate.findOne(Query.query(Criteria.where(aname1).is("aname1")),Attention.class,"attention");
    }

    @Override
    public Attention findByname2(String aname2) {
        return mongoTemplate.findOne(Query.query(Criteria.where("aname2").is(aname2)),Attention.class,"attention");
    }

    @Override
    public Attention findByaid1(int aid1) {
        return mongoTemplate.findOne(Query.query(Criteria.where("aid1").is(aid1)),Attention.class,"attention");
    }

    @Override
    public List<Attention> findByaid_one(int aid_one) {
        return mongoTemplate.find(Query.query(Criteria.where("aid1").is(aid_one)),Attention.class,"attention");
    }

    @Override
    public Attention findByaid2(int aid2) {
        return mongoTemplate.findOne(Query.query(Criteria.where("aid2").is(aid2)),Attention.class,"attention");
    }


    @Override
    public void add(Attention attention) {
        mongoTemplate.insert(attention,"attention");
    }

    @Override
    public void delete(ObjectId atid) {
        mongoTemplate.remove(Query.query(Criteria.where("atid").is(atid.toString())),Attention.class,"attention");

    }
}
