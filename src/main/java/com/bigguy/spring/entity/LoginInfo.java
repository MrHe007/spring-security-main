package com.bigguy.spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/8
 **/
@Getter
@Setter
@NoArgsConstructor
public class LoginInfo {

    public static final String SESSION_KEY = "_user";

    private String name;
    private String password;

    public LoginInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * 运行被访问的权限
     */
    private Set<String> authorities;

}
