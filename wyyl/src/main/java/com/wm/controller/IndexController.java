package com.wm.controller;

import com.wm.po.Cinema;
import com.wm.po.Order;
import com.wm.service.AccountService;
import com.wm.service.CinemaService;
import com.wm.service.MoviesService;
import com.wm.service.OrderService;
import com.wm.vo.AccountVo;
import com.wm.vo.CinemaVO;
import com.wm.vo.MoviesVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    Logger logger=Logger.getLogger(IndexController.class);

    @Autowired
    MoviesService moviesService;
    @Autowired
    OrderService orderService;
    @Autowired
    CinemaService cinemaService;
    @Autowired
    AccountService accountService;
    @GetMapping("/index")
    public String toindex(Model model){
        List<MoviesVO> list = moviesService.findVOAll();
        model.addAttribute("list",list);
        return "frontjsp/index";
    }


    @GetMapping("/backindex")
    public String backIndex(Model model, HttpSession session){
        Object obj=session.getAttribute("currentaccount");
        if (obj==null) {
            return "tologin";
        }
        AccountVo accountVo=(AccountVo)obj;
        if (accountVo.getRid()!=3&&accountVo.getRid()!=5){
            return "tologin";
        }
        List<Order> orderList=new ArrayList<>();
        double money=0;
        for (Order order: orderService.findAll()){
            if (order.getOrderState().equals("已完成")){
                money+= order.getMoney();
                orderList.add(order);
            }
        }
        model.addAttribute("ordernum",orderList.size());
        model.addAttribute("money",money);
        model.addAttribute("cinemanum",cinemaService.findAll().size());
        model.addAttribute("usernum",accountService.findAll().size());
        logger.info("进入后端界面");
        return "backjsp/index";

    }

    @GetMapping("/tocontact")
    public String tocomplaint(Model model){
        logger.info("进入投诉建议界面");
        List<CinemaVO> list=cinemaService.findVOAllCom();
        logger.info(list);
        model.addAttribute("list",list);
        return "frontjsp/complaint";
    }
    @GetMapping("/paysuccess")
    public String paysuccess(HttpSession session){
        Object obj=session.getAttribute("oid");
        String merchantOrderId=(String)obj;
        Order order=orderService.findByOid(Integer.valueOf(merchantOrderId));
        order.setOrderState("已支付");
        order.setTicketState("未取票");
        orderService.update(order);
        return "index";
    }
}
