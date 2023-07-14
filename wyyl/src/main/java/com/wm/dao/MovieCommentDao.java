package com.wm.dao;


import com.wm.po.*;
import com.wm.vo.MovieCommentVO;

import java.util.List;

/**
 * @author awei
 * 影评数据访问接口
 */
public interface MovieCommentDao {

    /**
     * 查询所有影评
     * @return 影评集合
     */
    public List<MovieComment> findAll();
    /**
     * 查询所有影评
     * @return 影评集合
     */
    public List<MovieCommentVO> findAllVO();
    /**
     * 根据影评编号查询影评对象
     * @param mcid 影评编号
     * @return 影评对象
     */
    public MovieComment findByMcid(int mcid);
    /**
     * 根据影评编号查询影评对象
     * @param mcid 影评编号
     * @return 影评对象
     */
    public MovieCommentVO findByMcidVO(int mcid);
    /**
     * 通过影片编号查询影评
     * @param mid 影片编号
     * @return 影评集合
     */
    public List<MovieComment> findByMid(int mid);

    /**
     * 通过影片编号查询影评
     * @param mid 影片编号
     * @return 影评视图集合
     */
    public List<MovieCommentVO> findByMidVO(int mid);
    /**
     * 根据账号查询影评
     * @param aid 账号编号
     * @return 影评集合
     */
    public List<MovieComment> findByAid(int aid);
    /**
     * 根据账号查询影评
     * @param aid 账号编号
     * @return 影评视图集合
     */
    public List<MovieCommentVO> findByAidVO(int aid);
    /**
     * 发表影评
     * @param movieComment 影评对象
     * @return 受影响的行数
     */
    public int add(MovieComment movieComment);

    /**
     * 更新影评
     * @param movieComment 影评对象
     * @return 受影响的行数
     */
    public int update(MovieComment movieComment);

    /**
     * 删除影评（修改状态）
     * @param array 影评编号数组
     * @return 受影响的行数
     */
    public int delete(int[] array);

    /**
     * 通过电影编号查询电影的总评分
     * @param mid 电影编号
     * @return 评分总和
     */
    public double score(int mid);
}
