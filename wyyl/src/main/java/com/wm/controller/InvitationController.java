package com.wm.controller;

import com.wm.po.Invitation;
import com.wm.po.MoviePool;
import com.wm.po.Reply;
import com.wm.service.*;
import com.wm.vo.AccountVo;
import com.wm.vo.HallVO;
import com.wm.vo.InvitationVO;
import com.wm.vo.MoviesVO;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author bilie
 * 帖子的控制器
 */
@Controller
public class InvitationController {

    Logger logger = Logger.getLogger(InvitationController.class);

    @Autowired
    InvitationService invitationService;

    @Autowired
    ReplyService replyService;
    @Autowired
    AccountService accountService;

    @Autowired
    MoviePoolService moviePoolService;

    @Autowired
    LikeService likeService;

    @GetMapping("/toaccountinvitationlist")
    public String toAccountInvitationList(int aid, Model model){
        logger.info("查看账号下的帖子");
        List<InvitationVO> list = new ArrayList<>();
        List<Invitation> invitations = invitationService.findByAid(aid);
        for (Invitation invitation:invitations){
            InvitationVO invitationVO = new InvitationVO();
            invitationVO.set_id(invitation.get_id());
            invitationVO.setTitle(invitation.getTitle());
            invitationVO.setAname(accountService.findByAid(invitation.getAid()).getAname());
            invitationVO.setSummary(invitation.getSummary());
            logger.info(invitation.getMpid());
            invitationVO.setMpname(moviePoolService.findById(invitation.getMpid()).getMpname());
            invitationVO.setCreateTime(invitation.getCreateTime());
            invitationVO.setHeadshotaddress(accountService.findByAid(invitation.getAid()).getHeadshotaddress());
            invitationVO.setAid(invitation.getAid());
            list.add(invitationVO);
        }
        model.addAttribute("list",list);
        return "frontjsp/invitationlist";
    }

    @GetMapping("/tomoviepoolinvitationlist")
    public String toMoviePoolInvitationList(String mpid, Model model){
        logger.info("查看该影池下的帖子");
        List<Invitation> invitations = invitationService.findByMpid(mpid);
        List<InvitationVO> list = new ArrayList<>();
        for (Invitation invitation:invitations){
            InvitationVO invitationVO = new InvitationVO();
            invitationVO.set_id(invitation.get_id());
            invitationVO.setTitle(invitation.getTitle());
            invitationVO.setAname(accountService.findByAid(invitation.getAid()).getAname());
            invitationVO.setSummary(invitation.getSummary());
            logger.info(invitation.getMpid());
            invitationVO.setMpname(moviePoolService.findById(invitation.getMpid()).getMpname());
            invitationVO.setCreateTime(invitation.getCreateTime());
            invitationVO.setHeadshotaddress(accountService.findByAid(invitation.getAid()).getHeadshotaddress());
            invitationVO.setAid(invitation.getAid());
            list.add(invitationVO);
        }
        model.addAttribute("list",list);
        return "frontjsp/invitationlist";
    }

    @GetMapping("/toinvitationlist")
    public String toinvitationlist(Model model,HttpSession session) {
        logger.info("展示所有帖子");
        List<InvitationVO> list = new ArrayList<>();
        List<Invitation> invitations = invitationService.findAll();
        Map<String,List<Reply>> replys= new HashMap<>();
        logger.info("帖子的集合大小"+replys.size());
        for (Invitation invitation : invitations) {
            replys.put(invitation.get_id().toString(), replyService.findByIid(invitation.get_id().toString()));
            InvitationVO invitationVO = new InvitationVO();
            invitationVO.set_id(invitation.get_id());
            invitationVO.setTitle(invitation.getTitle());
            invitationVO.setAname(accountService.findByAid(invitation.getAid()).getAname());
            invitationVO.setSummary(invitation.getSummary());
            invitationVO.setHotNumber(invitation.getHotNumber());
            invitationVO.setMpname(moviePoolService.findById(invitation.getMpid()).getMpname());
            invitationVO.setCreateTime(invitation.getCreateTime());
            invitationVO.setHeadshotaddress(accountService.findByAid(invitation.getAid()).getHeadshotaddress());
            invitationVO.setAid(invitation.getAid());
            list.add(invitationVO);
        }
        model.addAttribute("list", list);
        model.addAttribute("replys",replys);
        Object obj = session.getAttribute("currentaccount");
        logger.info("obj="+obj);
        if (obj == null) {
            return "frontjsp/invitationlist";
        } else {
            AccountVo accountVo = (AccountVo) obj;
            logger.info("accountVo="+accountVo);
            Map<ObjectId, Boolean> likemap = new HashMap<>();
            if (list != null) {
                for (InvitationVO invitationVO : list) {
                    if (likeService.findByiidAndaid(invitationVO.get_id().toString(),accountVo.getAid()) == null) {
                        likemap.put(invitationVO.get_id(), false);
                    } else {
                        likemap.put(invitationVO.get_id(), true);
                    }
                }
                logger.info("likemap="+likemap);
                model.addAttribute("likemap", likemap);
            }

        }


        return "frontjsp/invitationlist";
        }

