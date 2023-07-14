package com.wm.service;

import com.wm.po.Invitation;
import com.wm.vo.InvitationVO;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * @author bilie
 * 帖子业务逻辑接口
 */
public interface InvitationService {

    /**
     * 查询所有帖子
     * @return 所有帖子的集合
     */
    public List<Invitation> findAll();

    /**
     * 根据账号查找帖子
     * @param aid 账号编号
     * @return 当前账号下所有帖子集合
     */
    public List<Invitation> findByAid(int aid);

    /**
     * 根据帖子编号查询帖子
     * @param _id 帖子编号
     * @return 帖子对象
     */
    public Invitation findByIid(ObjectId _id);
    public InvitationVO findByIidVO(ObjectId _id);
    /**
     * 根据影池编号查询帖子
     * @param mpid 影池编号
     * @return 该影池下的帖子集合
     */
    public List<Invitation> findByMpid(String mpid);

    /**
     * 添加新的帖子
     * @param invitation 帖子对象
     */
    public void add(Invitation invitation);

    /**
     * 修改帖子热度
     * @param invitation 帖子对象
     */
    public void updateHotNumber(Invitation invitation);

    /**
     * 修改帖子发言状态
     * @param invitation 帖子对象
     */
    public void updateSsid(Invitation invitation);

    /**
     * 修改帖子权限
     * @param invitation 帖子对象
     */
    public void updateLimit(Invitation invitation);

    public void delete(ObjectId _id);

}
