package com.darly.dubbo.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/21
 * TODO :
 */
public class IllegalCharacterFilter implements Filter {
    private String[] characterParams = null;//參數過濾集合
    private boolean OK=true;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if(filterConfig.getInitParameter("characterParams").length()<1)
            OK=false;
        else
            this.characterParams = filterConfig.getInitParameter("characterParams").split(",");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean status = false;
        while (request.getParameterNames().hasMoreElements()) {
            status = true;
            break;
        }
        if (status) {
            HttpServletResponse servletresponse = (HttpServletResponse) response;
            servletresponse.setContentType("text/html");
            servletresponse.setCharacterEncoding("utf-8");
            PrintWriter out = servletresponse.getWriter();
            out
                    .print("<script language='javascript'>alert(\"对不起！您输入内容含有非法字符。如：\\\"'\\\".等\");"
                            // + servletrequest.getRequestURL()
                            + "window.history.go(-1);</script>");

        }else
            chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
