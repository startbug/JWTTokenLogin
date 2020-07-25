package com.ggs.exam.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggs.exam.common.JsonResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-02 22:31
 */
@Configuration
public class FinalExamAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {


    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        ObjectMapper objectMapper = new ObjectMapper();
        if (exception instanceof AuthenticationException) {
            objectMapper.writeValueAsString(JsonResult.successWithData(JsonResult.exceptionCauseFailed("用户名或密码错误!")));
        } else {
            objectMapper.writeValueAsString(JsonResult.successWithData(JsonResult.exceptionCauseFailed(exception.getMessage())));
        }


//        HttpSession session = request.getSession();
//
//        if(exception instanceof AuthenticationException){
//            session.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,new UsernameNotFoundException("用户名或密码错误!"));
//        }
//
//        redirectStrategy.sendRedirect(request,response,"/to/login.html");

    }

//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//            AuthenticationException exception) throws IOException, ServletException {
//        HttpSession session = request.getSession();
//        if(exception instanceof AuthenticationException){
//            session.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,new UsernameNotFoundException("用户名或密码错误!"));
//        }
////        session.setAttribute("error","error");
//        redirectStrategy.sendRedirect(request,response,"/to/login.html");
//
////        session.setAttribute("error","error");
////        request.getRequestDispatcher("/to/login.html").forward(request,response);
//    }
}
