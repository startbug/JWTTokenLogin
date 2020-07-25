package com.ggs.exam.exception;

import com.ggs.exam.common.JsonResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-06 13:59
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

//    private ObjectMapper objectMapper = objectMappernew ObjectMapper();


    @ExceptionHandler(value = {Exception.class})
    public JsonResult handlerAccessDeniedException(Exception e,HttpServletResponse response) {
        if (e instanceof AccessDeniedException) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return JsonResult.exceptionCauseFailed("权限不足,如有需要,请通知管理员!");
        } else {
            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            return JsonResult.exceptionCauseFailed("服务器异常,请通知管理员!");
        }
    }

//    @ExceptionHandler(value = {Exception.class})
//    public void handlerAccessDeniedException(HttpServletResponse response, Exception e) {
//        PrintWriter writer = null;
//        try {
//            writer = response.getWriter();
//            String msg;
//            if (e instanceof AccessDeniedException) {
//                msg = objectMapper.writeValueAsString(JsonResult.exceptionCauseFailed("权限不足,如有需要,请通知管理员!"));
//            } else {
//                msg = objectMapper.writeValueAsString(JsonResult.exceptionCauseFailed("服务器异常,请通知管理员!"));
//            }
//            writer.write(msg);
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        } finally {
//            writer.flush();
//            writer.close();
//        }
//    }

}
