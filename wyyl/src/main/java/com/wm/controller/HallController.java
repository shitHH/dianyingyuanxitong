package com.wm.controller;

import com.wm.po.Hall;
import com.wm.po.HallType;
import com.wm.service.HallService;
import com.wm.service.HallTypeService;
import com.wm.vo.HallVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bilie
 * 影厅的控制器
 */
@Controller
public class HallController {

    Logger logger = Logger.getLogger(HallController.class);

    @Autowired
    HallService hallService;

    @Resource
    HallTypeService hallTypeService;

    @GetMapping("/halllist")
    public String hallList(int cinemaid, Model model){
        logger.info("进入影厅列表");
        List<HallVO> list = hallService.findVOByCinemaid(cinemaid);
        model.addAttribute("list",list);
        return "backjsp/halllist";
    }

    @GetMapping("/toaddhall")
    public String toaddhall(Model model){
        List<HallType> list = hallTypeService.findAll();
        logger.info("去添加影厅页面");
        model.addAttribute("list",list);
        return "backjsp/addhall";
    }

    @PostMapping("/addhall")
    public String addhall(Hall hall){
        logger.info("添加影厅");
        hall.setHallState("空闲中");
        hallService.add(hall);
        return "redirect:/halllist?cinemaid="+hall.getCinemaid();
    }

    @GetMapping("/toedithall")
    public String toedithall(int hid,Model model){
        logger.info("去修改影厅页面");
        HallVO hallVO = hallService.findVOByHid(hid);
        List<HallType> list = hallTypeService.findAll();
        model.addAttribute("list",list);
        model.addAttribute("hallVO",hallVO);
        return "backjsp/edithall";
    }

    @PostMapping("/edithall")
    public String edithall(Hall hall){
        logger.info("修改影厅");
        logger.info(hall);
        hallService.update(hall);

        return "redirect:/halllist?cinemaid="+hall.getCinemaid();
    }

}
