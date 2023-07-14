package com.wm.dao;

import com.wm.po.InvitationType;

import java.util.List;

/**
 * @author bilie
 * 帖子类型数据访问接口
 */
public interface InvitationTypeDao {

    /**
     * 查询所有帖子类型
     * @return 帖子类型集合
     */
    public List<InvitationType> findAll();

    /**
     * 根据帖子类型编号查询帖子
     * @param itid 帖子类型编号
     * @return 帖子类型对象
     */
    public InvitationType findByItid(int itid);

    /**
     * 添加帖子类型
     * @param invitationType 帖子类型对象
     * @return 受影响的行数
     */
    public int add(InvitationType invitationType);

    /**
     * 修改帖子类型
     * @param invitationType 帖子类型对象
     * @return 受影响的行数
     */
    public int update(InvitationType invitationType);

    /**
     * 删除帖子类型
     * @param array 帖子类型编号
     * @return 受影响的行数
     */
    public int delete(int[] array);

}
