//package com.ggs.exam;
//
//import com.alibaba.druid.sql.visitor.functions.If;
//import com.ggs.exam.common.JsonResult;
//import io.jsonwebtoken.*;
//import io.swagger.models.auth.In;
//import org.apache.commons.lang3.StringUtils;
//import org.junit.jupiter.api.Test;
//
//import java.util.Date;
//
///**
// *
// *  @author: Starbug
// *  @date: 2020-07-05 17:06
// */
//public class NormalTest {
//
//    //创建token
//    @Test
//    public void testJJWT(){
////        JwtBuilder jwtBuilder = Jwts.builder()
////                .setId("starbug") //设置唯一编号
////                .setSubject("加密") //设置主题 可以实JSON数据
////                .setIssuedAt(new Date())  //设置签发日期
////                //设置签名, 使用HS256算法, 并设置SecretKey(字符串)
////                .signWith(SignatureAlgorithm.HS256, "secret");
//        JwtBuilder jwtBuilder= Jwts.builder()
//                .setId("888")   //设置唯一编号
//                .setSubject("小白")//设置主题  可以是JSON数据
//                .setIssuedAt(new Date())//设置签发日期
//                .signWith(SignatureAlgorithm.HS256,"hahaha");//设置签名 使用HS256算法，并设置SecretKey(字符串)
//        //构建并返回一个字符串
//        System.out.println(jwtBuilder.compact());
//
//
//        double random = Math.random();
//
//
//
//    }
//
//    //解析token,如果token正确,解析成功;如果token错误,则抛出异常;所以解析token就是在验证token
//    @Test
//    public void testParserJJWT(){
//        String compactJwt="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE1OTM5NDAyMjZ9.aOji5pjN5QV7oJ78JkC1xzga0XFM86D7oeUkuHRspiA";
//        Claims claims = Jwts.parser().setSigningKey("hahaha").parseClaimsJws(compactJwt).getBody();
//        String signature = Jwts.parser().setSigningKey("hahaha").parseClaimsJws(compactJwt).getSignature();
//        JwsHeader header = Jwts.parser().setSigningKey("hahaha").parseClaimsJws(compactJwt).getHeader();
//        System.out.println(signature);
//        System.out.println(header);
//        System.out.println(claims);
//    }
//
//
//    //测试自定义Claims
//    @Test
//    public void testCustomizeClaims(){
//        long now=System.currentTimeMillis();
//        long exp=now+(1000*60);//30秒后过期
//        StringBuffer sb=new StringBuffer();
//        sb.append("ROLE_ADMIN").append(",").append("ROLE_USER").append(",");
//        JwtBuilder jwtBuilder = Jwts.builder()
//                .claim("roles",sb.toString())//自定义claim, 例如自定义角色
//                .setId("starbug")
//                .setSubject("自定义Claims")
//                .setIssuedAt(new Date()) //设置发布时间
//                .setExpiration(new Date(exp)) //设置过期时间
//                .signWith(SignatureAlgorithm.HS256, "Ideaaaa");
//        String token = jwtBuilder.compact();
//        System.out.println(token);
//
//    }
//
//    /**
//     * 解析token
//     */
//    @Test
//    public void testParseToken(){
//        String compactJwt= "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6IlJPTEVfQURNSU4sUk9MRV9VU0VSLCIsImp0aSI6InN0YXJidWciLCJzdWIiOiLoh6rlrprkuYlDbGFpbXMiLCJpYXQiOjE1OTM5NDQ2NTAsImV4cCI6MTU5Mzk0NDcwOX0.S0k7II19HokA0IzWyVmOprF4slD8bWdmOthHk33LDt8" ;
//        Claims claims = Jwts.parser()
//                .setSigningKey("Ideaaaa")
//                .parseClaimsJws(compactJwt).getBody();
//        String roles = (String) claims.get("roles");
//        System.out.println(roles);
//        String[] strings = StringUtils.split(roles, ",");
//        for(int i = 0; i < strings.length; i++) {
//          System.out.println(i+"  "+strings[i]);
//        }
//        System.out.println(claims);
//    }
//
//    /**
//     * iss: jwt签发者
//     * sub: jwt所面向的用户
//     * aud: 接收jwt的一方
//     * exp: jwt的过期时间，这个过期时间必须要大于签发时间
//     * nbf: 定义在什么时间之前，该jwt都是不可用的.
//     * iat: jwt的签发时间
//     * jti: jwt的唯一身份标识，主要用来作为一次性token。
//     */
//    @Test
//    public void test1(){
//        String jwtToken = Jwts.builder()
//                .setId("Starbug")
//                .setSubject("ou_ze_tian")
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
//                .signWith(SignatureAlgorithm.HS512, "Taylor Swift")
//                .claim("MainInfo", "{'ip':'47.115.176.47','password':'!Lhh1285226024'}")
//                .compact();
//
//        System.out.println(jwtToken);
//    }
//
//    @Test
//    public void test2(){
//        String jwtToken="eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJTdGFyYnVnIiwic3ViIjoib3VfemVfdGlhbiIsImlhdCI6MTU5Mzk1OTk4OCwiZXhwIjoxNTkzOTYzNTg4LCJNYWluSW5mbyI6Insn6LSm5Y-3JzonMTI4NTIyNjAyNC1saGgnLCflr4bnoIEnOidMaGgxMjg1MjI2MDI0J30ifQ.jsdUwcMylNMNPUmM2lijsAppR08y5OOiXGMvXWGPMOc1BQlMzXWJs5F1FU-mtfF7vWIqT98aVWw8tb4tvg8C4Q";
//        Claims claims = Jwts.parser().setSigningKey("Taylor Swift").parseClaimsJws(jwtToken).getBody();
//        System.out.println(claims);
//    }
//}
