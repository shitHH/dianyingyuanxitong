package com.wm.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author km
 * 拦截器管理配置类
 */
@Configuration
public class InterceptorManagerConfig implements WebMvcConfigurer {
    @Autowired
    AllInterceptor allInterceptor;

    @Autowired
    BackManagerInterceptor backmanagerInterceptor;

    @Autowired
    CinemaManagerInterceptor cinemaManagerInterceptor;
    @Autowired
    LoginStateInterceptor loginStateInterceptor;
    @Autowired
    BackInterceptor backInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] all = {"/*"};
        String[] back = {"/*backindex*","/*moviestalllist*","/*orderlistback*"};
        String[] cinemamanagers= {"/*hall*","/*addmoviestall*","/*toupdatemoviestall*"};//
        String[] backmangagers = {"/*admin*","/*accountlist*","/*cinemaapplylist*","/*complaintlist*","/*complaintinfo*","/*updatecomplaint*","/*role*"};
        String[] login={"/*exit*","/*account*","/*deletemoviecomment*","/*pay","/*payment*/*","/*attention*","/*collect*","/*complaint*","/*contact*","/*savemoviecomment*","/*order*","/*like*","/*add*reply","/*save*reply*","/*addinvitation*"};
        registry.addInterceptor(allInterceptor).addPathPatterns(all);
        registry.addInterceptor(cinemaManagerInterceptor).addPathPatterns(cinemamanagers);
        registry.addInterceptor(backmanagerInterceptor).addPathPatterns(backmangagers);
        registry.addInterceptor(loginStateInterceptor).addPathPatterns(login);
        registry.addInterceptor(backInterceptor).addPathPatterns(back);
    }
}
