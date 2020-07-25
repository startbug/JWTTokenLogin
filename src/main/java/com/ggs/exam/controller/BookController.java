package com.ggs.exam.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggs.exam.common.JsonResult;
import com.ggs.exam.pojo.Book;
import com.ggs.exam.service.BookService;
import com.ggs.exam.service.impl.UserServiceImpl;
import com.ggs.exam.tools.ExamUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.HashMap;
import java.util.List;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-03 17:21
 */
@Api(value = "图书信息",description = "图书操作 API")
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "获取所有图书的信息")
    @ResponseBody
    @RolesAllowed({"ROLE_ADMIN"})
    @GetMapping("/get/book/list")
    public JsonResult getBookList() {
        List<Book> bookList = bookService.getBookList();
        return JsonResult.successWithData(bookList);
    }

    @ApiOperation(value = "添加图书信息",notes = "需要录入作者,书名,销量等等信息,数据格式:json")
    @ResponseBody
    @PostMapping("/add/book/info")
    public JsonResult addBookInfo(@RequestBody Book book) {
        System.out.println(ReflectionToStringBuilder.toString(book, ToStringStyle.MULTI_LINE_STYLE));
        book.setId(ExamUtils.getUUID());
        book.setCid(1);
        bookService.insertBookInfo(book);
        return JsonResult.successWithoutData();
    }

    @ApiOperation(value = "修改图书信息",notes = "添加需要修改字段和图书的id值,不修改的字段不需要写,数据格式:json")
    @ResponseBody
    @PostMapping("/edit/book/info")
    public JsonResult editBookInfo(@RequestBody Book book) {
        System.out.println(ReflectionToStringBuilder.toString(book, ToStringStyle.MULTI_LINE_STYLE));
        bookService.updateBookInfo(book);
        return JsonResult.successWithoutData();
    }

    @ApiOperation(value = "根据id获取图书信息",notes = "该接口用于在修改图书信息前,进行数据回显的操作")
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/get/book/by/id")
    public JsonResult getBookInfoById(String id) {
        Book book = bookService.getEditBookInfo(id);
        return JsonResult.successWithData(book);
    }

    @Secured({"ROLE_ADMIN"})
    @ApiOperation(value = "根据id删除图书",notes = "d值存放在url的{id}中,例如: http://www.starbug.vip/delete/book/info/by/683e6d0015494cf6a721ca8e110913a9")
    @ResponseBody
    @PostMapping("/delete/book/info/by/{id}")
    public JsonResult deleteBookInfoById(@PathVariable String id) {
        bookService.deleteBookInfoById(id);
        return JsonResult.successWithoutData();
    }
}
