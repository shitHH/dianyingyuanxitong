package com.wm.controller;

import com.wm.po.*;
import com.wm.service.*;
import com.wm.util.DateAndTimeFormat;
import com.wm.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author km
 * 影片档期控制器
 *
 */
@Controller
public class MovieStallController {
    Logger logger=Logger.getLogger(MovieStallController.class);
    @Autowired
    MovieStallService movieStallService;
    @Autowired
    HallService hallService;
    @Autowired
    CinemaService cinemaService;
    @Autowired
    MoviesService moviesService;
    @Autowired
    OrderService orderService;
    @Autowired
    TicketService ticketService;
    @GetMapping("/toaddmoviestall")
    public String toaddmoviestall(int cinemaid,Model model){
        logger.info("进入添加档期跳转域控制器。。。");
        List<HallVO> hallVOS=new ArrayList<>();
        for (HallVO hallVO:hallService.findVOByCinemaid(cinemaid)){
            if (hallVO.getHallState().equals("空闲中")){
                hallVOS.add(hallVO);
            }
        }
        logger.info(hallVOS);
        List<Movies> movies=moviesService.findByMovieState("正在热映");
        model.addAttribute("movies",movies);
        model.addAttribute("halls",hallVOS);
        return "backjsp/addmoviestall";
    }

    @PostMapping("/addmoviestallsave")
    public String addmoviestallsave(MovieStall movieStall,String date,String time,Model model){
        logger.info(movieStall);
        logger.info(date);//4 October, 2022
        logger.info(time);//12:30 PM
        Hall hall= hallService.findById(movieStall.getHid());
        model.addAttribute("movies",moviesService.findByMovieState("正在热映"));
        model.addAttribute("halls",hallService.findVOByCinemaid(hall.getCinemaid()));
        Timestamp beginTime=DateAndTimeFormat.getTimestamp(date, time);
        if (beginTime.getTime()<System.currentTimeMillis()+2*60*60*1000){
            model.addAttribute("mess","请在影片开场2小时前添加！");
            return "backjsp/addmoviestall";
        }
        for (MovieStallVO movieStallVO :movieStallService.findByHid(movieStall.getHid())){
            logger.info(movieStallVO);
            if (beginTime.getTime()>movieStallVO.getBeginTime().getTime()-beginTime.getTime()-30*60*1000&&beginTime.getTime()<movieStallVO.getEndTime().getTime()+30*60*1000){
                if (movieStallVO.getState().equals("已撤档")){
                    movieStall.setBeginTime(beginTime);
                    movieStallService.insert(movieStall);

                    return "redirect:/moviestalllist?type=3&cinemaid="+hall.getCinemaid()+"&mid=0";
                }
                model.addAttribute("mess","当前时间段该影厅已被占用,请重新选择！");
                return "backjsp/addmoviestall";
            }
        }
        if (!hall.getHallState().equals("空闲中")){
            logger.info(hall);
            model.addAttribute("mess","该影厅暂不可用,请重新选择！");
            return "backjsp/addmoviestall";
        }
        movieStall.setBeginTime(beginTime);
        movieStallService.insert(movieStall);

        return "redirect:/moviestalllist?type=3&cinemaid="+hall.getCinemaid()+"&mid=0";
    }

    @RequestMapping("/moviestalllist")
    public String moviestalllist(int type,int cinemaid,int mid,Model model){
        List<MovieStallVO> list=new ArrayList<>();
        if (type==1){
            list=movieStallService.findVOAll();
        }else if (type==3) {
           list=movieStallService.findVOByCinemaid(cinemaid);
        }else if (type==2){
            list=movieStallService.findVOByMidAndCinemaid(cinemaid, mid);
        }
        model.addAttribute("list",list);
        model.addAttribute("cinemas",cinemaService.findVOAllCom());
        model.addAttribute("movies",moviesService.findAll());
        return "backjsp/moviestalllist";
    }
    @GetMapping("/toupdatemoviestall")
    public String toupdatemoviestall(int msid){
        MovieStall movieStall=movieStallService.findByMsid(msid);
        Hall hall= hallService.findById(movieStall.getHid());
        movieStall.setState("已撤档");
        for (Order order:orderService.findByMsid(msid)){
            order.setOrderState("已取消");
            orderService.update(order);
        }
        movieStallService.update(movieStall);

        return "redirect:/moviestalllist?type=3&cinemaid="+hall.getCinemaid()+"&mid=0";
    }

    @RequestMapping("/tomoviestall")
    public String tomoviestall(int mid,Model model,String date){
        logger.info(date);
        logger.info(mid);
        model.addAttribute("datelist",DateAndTimeFormat.getDate());
        if (date.equals("")||date==null){
            date=DateAndTimeFormat.getDate().get(0);
            logger.info(date);
        }
        logger.info(date);
        List<MovieStallVO> cinemalist=movieStallService.findVOByMidOnly(mid);
        List<MovieStallVO> movieStallVOS=new ArrayList<>();
        Map<String,List<MovieStallVO>> moviestallmap=new HashMap<>();

        for (MovieStallVO movieStallVO1:cinemalist){
                for (MovieStallVO movieStallVO:movieStallService.findVOByMidAndCinemaid(movieStallVO1.getCinemaid(),mid)){
                    String movieStallVOBeginTimeStr=movieStallVO.getBeginTime().toString();
                    if (movieStallVO.getState().equals("即将开始")&&movieStallVOBeginTimeStr.substring(0,movieStallVOBeginTimeStr.indexOf(" ")).equals(date)){
                        movieStallVOS.add(movieStallVO);
                    }
                }
                moviestallmap.put(movieStallVO1.getCname(),movieStallVOS);
        }

        model.addAttribute("cinemalist",cinemalist);
        model.addAttribute("moviestallmap",moviestallmap);
        model.addAttribute("mid",mid);
        model.addAttribute("dd",date);
        return "frontjsp/moviestall";
    }

    @GetMapping("/tomoviestead")
    public String tomoviestead(int msid,Model model){
        logger.info(msid);
        List<OrderVO> orderVOS= new ArrayList<>();
        List<Ticket> tickets= new ArrayList<>();
        for (OrderVO orderVO:orderService.findVOByMsid(msid)){
            if (orderVO.getOrderstate().equals("已完成")||orderVO.getOrderstate().equals("已支付")||orderVO.getOrderstate().equals("待支付")){
                List<Ticket> ticketList=ticketService.findByOid(orderVO.getOid());
                logger.info(ticketList);
                for (Ticket ticket:ticketList){
                    tickets.add(ticket);
                }
            }
        }
        logger.info(tickets);
        MovieStallVO  movieStallVO=movieStallService.findVOByMsid(msid);
        String msdate=movieStallVO.getBeginTime().toString().substring(0,movieStallVO.getBeginTime().toString().indexOf(" "));
        model.addAttribute("tickets",tickets);
        model.addAttribute("moviestall",movieStallVO);
        model.addAttribute("nowtime",new Date());
        model.addAttribute("msdate",msdate);
        return "frontjsp/moviestallseat";
    }
}
