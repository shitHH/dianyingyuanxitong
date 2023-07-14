package com.wm.util;

import com.wm.interceptor.BackManagerInterceptor;
import com.wm.interceptor.CinemaManagerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author bilie
 * 用来配置储存文件的路径
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    BackManagerInterceptor backInterceptor;

    @Autowired
    CinemaManagerInterceptor frontInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //文件磁盘图片url 映射
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler("/dir/*").addResourceLocations("file:D:\\dir\\");
    }

}
