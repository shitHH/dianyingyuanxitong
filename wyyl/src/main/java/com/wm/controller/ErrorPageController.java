package com.wm.controller;

import com.wm.vo.AccountVo;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ErrorPageController implements ErrorController {
    public static  final String ERROR_PATH="/error";

    @RequestMapping(ERROR_PATH)
    public String error(HttpSession session){
        Object obj=session.getAttribute("currentaccount");
        if (obj!=null){
            AccountVo accountVo=(AccountVo)obj;
            if (accountVo.getRid()==3||accountVo.getRid()==5){
                return "backjsp/error404";
            }else{
                return "frontjsp/error404";
            }
        }else {
            return "frontjsp/error404";
        }
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
