package com.wm.controller;

import com.wm.po.Complaint;
import com.wm.service.CinemaService;
import com.wm.service.ComplaintService;
import com.wm.vo.CinemaVO;
import com.wm.vo.ComplaintVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 投诉控制器实体类
 * @author ss
 */

@Controller
public class ComplaintController {

    //查看所有投诉
    Logger logger = Logger.getLogger(ComplaintController.class);

    @Autowired
    ComplaintService complaintService;

    @Autowired
    CinemaService cinemaService;

    //进入投诉建议界面控制单元
    @RequestMapping("/tocomplaint")
    public String tocomplaint(Model model){
        logger.info("进入投诉建议界面");
        List<CinemaVO> list=cinemaService.findVOAllCom();
        logger.info(list);
        model.addAttribute("list",list);
        return "frontjsp/complaint";
    }

    //新增投诉
    @PostMapping("/addcomplaint")
    private String addcomplaint(Complaint complaint){
        logger.info("新增投诉");
        logger.info(complaint);
        complaintService.insert(complaint);
        return "redirect:/index.action";
    }

    @GetMapping("/complaintlist")
    public String complaintList(Model model){
        logger.info("投诉列表");
        List<ComplaintVO> list=complaintService.findVOAll();
        logger.info(list.size());
        model.addAttribute("list",list);
        return "backjsp/complaintlist";
    }
    @GetMapping("/complaintlistn")
    public String complaintListn(Model model){
        logger.info("投诉列表");
        List<Complaint> list=complaintService.findByCpstate("未反馈");
        logger.info(list.size());
        model.addAttribute("list",list);
        return "backjsp/complaintlist";
    }
    @GetMapping("/complaintlista")
    public String complaintLista(Model model){
        logger.info("投诉列表");
        List<Complaint> list=complaintService.findByCpstate("已反馈");
        logger.info(list.size());
        model.addAttribute("list",list);
        return "backjsp/complaintlist";
    }

    @GetMapping("/complaintinfo")
    public String complaintInfo(int cpid,Model model){
        logger.info(cpid);
        ComplaintVO complaint=complaintService.findVOByCpid(cpid);
        logger.info(complaint);
        model.addAttribute("complaint",complaint);
        return "backjsp/complaintinfo";
    }

    @PostMapping("/updatecomplaint")
    public String updatecomplaint(int cpid){
        logger.info(cpid);
        Complaint complaint=complaintService.findByCpid(cpid);
        complaint.setCpState("已反馈");
        complaintService.update(complaint);
        return "redirect:/complaintlistn.action";
    }
}