    @GetMapping("/invitationinfo")
    public String invitationinfo(String iid,Model model,HttpSession session ){
        Invitation invitation = invitationService.findByIid(new ObjectId(iid));
        List<Reply> replys=replyService.findByIid(iid);
        logger.info(replys.size());
        InvitationVO invitationVO = new InvitationVO();
        invitationVO.set_id(invitation.get_id());
        invitationVO.setTitle(invitation.getTitle());
        invitationVO.setAname(accountService.findByAid(invitation.getAid()).getAname());
        invitationVO.setSummary(invitation.getSummary());
        logger.info(invitation.getMpid());
        invitationVO.setMpname(moviePoolService.findById(invitation.getMpid()).getMpname());
        invitationVO.setCreateTime(invitation.getCreateTime());
        invitationVO.setContent(invitation.getContent());
        invitationVO.setHeadshotaddress(accountService.findByAid(invitation.getAid()).getHeadshotaddress());
        invitationVO.setAid(invitation.getAid());
        model.addAttribute("invitationVO",invitationVO);
        model.addAttribute("replys",replys);


        Object obj = session.getAttribute("currentaccount");
        logger.info("obj="+obj);
        if (obj == null) {
            return "frontjsp/invitationlist";
        } else {
            AccountVo accountVo = (AccountVo) obj;
            logger.info("accountVo="+accountVo);
            Map<String, Boolean> likemap = new HashMap<>();
            List<Reply> list = replyService.findByIid(iid);
            logger.info(list);
            if (list != null) {
                for (Reply reply : list) {
                    logger.info(reply.get_id());
                    if (likeService.findByreply_idAndaid(reply.get_id().toString(),accountVo.getAid()) == null) {
                        logger.info("回复编号="+reply.get_id());
                        likemap.put(reply.get_id().toString(), false);
                    } else {
                        likemap.put(reply.get_id().toString(), true);
                    }
                }
                logger.info("likemap="+likemap);
                model.addAttribute("likemap", likemap);
            }
        }
        return "frontjsp/invitationinfo";
    }

    @PostMapping("/addinvitation")
    public String addinvitation(Invitation invitation){
        logger.info("添加帖子");
        invitationService.add(invitation);
        return "redirect:/toinvitationlist";
    }

    //之后的为后台的页面
    @GetMapping("/backinvitationlist")
    public String backinvitationlist(Model model) {
        logger.info("展示所有帖子");
        List<InvitationVO> list = new ArrayList<>();
        List<Invitation> invitations = invitationService.findAll();
        for (Invitation invitation : invitations) {
            InvitationVO invitationVO = new InvitationVO();
            invitationVO.set_id(invitation.get_id());
            invitationVO.setTitle(invitation.getTitle());
            invitationVO.setAname(accountService.findByAid(invitation.getAid()).getAname());
            invitationVO.setSummary(invitation.getSummary());
            logger.info(invitation.getMpid());
            invitationVO.setMpname(moviePoolService.findById(invitation.getMpid()).getMpname());
            invitationVO.setCreateTime(invitation.getCreateTime());
            invitationVO.setHeadshotaddress(accountService.findByAid(invitation.getAid()).getHeadshotaddress());
            invitationVO.setAid(invitation.getAid());
            list.add(invitationVO);
        }
        model.addAttribute("list", list);
        return "backjsp/invitationlist";
    }
    @GetMapping("/backinvitationinfo")
    public String backinvitationinfo(String _id,Model model){
        logger.info("查看帖子详情");
        logger.info(_id);
        Invitation invitations= invitationService.findByIid(new ObjectId(_id));
        InvitationVO invitation = new InvitationVO();
        invitation.setTitle(invitations.getTitle());
        invitation.setAname(accountService.findByAid(invitations.getAid()).getAname());
        invitation.setCreateTime(invitations.getCreateTime());
        invitation.setContent(invitations.getContent());
        model.addAttribute("invitation",invitation);
        return "backjsp/invitationinfo";
    }

    @GetMapping("/deleteinvitation")
    public String deleteinvitation(String _id){
        logger.info("删除帖子");
        invitationService.delete(new ObjectId(_id));
        return "redirect:/backinvitationlist";
    }


}
