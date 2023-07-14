package com.wm.interceptor;

import com.wm.vo.AccountVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author bilie
 * 前端页面的拦截器
 */
@Component
public class CinemaManagerInterceptor implements HandlerInterceptor {

    Logger logger = Logger.getLogger(CinemaManagerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("进入影院管理拦截器。。");
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("currentaccount");
        if (obj!=null){
            AccountVo accountVo = (AccountVo) obj;
            if (accountVo.getRid()==3){
                return true;
            }else {
                logger.info("账号种类不匹配");
                response.sendRedirect(request.getContextPath()+"/tologin.action");
                return false;
            }
        }else {
            logger.info("前端未登录");
        }
        response.sendRedirect(request.getContextPath()+"/tologin.action");
        return false;
    }
}
