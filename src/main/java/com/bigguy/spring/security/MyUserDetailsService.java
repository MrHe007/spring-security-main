package com.bigguy.spring.security;

import com.bigguy.spring.entity.LoginInfo;
import com.bigguy.spring.service.UserStaticDataService;
import com.bigguy.spring.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 实现接口，通过 username 从数据库查数据
 * @Author bigguy
 * @Date 2020/2/9
 **/
@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserStaticDataService dataService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1、从数据库查用户信息：username - password

        //2、设置用户权限
        LoginInfo loginInfo = dataService.findUser(username);

        List authoritiesList = CommonUtils.setToList(loginInfo.getAuthorities());

        //3、设置 UserDetails
        UserDetails userDetails = User.withUsername(loginInfo.getName())
                .password(loginInfo.getPassword())
                .authorities(authoritiesList).build();

        return userDetails;
    }
}
