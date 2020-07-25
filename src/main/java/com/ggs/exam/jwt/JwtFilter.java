package com.ggs.exam.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggs.exam.pojo.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-05 20:14
 */
public class JwtFilter extends GenericFilter {

    private static final String SECRET_KEY = "Overwatch";

    private static final String Authorization = "Authorization";

    private String AUTHORIZATION_HEADER_KEY = Authorization;

    private String TOKEN_PREFIX = "Bearer ";

    private static final Logger log = LoggerFactory.getLogger(JwtFilter.class);

    private static final String AUTHORITIES = "authorities";

    private ObjectMapper objectMapper=new ObjectMapper();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        //获得http的头
        String jwtToken = req.getHeader(AUTHORIZATION_HEADER_KEY);
        if (StringUtils.isBlank(jwtToken)) {
            chain.doFilter(request, response);
            return;
        }
        Claims claims = null;
        try {
            //        String token = new String(jwtToken.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>" + jwtToken);

            //请求头中,token的格式为: Bearer JwtToken值
            //注意Bearer和jwt直接有个空格
            String replaceToken = jwtToken.replace(TOKEN_PREFIX, "");
            //解析token,获取用户信息
            claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(replaceToken).getBody();
            //获取当前用户名
            String username = claims.getSubject();
//            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get(AUTHORITIES));

            String authoritiesStr = (String) claims.get(AUTHORITIES);
            List<GrantedAuthority> authorities = commaSeparatedStringToAuthorityList(authoritiesStr);

//            Role role=objectMapper.readValue(authoritiesStr,Role.class);

            //生成一个验证成功的token
            UsernamePasswordAuthenticationToken tokenBean = new UsernamePasswordAuthenticationToken(username, null, authorities);

            //放入SpringSecurity容器中,作为用户已登录的凭证
            SecurityContextHolder.getContext().setAuthentication(tokenBean);


        } catch (Exception e) {
            log.info("用户未使用JwtToken进行登录,将会使用其他方式进行登录");
        }
        //让过滤器继续往下执行
        chain.doFilter(request, response);

    }
    public List<GrantedAuthority> commaSeparatedStringToAuthorityList(
            String authorityString) throws JsonProcessingException {

        String substring = authorityString.substring(1, authorityString.length() - 1);
        String[] splitStrArray = substring.split("},");
        List<GrantedAuthority> roleList = new ArrayList<>();
        int num=0;
        for (String authority : splitStrArray) {
            Role role=null;
            if(num++<splitStrArray.length-1){
                authority = authority + "}";
            }
            role = objectMapper.readValue(authority, Role.class);
            roleList.add(role);
        }

        return roleList;
    }

//    public List<GrantedAuthority> commaSeparatedStringToAuthorityList(
//            String authorityString) {
//        return createAuthorityList(org.springframework.util.StringUtils
//                .tokenizeToStringArray(authorityString, ","));
//    }

//    public List<GrantedAuthority> createAuthorityList(String... authorities) {
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(authorities.length);
//
//        for (String authority : authorities) {
//            grantedAuthorities.add(new Role(authority));
//        }
//
//        return grantedAuthorities;
//    }
}
