package com.wm.service;

import com.wm.po.Framer;
import com.wm.vo.FramerVO;

import java.util.List;

/**
 * @author awei
 * 创作者业务逻辑接口
 */
public interface FramerService {
    /**
     * 查询左右创作者
     * @return 创作者集合
     */
    public List<Framer> findAll();

    /**
     * 通过创作者编号查询创作者对象
     * @return 创作者对象
     */
    public Framer findByFid(int fid);

    /**
     * 查询创作者视图
     * @param fid 创作者编号
     * @return 创作者集合
     */
    public FramerVO findVOByFid(int fid);

    /**
     * 添加创作者
     * @param framer 创作者对象
     * @return 是否删除
     */
    public boolean add(Framer framer);
    /**
     * 更新创作者
     * @param framer 创作者对象
     * @return 是否删除
     */
    public boolean update(Framer framer);

    /**
     * 删除创作者
     * @param array 创作者编号数组
     * @return 是否删除
     */
    public boolean delete(int[] array);
}
