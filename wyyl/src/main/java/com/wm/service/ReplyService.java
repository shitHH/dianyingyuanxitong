package com.wm.service;

import com.wm.po.Reply;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * @author awei
 * 回复业务逻辑接口
 */
public interface ReplyService {

    /**
     * 查询所有回复
     * @return 回复集合
     */
    public List<Reply> findAll();

    /**
     * 通过回复编号查询回复对象
     * @param _id 回复编号
     * @return 回复对象
     */
    public Reply findById(ObjectId _id);

    /**
     * 通过帖子编号查询回复
     * @param iid 帖子编号
     * @return 回复集合
     */
    public List<Reply> findByIid(String iid);

    /**
     * 通过影评编号查询回复集合
     * @param mcid 影评编号
     * @return 回复集合
     */
    public List<Reply> findByMcid(int mcid);

    /**
     * 通过账号编号查询回复
     * @param aid 账号编号
     * @return 回复集合
     */
    public List<Reply> findByAid(int aid);

    /**
     * 添加回复
     * @param reply 回复对象
     */
    public void add(Reply reply);

    /**
     * @param _id 回复编号
     */
    public void delete(String _id);
}
