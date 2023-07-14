package com.wm.interceptor;

import com.wm.vo.AccountVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author km
 */
@Component
public class LoginStateInterceptor implements HandlerInterceptor {

    Logger logger = Logger.getLogger(LoginStateInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("进入登录状态验证拦截器。。");
        HttpSession session=request.getSession();
        Object object=session.getAttribute("currentaccount");
        if (object!=null){
            logger.info("已登录。。。");
            AccountVo accountVO=(AccountVo)object;
            logger.info(accountVO.getAname());
            logger.info(accountVO.getAid());
            return true;
        }else {
            logger.info("未登录，先去登陆");
        }
        response.sendRedirect(request.getContextPath()+"/tologin.action");
        return false;

    }
}
