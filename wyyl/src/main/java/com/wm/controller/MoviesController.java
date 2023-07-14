package com.wm.controller;

import com.wm.po.*;
import com.wm.service.*;
import com.wm.util.DateAndTimeFormat;
import com.wm.util.UploadFile;
import com.wm.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bilie
 * 影片的控制器
 */
@Controller
public class MoviesController {

    Logger logger = Logger.getLogger(MoviesController.class);

    @Autowired
    MoviesService moviesService;

    @Autowired
    MovieCommentService movieCommentService;
    @Autowired
    CreationService creationService;

    @Autowired
    FramerService framerService;

    @Autowired
    MovieTypeService movieTypeService;
    @Autowired
    CollectService collectService;

    @Autowired
    LikeService likeService;

    @Autowired
    ReplyService replyService;

    @GetMapping("/movieslist")
    public String movieslist(Model model, HttpServletRequest request) {
        List<MoviesVO> list = moviesService.findVOAll();
        model.addAttribute("list", list);
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("currentaccount");
        if (obj == null) {
            return "frontjsp/movieslist";
        } else {
            AccountVo accountVo = (AccountVo) obj;
            if (accountVo.getRid() == 3 || accountVo.getRid() == 5) {
                return "backjsp/movieslist";
            } else {
                Map<Integer, Boolean> collectmap = new HashMap<>();
                for (MoviesVO moviesVO : list) {
                    if (collectService.findByMidAndAid(moviesVO.getMid(), accountVo.getAid()) == null) {
                        collectmap.put(moviesVO.getMid(), false);
                    } else {
                        collectmap.put(moviesVO.getMid(), true);
                    }
                }
                logger.info(collectmap);
                model.addAttribute("collectmap", collectmap);
                return "frontjsp/movieslist";
            }
        }
    }

    @GetMapping("/hotmovieslist")
    public String hotmovieslist(Model model, HttpSession session) {
        logger.info("展示所有正在热映的影片");
        List<MoviesVO> list = new ArrayList<>();
        List<MoviesVO> moviesVOS = moviesService.findVOAll();
        for (MoviesVO moviesVO : moviesVOS) {
            if (moviesVO.getMoviestate().equals("正在热映")) {
                list.add(moviesVO);

            }
        }
        model.addAttribute("list", list);
        Object obj = session.getAttribute("currentaccount");
        if (obj == null) {
            return "frontjsp/movieslist";
        } else {
            AccountVo accountVo = (AccountVo) obj;
            Map<Integer, Boolean> collectmap = new HashMap<>();
            for (MoviesVO moviesVO : list) {
                if (collectService.findByMidAndAid(moviesVO.getMid(), accountVo.getAid()) == null) {
                    collectmap.put(moviesVO.getMid(), false);
                } else {
                    collectmap.put(moviesVO.getMid(), true);
                }
            }
            logger.info(collectmap);
            model.addAttribute("collectmap", collectmap);
        }
        return "frontjsp/movieslist";
    }

    @GetMapping("/upcomingmovieslist")
    public String upcomingmovieslist(Model model, HttpSession session) {
        logger.info("展示所有正在热映的影片");
        List<MoviesVO> list = new ArrayList<>();
        List<MoviesVO> moviesVOS = moviesService.findVOAll();
        for (MoviesVO moviesVO : moviesVOS) {
            if (moviesVO.getMoviestate().equals("即将上映")) {
                list.add(moviesVO);
            }
        }
        model.addAttribute("list", list);
        Object obj = session.getAttribute("currentaccount");
        if (obj == null) {
            return "frontjsp/movieslist";
        } else {
            AccountVo accountVo = (AccountVo) obj;
            Map<Integer, Boolean> collectmap = new HashMap<>();
            for (MoviesVO moviesVO : list) {
                if (collectService.findByMidAndAid(moviesVO.getMid(), accountVo.getAid()) == null) {
                    collectmap.put(moviesVO.getMid(), false);
                } else {
                    collectmap.put(moviesVO.getMid(), true);
                }
            }
            logger.info(collectmap);
            model.addAttribute("collectmap", collectmap);
        }


        return "frontjsp/movieslist";
    }

    /**
     * 根据影片类型展示该类型下的影片
     *
     * @param mtid  影片类型编号
     * @param model
     * @return 该类型下的影片集合
     */
    @GetMapping("/moviestypelist")
    public String moviestypelist(int mtid, Model model) {
        logger.info("展示该类型的影片");
        List<MoviesVO> list = moviesService.findVOByMtid(mtid);
        model.addAttribute("list", list);
        return "frontjsp/movieslist";
    }

