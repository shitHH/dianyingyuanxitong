package com.wm.service.impl;

import com.wm.po.Invitation;
import com.wm.service.InvitationService;
import com.wm.vo.InvitationVO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author bilie
 * 帖子业务逻辑操作的实现类
 */
@Service
public class InvitationServiceImpl implements InvitationService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Invitation> findAll() {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Query query = new Query();
        return mongoTemplate.find(query.with(sort),Invitation.class,"invitation");
    }

    @Override
    public List<Invitation> findByAid(int aid) {
        return mongoTemplate.find(Query.query(Criteria.where("aid").is(aid)),Invitation.class,"invitation");
    }

    @Override
    public List<Invitation> findByMpid(String mpid) {
        return mongoTemplate.find(Query.query(Criteria.where("mpid").is(mpid)),Invitation.class,"invitation");
    }

    @Override
    public Invitation findByIid(ObjectId _id) {
        return mongoTemplate.findById(_id,Invitation.class,"invitation");
    }

    @Override
    public InvitationVO findByIidVO(ObjectId _id) {
        return mongoTemplate.findById(_id,InvitationVO.class,"invitationVO");
    }

    @Override
    public void add(Invitation invitation) {
        invitation.setCreateTime(new Date(System.currentTimeMillis()));
        mongoTemplate.insert(invitation,"invitation");
    }

    @Override
    public void updateHotNumber(Invitation invitation) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(invitation.get_id().toString())), Update.update("hotNumber",invitation.getHotNumber()), Invitation.class);
    }

    @Override
    public void updateSsid(Invitation invitation) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(invitation.get_id().toString())), Update.update("ssid",invitation.getSsid()), Invitation.class);
    }

    @Override
    public void updateLimit(Invitation invitation) {
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(invitation.get_id().toString())), Update.update("limit",invitation.getLimit()), Invitation.class);
    }

    @Override
    public void delete(ObjectId _id) {
        mongoTemplate.remove(mongoTemplate.findById(_id,Invitation.class,"invitation"));
    }
}
