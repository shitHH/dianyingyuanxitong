package com.wm.service;

import com.wm.po.Account;
import com.wm.po.Attention;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * @author yy
 * @version 1.0
 * @project java0613-3-group-project-3
 * @date 2022/10/8 10:46:45
 * 关注功能业务逻辑接口
 */
public interface AttentionService {

    /**
     * @return 关注列表对象集合
     */
    public List<Attention> findAll();




    /**
     * @param aname1 关注人姓名
     * @return 关注人对象
     */
   public Attention findByname1(String aname1);

   /**
     * @param aname2 被关注人姓名
     * @return 被关注人对象
     */
   public Attention findByname2(String aname2);

    /**
     * @param aid1 关注人账号编号
     * @return 关注人对象
     */
   public Attention findByaid1(int aid1);

   public List<Attention> findByaid_one(int aid_one);

    /**
     * @param aid2 被关注人账号编号
     * @return 被关注人对象
     */
   public Attention findByaid2(int aid2);


    /**
     * @param attention 关注对象
     * @return 受影响行数
     */
    public void add(Attention attention);

    /**
     * 取消关注
     * @param atid 关注编号
     */
    public void delete(ObjectId atid);

}
