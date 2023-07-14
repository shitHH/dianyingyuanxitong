package com.wm.controller;

import com.wm.po.Account;
import com.wm.po.AccountState;
import com.wm.po.Cinema;
import com.wm.po.CinemaApply;
import com.wm.service.AccountService;
import com.wm.service.AccountStateService;
import com.wm.service.CinemaApplyService;
import com.wm.service.CinemaService;
import com.wm.util.DateAndTimeFormat;
import com.wm.util.UploadFile;
import com.wm.vo.AccountVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author cc
 * 账号控制器
 */
@Controller
public class AccountController {

    Logger logger = Logger.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    CinemaApplyService cinemaApplyService;

    @Autowired
    AccountStateService accountStateService;


    //准备注册
    @GetMapping("/toregist")
    public String toRegist() {
        logger.info("准备注册");
        return "frontjsp/regist";
    }

    //普通注册
    @PostMapping("/registsave")
    public String registSave(Account account,String birthdaystr) {
        logger.info(birthdaystr);
        logger.info("进入注册控制器.....");
        logger.info(account);
        Date birthday = DateAndTimeFormat.getDate1(birthdaystr);
        logger.info(birthday);
        account.setBirthday(birthday);
        accountService.add(account);
        return "redirect:/tologin.action";
    }

    //新增管理员
    @PostMapping("/addadminsave")
    public String addAdminSave(Account account) {
        logger.info("进入新增管理员控制器.....");
        logger.info(account);
        accountService.addAdmin(account);
        return "redirect:/accountlist.action";
    }

    @RequestMapping("/checktel")
    @ResponseBody
    public boolean checkTel(String tel) {
        logger.info("tel"+tel);
        Account account = accountService.findByTel(tel);
        boolean flag = (account == null) ? true : false;
        return flag;
    }



    @GetMapping("/tologin")
    public String toLogin(String pass,Model model) {
        logger.info("准备登录");
        model.addAttribute("pass",pass);
        return "frontjsp/login";
    }

    @PostMapping("/loginsave")
    public String loginSave(String name, String pass, HttpServletRequest request, HttpSession session, Model model) {
        logger.info(pass);
        logger.info(name);
        if (name.length() >= 7) {
            AccountVo accountVo = accountService.findVoByTelAndPass(name, pass);
            if (accountVo == null ){
                request.setAttribute("mess", "账号或密码有误");
                return "frontjsp/login";
            }
            if(accountVo.getRid()==3 ||accountVo.getRid()==5){
                session.setAttribute("currentaccount", accountVo);
                return "redirect:/backindex.action";
            }else {
                session.setAttribute("currentaccount", accountVo);
                return "redirect:/index.action";
            }
        } else {
            int aid = Integer.valueOf(name);
            AccountVo accountVo = accountService.findVoByAidAndPass(aid, pass);
            if (accountVo == null ){
                request.setAttribute("mess", "账号或密码有误");
                return "frontjsp/login";
            }
            if(accountVo.getRid()==3 ||accountVo.getRid()==5){
                session.setAttribute("currentaccount", accountVo);
                return "redirect:/backindex.action";
            }else {
                session.setAttribute("currentaccount", accountVo);
                return "redirect:/index.action";
            }
        }
    }

    @GetMapping("/toforget")
    public String toForget() {
        logger.info("找密码");
        return "frontjsp/forget";
    }

    @RequestMapping("/forgetsave")
    public String forgetSave(String tel,HttpServletRequest request){
        logger.info(tel);
        Account account=accountService.findByTel(tel);
        if(account!=null){
            String pass=account.getPass();
            request.setAttribute("pass",pass);
            return "redirect:/tologin.action?pass="+pass;
        }else{
            request.setAttribute("pass","未找到密码");
            return "frontjsp/forget";
        }
    }

    @GetMapping("/accountlist")
    public String accountList(Model model){
        logger.info("账号列表");
        List<AccountVo> list=accountService.findVoAll();
        logger.info(list.size());
        model.addAttribute("list",list);
        return "backjsp/accountlist";
    }

    @RequestMapping("/accountprofile")
    public String accountProfile(int aid,Model model){
        Account account=accountService.findByAid(aid);
        model.addAttribute("account",account);
        int cinemaid=account.getCinemaid();
        Cinema cinema=cinemaService.findByCinemaid(cinemaid);
        model.addAttribute("cinema",cinema);
        int caid=cinema.getCaid();
        CinemaApply cinemaApply=cinemaApplyService.findByCaid(caid);
        model.addAttribute("cinemaapply",cinemaApply);
        List<AccountState> list=accountStateService.findAll();
        model.addAttribute("list",list);
        return "backjsp/accountprofile";
    }

    @PostMapping("/updateaccountsave")
    public String updateAccountSave(Account account){
        logger.info(account.getAid());
        accountService.update(account);
        if(account.getRid()==3 || account.getRid()==5){
            CinemaApply cinemaApply=cinemaApplyService.findByCaid(cinemaService.findByCinemaid(account.getCinemaid()).getCaid());
            cinemaApply.setCtel(account.getTel());
            cinemaApplyService.update(cinemaApply);
            return "redirect:/accountprofile.action?aid="+account.getAid();
        }

        return "redirect:/frontaccount.action?aid="+account.getAid();

    }
    @PostMapping("/updateaccountheadshot")
    public String updateAccountheadshot(@RequestParam(value = "headshotaddress") MultipartFile file,int aid){
        Account account=accountService.findByAid(aid);
        logger.info(account.getAid());
        String headshotaddress=UploadFile.uploadfile(file);
        account.setHeadshotaddress(headshotaddress);
        accountService.update(account);
        return "redirect:/frontaccount.action?aid="+account.getAid();

    }

    @GetMapping("/exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "redirect:/index.action";
    }

    //前台
    @RequestMapping("/frontaccount")
    public String frontAccount(int aid, Model model){
        logger.info("进入个人信息展示控制器....");
        Account account=accountService.findByAid(aid);
        model.addAttribute("account",account);
        return "frontjsp/frontaccount";
    }

    @GetMapping("/toaddadmin")
    public String toAddAdmin(){
        logger.info("准备进入新增管理员");
        return "backjsp/addaccount";
    }

    @GetMapping("/adminlist")
    public String findadmin(Model model){
        logger.info("所有管理员列表");
        List<AccountVo> list = accountService.findVoByRid1();
        model.addAttribute("list",list);
        return "backjsp/accountlist";
    }
}