    @GetMapping("/movieinfo")
    public String movieinfo(int mid, Model model, HttpSession session) {
        logger.info("展示影片的详细信息");
        MoviesVO moviesVO = moviesService.findVOByMid(mid);
        List<MovieCommentVO> commentVOList = movieCommentService.findByMidVO(mid);
        List<FramerVO> list = new ArrayList<>();
        List<Creation> creations = creationService.findByMid(mid);
        for (Creation creation : creations) {
            FramerVO framerVO = framerService.findVOByFid(creation.getFid());
            list.add(framerVO);
        }
        Map<Integer,List<Reply>> commentVOMap = new HashMap<>();
        for (MovieCommentVO movieCommentVO:commentVOList){
            commentVOMap.put(movieCommentVO.getMcid(), replyService.findByMcid(movieCommentVO.getMcid()));
        }
        logger.info(list.size());
        model.addAttribute("list", list);
        model.addAttribute("movie", moviesVO);
        model.addAttribute("commentVOList", commentVOList);
        model.addAttribute("commentVOMap",commentVOMap);
        Object obj = session.getAttribute("currentaccount");
        logger.info(obj);
        if (obj == null) {
            return "frontjsp/movieinfo";
        } else {
            AccountVo accountVo = (AccountVo) obj;
            int aid = accountVo.getAid();
            logger.info(aid);
            logger.info(accountVo);
            if (collectService.findByMidAndAid(mid, aid) == null) {
                logger.info("false");
                logger.info("mid=" + mid);
                logger.info("aid=" + accountVo.getAid());
                model.addAttribute("moviecollectstate", false);
            } else {
                logger.info("true");
                model.addAttribute("moviecollectstate", true);
            }

            //该影片下的所有影评 点赞功能
            logger.info("obj=" + obj);
            if (obj == null) {
                return "backjsp/moviecommentlist";
            } else {
                logger.info("accountVo=" + accountVo);
                Map<Integer, Boolean> likemap = new HashMap<>();
                //通过影片编号查询该影片下的所有影评(上方已有该功能)
                if (commentVOList != null) {
                    for (MovieCommentVO movieCommentVO : commentVOList) {

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

            return "frontjsp/movieinfo";
        }
    }

    @GetMapping("/toaddmovie")
    public String toaddmovie(Model model) {
        logger.info("去上架新的电影");
        List<MovieType> list = movieTypeService.findAll();
        model.addAttribute("list", list);
        return "backjsp/addmovie";
    }

    @PostMapping("/addmovie")
    public String addmovie(@RequestParam(value = "oldcoveraddress") MultipartFile oldcoveraddress,
                           @RequestParam(value = "oldpreviewaddress") MultipartFile oldpreviewaddress, Movies movies, String release) {
        logger.info("添加新的影片");
        logger.info(oldcoveraddress.getName());
        logger.info(oldpreviewaddress.getName());
        logger.info(release);
        Timestamp releaseTime = DateAndTimeFormat.dateTime_Lacal(release);
        movies.setReleaseTime(releaseTime);
        String newCoveraddress = UploadFile.uploadfile(oldcoveraddress);
        String newPreviewaddress = UploadFile.uploadfile(oldpreviewaddress);
        movies.setCoveraddress(newCoveraddress);
        movies.setPreviewaddress(newPreviewaddress);
        moviesService.insert(movies);
        return "redirect:/movieslist.action";
    }

    @GetMapping("/toeditmovie")
    public String toeditmovie(int mid, Model model) {
        MoviesVO moviesVO = moviesService.findVOByMid(mid);
        List<MovieType> list = movieTypeService.findAll();
        model.addAttribute("list", list);
        model.addAttribute("moviesVO", moviesVO);
        return "backjsp/editmovie";
    }

    @PostMapping("/editmovie")
    public String editmovie(int mid, String director, int mtid, String release) {
        logger.info("完成修改影片业务");
        Timestamp releaseTime = DateAndTimeFormat.dateTime_Lacal(release);
        Movies movies = moviesService.findByMid(mid);
        movies.setDirector(director);
        movies.setMtid(mtid);
        movies.setReleaseTime(releaseTime);
        moviesService.update(movies);
        return "redirect:/movieslist.action";
    }

}
