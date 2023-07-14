package com.wm.controller;

import com.wm.po.Account;
import com.wm.po.Collect;
import com.wm.po.MovieComment;
import com.wm.po.Movies;
import com.wm.service.CollectService;
import com.wm.service.LikeService;
import com.wm.service.MovieCommentService;
import com.wm.service.MoviesService;
import com.wm.vo.AccountVo;
import com.wm.vo.MovieCommentVO;
import com.wm.vo.MoviesVO;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author awei
 * 影评控制器
 */
@Controller
public class MovieCommentController {

    Logger logger = Logger.getLogger(MovieCommentController.class);

    @Autowired
    MovieCommentService movieCommentService;

    @Autowired
    MoviesService moviesService;
    @Autowired
    CollectService collectService;

    @Autowired
    LikeService likeService;

    //查看当前登录人的影评（前台用户功能）
    @GetMapping("/tomymoviecommentlist")
    public String toMyMovieCommentList(int aid, Model model, HttpSession session) {
        logger.info("查看我的影评控制器");
        List<MovieCommentVO> mymovieCommentlist = movieCommentService.findByAidVO(aid);
        logger.info(mymovieCommentlist);
        model.addAttribute("mymovieCommentlist", mymovieCommentlist);
        Object obj = session.getAttribute("currentaccount");
        logger.info("obj=" + obj);
        if (obj == null) {
            return "backjsp/moviecommentlist";
        } else {
            AccountVo accountVo = (AccountVo) obj;
            logger.info("accountVo=" + accountVo);
            Map<Integer, Boolean> likemap = new HashMap<>();
            List<MovieCommentVO> list = movieCommentService.findAllVO();
            if (list != null) {
                for (MovieCommentVO movieCommentVO : list) {
                    if (likeService.findBymcidAndaid(movieCommentVO.getMcid(), accountVo.getAid()) == null) {
                        likemap.put(movieCommentVO.getMcid(), false);
                    } else {
                        likemap.put(movieCommentVO.getMcid(), true);
                    }
                }
                logger.info(likemap);
                model.addAttribute("likemap", likemap);
            }

        }

        return "frontjsp/mymoviecommentlist";
    }


    //查看该电影下的所有影评
    @GetMapping("tomoviecommentlistbymovie")
    public String toMovieCommentListByMovie(int mid, Model model) {
        logger.info("查看电影下的所有影评");
        List<MovieCommentVO> list = movieCommentService.findByMidVO(mid);
        MoviesVO movies = moviesService.findVOByMid(mid);
        logger.info(list.size());
        model.addAttribute("list", list);
        model.addAttribute("movies", movies);
        model.addAttribute("collects", collectService.findByMid(mid).size());



        return "backjsp/moviecommentlist";
    }

    //影评详情（后台功能）
    @GetMapping("/moviecommentinfo")
    public String movieCommentInfo(int mcid, Model model) {
        logger.info("进入到影评详情页面");
        MovieCommentVO movieCommentVO = movieCommentService.findByMcidVO(mcid);
        logger.info(movieCommentVO);
        model.addAttribute("movieCommentVO", movieCommentVO);
        return "backjsp/moviecommentinfo";
    }

    //添加电影评论（前台用户功能）
    @GetMapping("toaddmoviecomment")
    public String toAddMovieComment(Integer mid, Model model) {
        logger.info("去添加影评控制器");
        List<MovieCommentVO> list = movieCommentService.findByMidVO(mid);
        logger.info(list);
        model.addAttribute("mid", mid);
        model.addAttribute("list", list);
        return "frontjsp/addmoviecomment";
    }

    @PostMapping("addsavemoviecomment")
    public String addSaveMovieComment(MovieComment movieComment) {
        int mid = movieComment.getMid();
        logger.info(movieComment.getAid());
        logger.info("进入到影评添加控制器");
        logger.info(movieComment.getMovierating());
        boolean flag = movieCommentService.add(movieComment);
        logger.info(flag);
        return "redirect:/movieinfo.action?mid=" + mid;
    }

    //删除当前登录人的影评（前台用户功能）
    @GetMapping("deletemymoviecomment")
    public String deleteMyMovieComment(int mcid, HttpSession session, HttpServletRequest request) {
        logger.info("删除我的影评控制器");
        session = request.getSession();
        Object obj = session.getAttribute("currentaccount");
        AccountVo account = (AccountVo) obj;
        int[] array = {mcid};
        boolean flag = movieCommentService.delete(array);
        logger.info(flag);
        return "redirect:/tomymoviecommentlist?aid=" + account.getAid();
    }


}
