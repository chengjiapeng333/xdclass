package net.xdclass.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chengjiapeng on 2018/9/11.
 */
//@WebFilter(urlPatterns = "/api/*", filterName = "loginFilter")
public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init loginFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter loginfilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String userName = request.getParameter("username");
        if("cjp".equalsIgnoreCase(userName)) {
            filterChain.doFilter(request, response);
        }else {
            response.sendRedirect("/index.html");
            return;
        }

    }

    @Override
    public void destroy() {
        System.out.println("destory loginFilter");
    }
}
