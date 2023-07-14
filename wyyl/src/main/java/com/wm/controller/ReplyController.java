package com.wm.controller;

import com.wm.po.Invitation;
import com.wm.po.Reply;
import com.wm.service.InvitationService;
import com.wm.service.MovieCommentService;
import com.wm.service.ReplyService;
import com.wm.vo.InvitationVO;
import com.wm.vo.MovieCommentVO;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author awei
 * 回复控制器
 */
@Controller
public class ReplyController {
    Logger logger=Logger.getLogger(ReplyController.class);
    @Autowired
    ReplyService replyService;
    @Autowired
    InvitationService invitationService;
    @Autowired
    MovieCommentService movieCommentService;
    @GetMapping("toaddinvitationreply")
    public String toAddInvitationReply(String iid, Model model){
        logger.info("去添加帖子回复的控制器");
        Invitation invitation = invitationService.findByIid(new ObjectId(iid));
        logger.info(invitation.getTitle());
        List<Reply> replys=replyService.findByIid(iid);
        logger.info(replys.size());
        model.addAttribute("replys",replys);
        model.addAttribute("invitation",invitation);
        model.addAttribute("iid",iid);
        return "frontjsp/addinvitationreply";
    }
    @PostMapping("addsaveinvitationreply")
    public String addSaveInvitationReply(Reply reply){
        String iid=reply.getIid();
        logger.info(iid);
        logger.info("给帖子添加回复控制器");
        replyService.add(reply);
        return "redirect:/invitationinfo?iid="+iid;
    }
    @GetMapping("toaddmoviecommentreply")
    public String toAddMovieCommentReply(int mcid,Model model){
        logger.info("去添加影评回复的控制器");
        MovieCommentVO movieCommentVO=movieCommentService.findByMcidVO(mcid);
        logger.info(movieCommentVO.getMname());
        List<Reply> list=replyService.findByMcid(mcid);
        logger.info(list.size());
        model.addAttribute("movieCommentVO",movieCommentVO);
        model.addAttribute("list",list);
        return "frontjsp/movieinfo";
    }

    @PostMapping("addmoviecommentreply")
    public String addmoviecommentreply(Reply reply,int mid){
        logger.info("添加影评的评论");
        replyService.add(reply);
        return "redirect:/movieinfo?mid="+mid;
    }

}
