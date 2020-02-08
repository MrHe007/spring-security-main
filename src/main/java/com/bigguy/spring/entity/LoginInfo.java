package com.bigguy.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/8
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    private String name;
    private String password;

}
