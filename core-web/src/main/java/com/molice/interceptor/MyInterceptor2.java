package com.molice.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author molice
 * @date 2019/2/3
 **/
public class MyInterceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("starttime", System.currentTimeMillis());
        System.out.println(">>>>>>>>>>MyInterceptor2 preHandle>>>>>>>>>>>>>");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long starttime = (long) request.getAttribute("starttime");
        System.out.println(">>>>>>>MyInterceptor2执行：" + (System.currentTimeMillis() - starttime));
        System.out.println(">>>>>>>>>>MyInterceptor2 postHandle>>>>>>>>>>>>>");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        request.removeAttribute("starttime");
        System.out.println(">>>>>>>>>MyInterceptor2 afterCompletion>>>>>>>>>");
    }
}
