package com.wm.service.impl;

import com.wm.po.MoviePool;
import com.wm.service.MoviePoolService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author km
 * 影池业务逻辑实现类
 */
@Service
public class MoviePoolServiceImpl implements MoviePoolService {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public List<MoviePool> findAll() {
        return mongoTemplate.findAll(MoviePool.class,"moviepool");
    }

    @Override
    public List<MoviePool> findByMpname(String mpname) {

        return mongoTemplate.find(Query.query(Criteria.where("mpname").is(mpname)),MoviePool.class,"moviepool");
    }

    @Override
    public MoviePool findById(String mpid) {
        return mongoTemplate.findById(mpid,MoviePool.class,"moviepool");
    }


    @Override
    public void insert(MoviePool moviePool) {
        mongoTemplate.insert(moviePool,"moviepool");
    }

    @Override
    public void updateHotNumber(MoviePool moviePool) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(moviePool.get_id().toString())), Update.update("hotnumber",moviePool.getHotnumber()),MoviePool.class);
    }

    @Override
    public void updateMpcontent(MoviePool moviePool) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(moviePool.get_id().toString())), Update.update("mpcontent",moviePool.getMpcontent()),MoviePool.class);

    }

    @Override
    public void updateManager(MoviePool moviePool) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(moviePool.get_id().toString())), Update.update("manager",moviePool.getManager()),MoviePool.class);
    }

    @Override
    public void updateBlacklist(MoviePool moviePool) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(moviePool.get_id().toString())), Update.update("blacklist",moviePool.getBlacklist()),MoviePool.class);

    }

    @Override
    public void updateState(MoviePool moviePool) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(moviePool.get_id().toString())), Update.update("state",moviePool.getState()),MoviePool.class);

    }
}
