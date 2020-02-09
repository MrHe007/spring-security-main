package com.bigguy.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/9
 **/
@RestController
@Slf4j
public class CommonController {

    @GetMapping("healthCheck")
    public String healthCheck(){
        log.info("healthCheck...");
        return "ok";
    }


}
