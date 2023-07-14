package com.wm.controller;

import com.wm.po.Account;
import com.wm.po.Cinema;
import com.wm.po.CinemaApply;
import com.wm.service.AccountService;
import com.wm.service.CinemaApplyService;
import com.wm.service.CinemaService;
import com.wm.util.UploadFile;
import com.wm.vo.CinemaVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * @author ss
 * 影院控制器
 */
@Controller
public class CinemaController {

    Logger logger = Logger.getLogger(CinemaController.class);

    @Autowired
    CinemaService cinemaService;

    @Autowired
    CinemaApplyService cinemaApplyService;

    @Autowired
    AccountService accountService;

    @GetMapping("/tocinemaapply")
    public String toCinemaApply() {
        logger.info("准备注册影院");
        return "frontjsp/cinemapply";
    }

    @PostMapping("/addcinemaapplysave")
    public String addCinemaApplySave(@RequestParam(value = "olddataaddress") MultipartFile olddataaddress, CinemaApply cinemaApply) {
        logger.info(cinemaApply);
        logger.info(olddataaddress.getOriginalFilename());
        String dataaddress = UploadFile.uploadfile(olddataaddress);
        cinemaApply.setDataaddress(dataaddress);
        cinemaApplyService.add(cinemaApply);
        return "redirect:/index.action";
    }

    @GetMapping("/cinemalist")
    public String cinemalist(Model model){
        logger.info("影院列表");
        List<CinemaVO> list = cinemaService.findVOAllCom();
        model.addAttribute("list",list);
        return "backjsp/cinemalist";
    }

    @GetMapping("/cinemaapplylist")
    public String cinemaApplyList(Model model) {
        logger.info("影院申请列表");
        List<CinemaApply> list = cinemaApplyService.findAll();
        logger.info(list.size());
        model.addAttribute("list", list);
        return "backjsp/cinemaapplylist";
    }

    @GetMapping("/cinemaapplylisti")
    public String cinemaApplyListi(Model model) {
        logger.info("待审核影院列表");
        List<CinemaApply> list = cinemaApplyService.findByCastate("待审核");
        model.addAttribute("list", list);
        return "backjsp/cinemaapplylist";
    }

    @GetMapping("/cinemaapplylistn")
    public String cinemaApplyListn(Model model) {
        logger.info("未通过影院列表");
        List<CinemaApply> list = cinemaApplyService.findByCastate("未通过");
        model.addAttribute("list", list);
        return "backjsp/cinemaapplylist";
    }

    @GetMapping("/cinemaapplylista")
    public String cinemaApplyLista(Model model) {
        logger.info("已通过影院列表");
        List<CinemaApply> list = cinemaApplyService.findByCastate("已通过");
        model.addAttribute("list", list);
        return "backjsp/cinemaapplylist";
    }

    @GetMapping("/cinemaapplyinfo")
    public String cinemaApplyInfo(int caid, Model model) {
        logger.info(caid);
        CinemaApply cinemaApply = cinemaApplyService.findByCaid(caid);
        logger.info(cinemaApply);
        model.addAttribute("cinemaapply", cinemaApply);
        return "backjsp/cinemaapplyinfo";
    }

    @GetMapping("/updatecinemaapplystatea")
    public String updateCinemaApplyStatea(int caid) {
        logger.info("修改状态");
        logger.info(caid);
        CinemaApply cinemaApply = cinemaApplyService.findByCaid(caid);
        logger.info(cinemaApply);
        cinemaApply.setCastate("已通过");
        cinemaApplyService.update(cinemaApply);
        Cinema cinema=new Cinema();
        cinema.setCaid(cinemaApply.getCaid());
        int cinameid=cinemaService.add(cinema);
        Account account=new Account();
        //tel,aname,pass,cinemaid
        account.setAname(cinemaApply.getCname());
        account.setTel(cinemaApply.getCtel());
        account.setCinemaid(cinameid);
        logger.info(cinemaApply.getIdentity().substring(12));
        account.setPass(cinemaApply.getIdentity().substring(12));
        accountService.addCinemaAccount(account);
        return "redirect:/accountlist.action";
    }

    @GetMapping("/updatecinemaapplystaten")
    public String updateCinemaApplyStaten(int caid) {
        logger.info(caid);
        CinemaApply cinemaApply = cinemaApplyService.findByCaid(caid);
        logger.info(cinemaApply);
        cinemaApply.setCastate("未通过");
        cinemaApplyService.update(cinemaApply);
        return "redirect:/cinemaapplylisti.action";
    }

    @PostMapping("/updatecinemasave")
    public String updateCinemaSave(Cinema cinema){
        logger.info(cinema);
        cinemaService.update(cinema);
        Account account=accountService.findByCinemaid(cinema.getCinemaid());
        return "redirect:/accountprofile.action?aid="+account.getAid();
    }
}
