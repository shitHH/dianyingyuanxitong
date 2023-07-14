package com.wm.interceptor;

import com.wm.po.*;
import com.wm.service.*;
import com.wm.vo.AccountVo;
import com.wm.vo.ComplaintVO;
import com.wm.vo.MovieStallVO;
import com.wm.vo.MoviesVO;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class AllInterceptor implements HandlerInterceptor {

    Logger logger = Logger.getLogger(AllInterceptor.class);

    @Autowired
    MovieStallService movieStallService;

    @Autowired
    MoviesService moviesService;
    @Autowired
    AccountService accountService;
    @Autowired
    OrderService orderService;
    @Autowired
    ComplaintService complaintService;
    @Autowired
    CinemaApplyService cinemaApplyService;

    @Autowired
    MovieCommentService movieCommentService;

    @Autowired
    InvitationService invitationService;

    @Autowired
    ReplyService replyService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        Object obj=session.getAttribute("currentaccount");
        if (obj!=null){
            AccountVo accountVo=(AccountVo)obj;
            session.removeAttribute("currentaccount");
            session.setAttribute("currentaccount",accountService.findVOByAid(accountVo.getAid()));
        }
        List<ComplaintVO> complaintVOList=new ArrayList<>();
        List<CinemaApply> cinemaApplyList=new ArrayList<>();
        for (CinemaApply cinemaApply:cinemaApplyService.findAll()){
            if (cinemaApply.getCastate().equals("待审核")){
                cinemaApplyList.add(cinemaApply);
            }
        }
        for (ComplaintVO complaintVO:complaintService.findVOAll()){
            if (complaintVO.getCpState().equals("未反馈")){
                if (complaintVO.getReason().length()>20){
                    complaintVO.setReason(complaintVO.getReason().substring(0,20));
                }
                complaintVOList.add(complaintVO);
            }
        }
        session.setAttribute("complaintVOList",complaintVOList);
        session.setAttribute("cinemaApplyList",cinemaApplyList);
        List<MovieStall> list= movieStallService.findAll();
        if (list!=null){
            for (MovieStall movieStall:list){
                if (movieStall.getBeginTime().getTime()<System.currentTimeMillis() && !movieStall.getState().equals("已撤档")){
                    movieStall.setState("已开始");
                    movieStallService.update(movieStall);
                }
                if (movieStall.getEndTime().getTime()<System.currentTimeMillis() && !movieStall.getState().equals("已撤档")){
                    movieStall.setState("已结束");
                    movieStallService.update(movieStall);
                }
            }
        }

        //修改帖子的评论数
        List<Invitation> invitations = invitationService.findAll();
        for (Invitation invitation:invitations){
            List<Reply> list1 = replyService.findByIid(invitation.get_id().toString());
            invitation.setHotNumber(list1.size());
        }


        //对影片评分进行设定
        List<MoviesVO> list1 = moviesService.findByMoviereating();
        for (MoviesVO moviesVO:list1){
            List<MovieComment> movieComments = movieCommentService.findByMid(moviesVO.getMid());
            double score = moviesVO.getMovierating()/movieComments.size();
            Movies movies = moviesService.findByMid(moviesVO.getMid());
            movies.setScore(score);
            moviesService.update(movies);
        }


        List<Movies> moviesList = moviesService.findAll();
        if (moviesList!=null){
            for (Movies movies:moviesList){
                if (movies.getReleaseTime().getTime()<System.currentTimeMillis()){
                    movies.setMoviestate("正在热映");
                    moviesService.update(movies);
                }
            }
        }
        List<Order> orderList=orderService.findAll();
        if (orderList!=null){
            for (Order order:orderList){
                if (System.currentTimeMillis()>5*60*1000+order.getOrderTime().getTime()&&order.getOrderState().equals("待支付")){
                    order.setOrderState("已超时");
                    orderService.update(order);
                }
                if (order.getTicketState().equals("已取票")){
                    order.setOrderState("已完成");
                    orderService.update(order);
                }
            }
        }
        return true;
    }
}
