package com.bigguy.spring.interceptor;

import com.bigguy.spring.entity.LoginInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/8
 **/
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 校验这个用户请求 url 是否在其权限之内
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        Object sessionObj = session.getAttribute(LoginInfo.SESSION_KEY);

        // 查看允许匿名访问的 url

        // 假设访问的所有的uri，都是需要登入的
        if(null == sessionObj){
            writeContent(response, "您还没有登入，请先登入...");
            return false;
        }

        LoginInfo loginInfo = (LoginInfo)sessionObj;

        // 请求 url
        String requestURI = request.getRequestURI();

        log.info("requestUri :{} ", requestURI);
        return hasAccess(loginInfo, requestURI);
    }

    /**
     * 是否有权限
     * @param requestUri
     * @return
     */
    public boolean hasAccess(LoginInfo loginInfo, String requestUri){
        if(loginInfo.getAuthorities().contains(requestUri)){
            return true;
        }
        return false;
    }

    /**
     * 响应信息给客户端
     * @param response
     * @param msg
     * @throws IOException
     */
    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
    }
}
