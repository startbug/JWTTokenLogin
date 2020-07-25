package com.ggs.exam.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggs.exam.common.JsonResult;
import com.ggs.exam.common.TokenString;
import com.ggs.exam.pojo.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.NullRememberMeServices;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-05 19:12
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    private static final String IIS = "Starbug";
    private static final String SECRET_KEY = "Overwatch";
    private static final String AUTHORITIES = "authorities";

    private RememberMeServices rememberMeServices = new NullRememberMeServices();

    private ObjectMapper objectMapper = new ObjectMapper();

    private AuthenticationManager authenticationManager;

    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        //登录处理的url
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        //AuthenticationManager校验的核心类,存放用户信息
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        Authentication authenticate = null;
        try {
            //json格式数据登录
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            //authentication()是自动校验账号密码是否正确的方法
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (Exception e) {
            //如果认证失败,提供自定义json格式异常信息
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            PrintWriter writer = response.getWriter();
            writer.write(objectMapper.writeValueAsString(JsonResult.exceptionCauseFailed(e.getMessage())));
        }
        if (null == authenticate) {
            throw new RuntimeException("认证失败");
        }
        return authenticate;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
            HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        //Authentication存放着登录成功后的用户信息
        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();

        StringBuffer sb = new StringBuffer();

//        authorities.forEach(authority -> {
//            try {
//                String authorityJson = objectMapper.writeValueAsString(authority);
//                sb.append(authorityJson).append(",");
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//        });
        String authorityJson = objectMapper.writeValueAsString(authorities);

        String jwtToken = Jwts.builder()
                //Jwt签发这
                .setId(IIS)
                //Jwt签发的时间
                .setIssuedAt(new Date())
                //配置用户的角色
//                .claim(AUTHORITIES, sb)
                .claim(AUTHORITIES, authorityJson)
                //配置主题|主题设置为用户名
                .setSubject(authResult.getName())
                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                //设置加密算法,指定密钥,一串字符串,可以是json(自定义,绝不可泄露)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

        String jsonJwtToken = objectMapper.writeValueAsString(JsonResult.successWithData(new TokenString(jwtToken)));

//        rememberMeServices.loginSuccess(request, response, authResult);

        PrintWriter out = response.getWriter();

        out.write(jsonJwtToken);
        out.flush();
        out.close();
    }
}
