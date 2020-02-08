package com.bigguy.spring.service;

import com.bigguy.spring.entity.LoginInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/8
 **/
@Service
@Slf4j
public class UserLoginService {

    /*
     * @Description  假设：admin / admin123 的才可以登入成功
     * @Date 22:22 2020/2/8
     * @Param loginInfo:
     * @return void
     **/
    private Map<String, LoginInfo> userMap = null;
    public UserLoginService(){
        userMap = new HashMap<>(16);
        userMap.put("jeck", new LoginInfo("jeck", "jeck123"));
        userMap.put("jeck", new LoginInfo("admin", "admin123"));
        userMap.put("jeck", new LoginInfo("tom", "tom123"));
    }

    public void login(LoginInfo loginInfo){

        if (StringUtils.isEmpty(loginInfo.getName())
             || StringUtils.hasText(loginInfo.getPassword()) ){
            throw new RuntimeException("账号和密码为空");
        }

        LoginInfo dbUser = userMap.get(loginInfo.getName());
        if(null == dbUser){
            throw new RuntimeException("查不到该用户");
        }

        // 校验密码


    }

    /**
     * @Description  模拟数据库操作
     * @Date 22:23 2020/2/8
     * @Param username:
     * @return com.bigguy.spring.entity.LoginInfo
     **/
    public LoginInfo findLoginUser(String username){
        LoginInfo loginInfo = userMap.get(username);

//        log.info("from db : {}", );

        return null;

    }

}
