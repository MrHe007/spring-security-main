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

    @GetMapping("/")
    public Object findUserList(){


        return null;
    }

    @GetMapping("/{id}")
    public Object findUser(@PathVariable("id") Integer id){


        return null;
    }

    @GetMapping("/del/{id}")
    public Object delUser(@PathVariable("id") Integer id){


        return null;
    }

}
