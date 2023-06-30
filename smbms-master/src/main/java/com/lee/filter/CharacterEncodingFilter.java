package com.lee.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 字符编码过滤器
 * Created by baidou on 2020/7/24.
 */
public class CharacterEncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
