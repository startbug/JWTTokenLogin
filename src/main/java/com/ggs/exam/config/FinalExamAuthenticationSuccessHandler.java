package com.ggs.exam.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-03 21:06
 */
@Configuration
public class FinalExamAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private ObjectMapper objectMapper;

//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
        //记录用于的认证信息到redis中
//        String authJsonStr = objectMapper.writeValueAsString(authentication);
//        ValueOperations<String, String> operations = redisTemplate.opsForValue();
//        operations.set(authentication.getName(), authJsonStr);
        super.onAuthenticationSuccess(request,response,authentication);
    }

//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//            Authentication authentication) throws ServletException, IOException {
//        //记录用于的认证信息到redis中
//        String authJsonStr = objectMapper.writeValueAsString(authentication);
//        ValueOperations<String, String> operations = redisTemplate.opsForValue();
//        operations.set(authentication.getName(), authJsonStr);
////      app版使用,因此删除下面的代码
////        redirectStrategy.sendRedirect(request, response, "/index.html");
//    }
}
