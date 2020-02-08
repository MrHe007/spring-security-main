package com.bigguy.spring.config;

import com.bigguy.spring.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/8
 **/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bigguy.spring"
        ,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
@Slf4j
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     * addInterceptor方法指定自定义拦截器对象
     * addPathPatterns方法指定哪些请求经过拦截器
     * excludePathPatterns方法指定哪些请求放行
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/static/login.html","/static/js/**","/userLogin");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    /**
     * 配置commons-upload上传
     */
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        //设置限制上传大小
        resolver.setMaxUploadSize(104857600);
        //设置编码
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    /**
     * 配置默认的视图解析器
     * 现在先不配置
     */
//    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        //如果页面需要使用JSTL标签库
        //viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

}
