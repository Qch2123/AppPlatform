package com.fdzc.appback.intercept;

import com.alibaba.fastjson2.JSON;
import com.fdzc.appback.utils.JwUtils;
import com.fdzc.appback.vo.ResultVo;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        String token = request.getHeader("token");
        if(!StringUtils.hasText(token)) {
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(ResultVo.reject("token没传")));
            writer.close();
            writer.flush();
            return false;
        }
        try {
            JwUtils.getUserCode(token);
            return true;
        }catch (Exception e) {
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(ResultVo.reject(e.getMessage())));
            writer.close();
            writer.flush();
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
