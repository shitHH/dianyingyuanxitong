package com.wm.controller;

import com.wm.po.Attention;
import com.wm.service.AccountService;
import com.wm.service.AttentionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yy
 * @version 1.0
 * @project java0613-3-group-project-3
 * @date 2022/10/9 19:34:47
 * 关注功能控制器
 */
@Controller
public class AttentionController {

    Logger logger = Logger.getLogger(AttentionController.class);

    @Autowired
    AttentionService attentionService;

    @Autowired
    AccountService accountService;

    @GetMapping("/toattentionlist")

    public String toAttentionList(int aid_one,Model model) {
        logger.info("进去到去关注列表");
        List<Attention> list = attentionService.findByaid_one(aid_one);
        model.addAttribute("list", list);
        return "frontjsp/attentionlist";
    }

    @PostMapping("/addattention")
    @ResponseBody
    public boolean addattention(int aid2,int aid1) {
        logger.info("添加关注控制器...");
        //被关注的人（粉丝）
        Attention attention2 = attentionService.findByaid2(aid2);
        logger.info(aid2);

        Attention attention = new Attention();
        attention.setAid2(aid2);

        if (attention2 != null) {
            logger.info("已经关注过了...");
            attentionService.delete(attentionService.findByaid1(aid1).getAtid());
            return false;
        }else {
            logger.info("未关注状态...");
            attentionService.add(attention);
            return true;
        }
    }



}