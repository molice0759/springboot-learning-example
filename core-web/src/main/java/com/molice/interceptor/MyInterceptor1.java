package com.molice.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author molice
 * @date 2019/2/3
 **/
public class MyInterceptor1 extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("starttime", System.currentTimeMillis());
        System.out.println(">>>>>>>>>>MyInterceptor1 preHandle>>>>>>>>>>>>>");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long starttime = (long) request.getAttribute("starttime");
        System.out.println(">>>>>>>MyInterceptor1执行：" + (System.currentTimeMillis() - starttime));
        System.out.println(">>>>>>>>>>MyInterceptor1 postHandle>>>>>>>>>>>>>");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        request.removeAttribute("starttime");
        System.out.println(">>>>>>>>>MyInterceptor1 afterCompletion>>>>>>>>>");
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
        System.out.println(">>>>>>>>>MyInterceptor1 afterConcurrentHandlingStarted>>>>>>>>>>");
    }
}
