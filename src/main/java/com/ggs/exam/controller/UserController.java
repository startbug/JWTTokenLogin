package com.ggs.exam.controller;

import com.ggs.exam.common.JsonResult;
import com.ggs.exam.pojo.Book;
import com.ggs.exam.pojo.User;
import com.ggs.exam.pojo.vo.UserVO;
import com.ggs.exam.service.UserService;
import com.ggs.exam.tools.ExamUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-02 15:17
 */
@Api(value = "用户信息",description = "用户信息操作 API")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private String msg;

//    @ApiOperation(value = "跳转注册页面")
//    @GetMapping("/to/register")
//    public String toRegister(Model model) {
//        if(StringUtils.isNotBlank(msg)){
//            model.addAttribute("msg",msg);
//            msg="";
//        }
//        return "all-admin-register";
//    }

//    @ApiOperation(value = "登录成功后跳转首页")
//    @GetMapping("/index")
//    public String test() {
//        return "all-admin-datalist";
//    }



//    @ApiOperation(value = "跳转登录页面")
//    @GetMapping("/to/login")
//    public String toLoginPage(Model model, HttpSession session) {
//        Object obj = session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//        if (null != obj && obj instanceof AuthenticationException) {
//            AuthenticationException authenticationException=(AuthenticationException) obj;
//            session.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, "");
//            if (null != authenticationException) {
//                model.addAttribute("msg", authenticationException.getMessage());
//            }
//        }
//        return "all-admin-login";
//    }

//    @ApiOperation(value = "用户注册接口",notes = "需要传入具体用户信息")
//    @PostMapping("/do/register")
//    public String doRegister(User user,@RequestParam("repassword") String repassword,Model model){
//        try {
//            System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
//            Assert.isTrue(StringUtils.equals(user.getPassword(),repassword),"两次密码输入不一致!");
//
//            user.setId(ExamUtils.getUUID());
//            user.setCreateTime(new Date());
//            user.setUpdateTime(new Date());
//            user.setType(1);
//
//            userService.registerUser(user);
//        } catch (Exception e) {
//            e.printStackTrace();
////            model.addAttribute("msg",e.getMessage());
//            msg=e.getMessage();
//            return "redirect:/to/register";
//        }
//        return "redirect:/to/login";
//    }

    @ResponseBody
    @ApiOperation(value = "用户注册接口",notes = "需要传入具体用户信息")
    @PostMapping("/do/register")
    public JsonResult doRegister(@RequestBody UserVO userVO,Model model){
        try {
            System.out.println(ReflectionToStringBuilder.toString(userVO, ToStringStyle.MULTI_LINE_STYLE));
            Assert.isTrue(StringUtils.equals(userVO.getPassword(),userVO.getRepassword()),"两次密码输入不一致!");

            userVO.setId(ExamUtils.getUUID());
            userVO.setCreateTime(new Date());
            userVO.setUpdateTime(new Date());
            userVO.setType(1);

            userService.registerUser(userVO);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.exceptionCauseFailed(e.getMessage());
        }
        return JsonResult.successWithoutData();
    }

    @ResponseBody
    @GetMapping("/me")
    public JsonResult getMe(Authentication authentication){
        return JsonResult.successWithData(authentication);
    }

}
