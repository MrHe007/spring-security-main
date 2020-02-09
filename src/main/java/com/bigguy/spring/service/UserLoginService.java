package com.bigguy.spring.service;

import com.bigguy.spring.entity.LoginInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/8
 **/
@Service
@Slf4j
public class UserLoginService {

    @Autowired
    UserStaticDataService userStaticDataService;

    public void login(HttpServletRequest request, LoginInfo loginInfo){

        if (StringUtils.isEmpty(loginInfo.getName())
             || StringUtils.hasText(loginInfo.getPassword()) ){
            throw new RuntimeException("账号和密码为空");
        }
        String username = loginInfo.getName();
        LoginInfo dbUser = userStaticDataService.findUser(username);
        if(null == dbUser){

            throw new RuntimeException("查不到该用户");
        }

        // 校验密码
        if(!loginInfo.getPassword().equals(dbUser.getPassword())){
            throw new RuntimeException("数据库校验失败...");
        }
        // 校验通过，分配权限
        Set<String> userAuthorities = userStaticDataService.findUserAuthorities(username);
        dbUser.setAuthorities(userAuthorities);

        // 将登入用户信息，放到 session 中
        request.getSession().setAttribute(LoginInfo.SESSION_KEY, loginInfo);
    }



}
