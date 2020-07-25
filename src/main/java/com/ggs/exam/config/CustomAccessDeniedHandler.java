package com.ggs.exam.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggs.exam.common.JsonResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-06 14:17
 */
@Configuration
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {

        JsonResult.exceptionCauseFailed("权限不足,如有需要,请通知管理员!");

    }
}
