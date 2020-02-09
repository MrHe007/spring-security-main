package com.bigguy.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 模拟一些查找用户数据的 api
 * @Author bigguy
 * @Date 2020/2/9
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @GetMapping("/list")
    public Object findUserList(){
        log.info("user/list");

        return "user/list";
    }

    @GetMapping("/delete")
    public Object delUser( Integer id){
        log.info("user/delete");
        return "/user/delete";
    }

    @GetMapping("/update")
    public Object updateUser( Integer id){
        log.info("user/update");
        return "user:delete";
    }

    @GetMapping("/get")
    public Object findUser( Integer id){
        log.info("/user/get");

        return "user:get";
    }



}
