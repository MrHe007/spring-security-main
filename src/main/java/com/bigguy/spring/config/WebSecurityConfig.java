package com.bigguy.spring.config;

import com.bigguy.spring.service.UserStaticDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collections;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/9
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserStaticDataService userStaticDataService;

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(); // 数据库加载方式的 manager
        // 凑够数据库加载用户

        setUsers(manager);
        return manager;
    }


    /**
     * 密码编码器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 配置拦截的 url
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/delete").hasAuthority("user:del")
                .antMatchers("/user/update").hasAuthority("user:update")
                .antMatchers("/user/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin();
//                .successForwardUrl("/login-success");
    }


    /**
     * 加载用户名、密码、权限
     * @param manager
     */
    private void setUsers(InMemoryUserDetailsManager manager){
        userStaticDataService.findUsers().forEach(loginInfo -> {
            User.UserBuilder userBuilder = User.withUsername(loginInfo.getName())
                    .password(loginInfo.getPassword());
            userBuilder.authorities(Collections.emptyList());

            UserDetails userDetails = userBuilder.build();
            manager.createUser(userDetails);
        });
    }

}
