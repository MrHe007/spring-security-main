package com.bigguy.spring.controller;


import com.bigguy.spring.entity.LoginInfo;
import com.bigguy.spring.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/8
 **/
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private UserLoginService loginService;

    @GetMapping("healthCheck")
    public String healthCheck(){
        log.info("healthCheck...");
        return "ok";
    }

    @GetMapping("/login")
    public String login(LoginInfo loginInfo){

        log.info("login...");
        return null;
    }

    @GetMapping("/logout")
    public String loginout(){
        log.info("loginout...");
        return null;
    }

}
