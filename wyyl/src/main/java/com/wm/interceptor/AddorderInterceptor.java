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
public class AddorderInterceptor implements HandlerInterceptor {

    Logger logger = Logger.getLogger(AddorderInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("进入提交订单拦截器");
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("currentaccount");
        if (obj!=null){
            AccountVo accountVo = (AccountVo) obj;
            if (accountVo.getRid()==5||accountVo.getRid()==3){
                logger.info("权限不足");
                response.sendRedirect(request.getContextPath()+"/tologin.action");
                return false;
            }else{
                return true;
            }
        }else {
            logger.info("未登陆");
        }
        response.sendRedirect(request.getContextPath()+"/tologin.action");
        return false;
    }
}
