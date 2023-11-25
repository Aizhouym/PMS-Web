package com.example.pmscode.interceptor;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.pmscode.Utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;

/**
 * JWT拦截器
 * @author yanglingcong
 * @date 2021/12/31 12:39 PM
 */
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HashMap<String, String> map=new HashMap<>();
        //从http请求头获取token
        String token = request.getHeader("token");
        try {
            //如果验证成功放行请求
            DecodedJWT verify = JwtUtils.verify(token);
            return true;
        }
        catch (Exception exception)
        {
            map.put("msg","验证失败");
            map.put("code","500");
        }
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}