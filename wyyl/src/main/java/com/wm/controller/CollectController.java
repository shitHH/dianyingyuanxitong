package com.wm.controller;

import com.wm.po.Collect;
import com.wm.service.CollectService;
import com.wm.service.MoviesService;
import com.wm.vo.MoviesVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yy
 * @version 1.0
 * @project java0613-3-group-project-3
 * @date 2022/10/8 16:12:16
 * 收藏功能控制器
 */
@Controller
public class CollectController {

    Logger logger = Logger.getLogger(CollectController.class);

    @Autowired
    CollectService collectService;
    @Autowired
    MoviesService moviesService;

    //查看我的收藏--收藏的影片
    @GetMapping("/tocollectlist")
    public String toCollectList(Model model) {
        logger.info("进入收藏列表...");
        List<Collect> list = collectService.findAll();
        List<MoviesVO> moviesVOList=new ArrayList<>();
        for (Collect collect:list){
            moviesVOList.add(moviesService.findVOByMid(collect.getMid()));
        }
        model.addAttribute("moviesVOList",moviesVOList);
        return "frontjsp/collectlist";
    }

    //点击后收藏至收藏列表，添加收藏功能
    @PostMapping("/addcollect")
    @ResponseBody
    public boolean addcollect(int mid, int aid) {
        logger.info("进入添加收藏功能控制器...");
        Collect collect = collectService.findByMidAndAid(mid, aid);
        Collect collect1 = new Collect();
        collect1.setAid(aid);
        collect1.setMid(mid);
        collect1.setCollectType("我喜欢");
        if (collect == null) {
            logger.info("未喜欢。。。。。");
            collectService.add(collect1);
            return true;
        }
        if (collect.getCollectType().equals("我喜欢")) {
            logger.info("已喜欢收藏。。。。。");
            collectService.delete(new int[]{collect.getCid()});
            return false;
        } else {
            logger.info("未喜欢，即将喜欢。。。。。");
            collectService.add(collect1);
            return true;
        }
    }

}
