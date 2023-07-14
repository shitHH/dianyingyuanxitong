package com.wm.controller;

import com.mongodb.util.JSON;
import com.wm.po.Order;
import com.wm.po.Ticket;
import com.wm.service.*;
import com.wm.vo.OrderVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author km
 * 订单控制器
 */
@Controller
public class OrderController {

    Logger logger=Logger.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @Autowired
    TicketService ticketService;

    @Autowired
    MovieStallService movieStallService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    MoviesService moviesService;

    @PostMapping("/toconfrimorder")
    public String toconfrimorder(Order order, String seatlistStr, Model model,int seatnum){
        logger.info(order);
        logger.info(seatlistStr);
        String[]seatsarray=seatlistStr.split(" ");
        logger.info(seatsarray);
        logger.info(seatnum);

        List<Ticket> tickets=new ArrayList<>();
        for (String seat:seatsarray){
            Integer row=Integer.valueOf(seat.substring(0,1));
            Integer col=Integer.valueOf(seat.substring(2,3));
            Ticket ticket=new Ticket();
            ticket.setRow(row);
            ticket.setCol(col);
            tickets.add(ticket);
        }
        order.setMoney(seatnum*movieStallService.findByMsid(order.getMsid()).getMoney());
        model.addAttribute("tickets",tickets);
        model.addAttribute("moviestall",movieStallService.findVOByMsid(order.getMsid()));
        model.addAttribute("order",order);
        return "frontjsp/confrimorder";
    }

    @PostMapping("/orderangticketsave")
    public String orderangticketsave(Order order,String [] tickets,Model model){
        logger.info(order);
        logger.info(tickets);
        String orderNumber=String.valueOf(9988+System.currentTimeMillis()+(int)Math.random()*1000);
        order.setOrderNumber(orderNumber);
        List<Ticket> ticketlist=new ArrayList<>();
        for (String seat:tickets){
            Integer row=Integer.valueOf(seat.substring(0,1));
            Integer col=Integer.valueOf(seat.substring(2,3));
            Ticket ticket=new Ticket();
            ticket.setRow(row);
            ticket.setCol(col);
            ticketlist.add(ticket);
        }
        if (order!=null&&tickets!=null){

            orderService.insert(order);
            for (Ticket ticket:ticketlist){
                logger.info(ticket);
                ticket.setOid(orderService.findVOByOrderNumber(order.getOrderNumber()).getOid());
                ticketService.insert(ticket);
            }
        }
        model.addAttribute("order",orderService.findVOByOrderNumber(order.getOrderNumber()));
        model.addAttribute("tickets",ticketService.findByOid(orderService.findVOByOrderNumber(order.getOrderNumber()).getOid()));
        return "redirect:orderinfofront?oid="+orderService.findVOByOrderNumber(order.getOrderNumber()).getOid();
    }
    @GetMapping("/orderinfofront")
    public String orderinfofront(int oid,Model model){
        model.addAttribute("order",orderService.findVOByOid(oid));
        model.addAttribute("tickets",ticketService.findByOid(oid));
        return "frontjsp/orderinfo";
    }
    @GetMapping("/getticket")
    public String getticket(int oid,Model model){
        Order order=orderService.findByOid(oid);
        order.setTicketState("已取票");
        order.setOrderState("已完成");
        orderService.update(order);
        model.addAttribute("order",orderService.findVOByOid(oid));
        model.addAttribute("tickets",ticketService.findByOid(orderService.findVOByOrderNumber(order.getOrderNumber()).getOid()));
        return "redirect:orderlistown?aid="+order.getAid();
    }

    @GetMapping("/deleteorder")
    public String delete(int oid,Model model){
        Order order=orderService.findByOid(oid);
        order.setOrderState("已取消");
        orderService.update(order);
        model.addAttribute("order",orderService.findVOByOid(oid));
        model.addAttribute("tickets",ticketService.findByOid(orderService.findVOByOrderNumber(order.getOrderNumber()).getOid()));
        return "redirect:orderlistown?aid="+order.getAid();
    }

    @GetMapping("orderlistown")
    public String orderlistown(int aid,Model model){
        model.addAttribute("list",orderService.findVOByAid(aid));
        return "frontjsp/orderlist";
    }


    @GetMapping("/togetticket")
    public String togetticket(){
        return "frontjsp/getticket";
    }

    @GetMapping("/getticketperson")
    @ResponseBody
    public boolean getticketallperson(String orderNumber){
        logger.info(orderNumber);
        if (orderNumber==null||orderNumber==""){
            logger.info("单号为空");
            return false;
        }
        Order order=orderService.findByOrderNumber(orderNumber);
        if (order==null){
            logger.info("单号不存在");

            return false;
        }
        if (order.getOrderState().equals("已支付")&&order.getTicketState().equals("未取票")){
            logger.info("取到了");
            order.setTicketState("已取票");
            order.setOrderState("已完成");
            orderService.update(order);
            return true;
        }else {
            logger.info("单号无效");
            return false;
        }
    }

    @RequestMapping("/orderlistback")
    public String orderlistback(int type,int mid,int msid,int cinemaid,Model model){
        logger.info(type);
        logger.info(mid);
        logger.info(cinemaid);
        List<OrderVO> orderVOList=new ArrayList<>();
        List<Ticket> tickets=new ArrayList<>();
        Map<String,List> map=new HashMap<>();
        if (type==1){
            orderVOList=orderService.findVOAll();
        }else if (type==2){
            orderVOList=orderService.findVOByMsid(msid);
        }else if (type==3){
            orderVOList=orderService.findVOByMid(mid);
        }else if (type==4){
            orderVOList=orderService.findVOByCinemaid(cinemaid);
        }else if (type==5){
            orderVOList=orderService.findVOByMidAndCinemaid(mid,cinemaid);
        }
        for (OrderVO orderVO:orderVOList){
            tickets=ticketService.findByOid(orderVO.getOid());
            map.put(orderVO.getOrdernumber(),tickets);
        }
        model.addAttribute("list",orderVOList);
        model.addAttribute("map",map);
        model.addAttribute("cinemas",cinemaService.findVOAllCom());
        model.addAttribute("movies",moviesService.findAll());
        return "backjsp/orderlist";
    }

    @RequestMapping("/charset")
    @ResponseBody
    public Map<String, List> charSet(){
        logger.info("获得map容器");
        return orderService.findBar();
    }
}
