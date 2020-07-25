package com.ggs.exam.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  自定义响应数据结构
 *  这个类是提供给用户,ios,安卓,微信商城用的门户接受此类数据后需要使用本类的方法转换成对应的数据类型格式(类,或list)
 *  其他自行处理
 *    200：表示成功
 *    500：表示错误，错误信息在msg字段中
 *    501：bean验证错误，不管多少个错误都以map形式返回
 *    502：拦截器拦截到用户token出错
 *    503: session失效
 *    555：异常抛出信息
 *    401：请求未授权
 *
 *  0 失败
 *  1 成功
 *  2 异常
 *
 *
 *  成功0
 *
 *  @author: Starbug
 *  @date: 2020-07-05 18:51
 */
@Data
@AllArgsConstructor
public class JsonResult {

    private static String SUCCESS="SUCCESS";

    private static String FAILED="FAILED";

    //响应业务状态
    private Integer status;

    //响应消息
    private String msg;

    //响应中的数据
    private Object data;

//    public Boolean isOK(){
//        return this.status==1;
//    }

    public static JsonResult successWithData(Object data){
        return new JsonResult(1,"SUCCESS",data);
    }

    public static JsonResult successWithoutData(){
        return new JsonResult(1,"SUCCESS",null);
    }
    public static JsonResult failed(String msg){
        return new JsonResult(0,msg,null);
    }

    public static JsonResult exceptionCauseFailed(String msg){
        return new JsonResult(2,msg,null);
    }

}
