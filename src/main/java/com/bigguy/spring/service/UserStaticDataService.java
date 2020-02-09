package com.bigguy.spring.service;

import com.bigguy.spring.entity.LoginInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description: 模拟数据库资源
 * @Author bigguy
 * @Date 2020/2/9
 **/
@Service
@Slf4j
public class UserStaticDataService {

    /**
     * 假设：admin / admin123 的才可以登入成功
     */
    private static Map<String, LoginInfo> userMap = null;

    /**
     * 用户<name, authorities>
     */
    private static Map<String, Set<String>> userAuthoritiesMap;

    public UserStaticDataService(){

        initUserMapData();
        initUserAuthoritiesMap();

    }

    private static void initUserMapData(){
        if(userMap == null){
            userMap = new HashMap<>(16);
        }
        userMap.put("jeck", new LoginInfo("jeck", "jeck123"));
        userMap.put("admin", new LoginInfo("admin", "admin123"));
        userMap.put("tom", new LoginInfo("tom", "tom123"));
    }

    private static void initUserAuthoritiesMap(){
        if(userAuthoritiesMap == null){
            userAuthoritiesMap = new HashMap<>(16);
        }
        Set<String> jeckAuthorities = new HashSet<>(4);
        Set<String> tomAuthorities = new HashSet<>(4);
        jeckAuthorities.add("user:list");
        jeckAuthorities.add("user:get");

        tomAuthorities.add("user:list");
        tomAuthorities.add("user:get");
        tomAuthorities.add("user:delete");
        tomAuthorities.add("user:update");

        userAuthoritiesMap.put("jeck", jeckAuthorities);
        userAuthoritiesMap.put("tom", tomAuthorities);
    }

    public LoginInfo findUser(String username){
        return userMap.get(username);
    }

    public Set<String> findUserAuthorities(String username){
        return userAuthoritiesMap.get(username);
    }

    /**
     * 获取所有用户
     * @return
     */
    public List<LoginInfo> findUsers(){
        ArrayList<LoginInfo> loginInfos = new ArrayList<>(userMap.values());
        return loginInfos;
    }

}
