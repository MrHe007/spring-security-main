package com.bigguy.spring.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/8
 **/
@RestController
public class LoginController {

    private Log logger = LogFactory.getLog(LoginController.class);

    @GetMapping("healthCheck")
    public String healthCheck(){
        logger.info("healthCheck...");
        return "ok";
    }

    @GetMapping("/login")
    public String login(){
        logger.info("login...");
        return null;
    }

    @GetMapping("/logout")
    public String loginout(){
        logger.info("loginout...");
        return null;
    }

}
