package com.bigguy.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/8
 **/
@Configuration
@ComponentScan(basePackages = "com.bigguy.spring"
        ,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class AppConfig {

    //在此配置除了Controller的其它bean，比如：数据库链接池、事务管理器、业务bean等。

}
