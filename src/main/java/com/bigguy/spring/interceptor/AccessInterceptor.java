package com.bigguy.spring.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * @Description: 权限拦截的类
 * @Author bigguy
 * @Date 2020/2/9
 **/
public class AccessInterceptor implements HandlerInterceptor {

    /**
     * 允许匿名访问的 set 集合
     */
    private Set<String> annonyUrlSet;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return allowAccess(request);
    }

    public boolean allowAccess(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        return annonyUrlSet.contains(requestURI);
    }

    public void setAnnonyUrlSet(Set<String> annonyUrlSet) {
        this.annonyUrlSet = annonyUrlSet;
    }
}
