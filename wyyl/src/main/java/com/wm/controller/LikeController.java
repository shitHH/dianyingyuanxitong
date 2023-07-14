package com.wm.controller;

import com.wm.po.Collect;
import com.wm.po.Like;
import com.wm.service.InvitationService;
import com.wm.service.LikeService;
import com.wm.service.MovieCommentService;
import com.wm.service.ReplyService;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yy
 * @version 1.0
 * @project java0613-3-group-project-3
 * @date 2022/10/9 09:22:32
 */
@Controller
public class LikeController {

    Logger logger = Logger.getLogger(LikeController.class);

    @Autowired
    LikeService likeService;

    @Autowired
    InvitationService invitationService;

    @Autowired
    MovieCommentService movieCommentService;

    @Autowired
    ReplyService replyService;

    //帖子点赞功能
    @PostMapping("/likeinvitation")
    @ResponseBody
    public boolean addLikeInvitation(String _id, int aid) {
        logger.info("进入帖子点赞功能控制器...");
        Like like = likeService.findByiidAndaid(_id, aid);
        logger.info(like);
        Like like1 = new Like();
        like1.setIid(_id);
        like1.setAid(aid);
        if (like != null) {
            logger.info("已点赞...");
            likeService.delete(like.get_Id());
            return false;
        } else {
            logger.info("未点赞，即将点赞...");
            likeService.add(like1);
            return true;
        }
    }


    //影评点赞功能
    @PostMapping("/likemoviecomment")
    @ResponseBody
    public boolean addLikeMovieComment(int mcid, int aid) {
        logger.info("进入影评点赞功能控制器...");
        Like like = likeService.findBymcidAndaid(mcid, aid);
        logger.info("like=" + like);
        Like like1 = new Like();
        like1.setMcid(mcid);
        like1.setAid(aid);
        if (like != null) {
            logger.info("已点赞...");
            likeService.delete(like.get_Id());
            return false;
        } else {
            logger.info("未点赞，即将点赞...");
            likeService.add(like1);
            return true;
        }
    }

    //回复点赞功能
    @PostMapping("/likereply")
    @ResponseBody
    public boolean addLikeReply(String reply_id, int aid) {
        logger.info("进入回复点赞功能控制器...");
        Like like = likeService.findByreply_idAndaid(reply_id, aid);
        logger.info(like);
        Like like1 = new Like();
        like1.setReply_id(reply_id);
        like1.setAid(aid);
        if (like != null) {
            logger.info("已点赞...");
            likeService.delete(like.get_Id());
            return false;
        } else {
            logger.info("未点赞，即将点赞...");
            likeService.add(like1);
            return true;
        }
    }


}
