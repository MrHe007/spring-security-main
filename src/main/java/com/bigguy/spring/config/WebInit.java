package com.bigguy.spring.config;

import com.bigguy.spring.filter.EncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletException;

/**
 * @Description:
 * @Author bigguy
 * @Date 2020/2/8
 **/
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    
    /**
     * @Description  配置
     * @Date 21:36 2020/2/8
     
     * @return java.lang.Class<?>[]
     **/
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    /**
     * @Description  指定 mvc 的核心配置类
     * @Date 11:06 2020/2/8
     * @return java.lang.Class<?>[]
     **/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    /**
     * 等同于将 DispatcherServlet 的url-pattern
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 也可以在onStartup中可以添加自定义的Servlet、Listener、Filter
     * 这里以添加过滤器为演示
     * addMappingForUrlPatterns方法参数说明:
     * 参数一： 请求过滤的类型，如果要使用默认的EnumSet.of(DispatcherType.REQUEST)(表示过滤所有的请求)，则为null
     * 参数二： 如果给定的过滤器映射应在其他任何声明的过滤器映射之后匹配，则为true;
     *         如果在获得此FilterRegistration的ServletContext的任何已声明过滤器映射之前应该匹配，则为false
     * 参数三： 过滤器映射的url
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {

        servletContext.addFilter("encodingFilter", EncodingFilter.class)
                .addMappingForUrlPatterns(null, false, "/*");
        super.onStartup(servletContext);
    }
}
