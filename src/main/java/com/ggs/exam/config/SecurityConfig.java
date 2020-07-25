package com.ggs.exam.config;

//import com.ggs.exam.jwt.JwtFilter;
import com.ggs.exam.jwt.JwtFilter;
import com.ggs.exam.jwt.JwtLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 *
 *  @author: Starbug
 *  @date: 2020-07-02 15:17
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired(required = false)
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //放行指定的静态资源
        web.ignoring().antMatchers("/css/**", "/img/**", "/plugins/**");

    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .failureHandler(authenticationFailureHandler)
                .successHandler(authenticationSuccessHandler)
                .disable()
                .formLogin().disable()
                .httpBasic().disable()
//                .permitAll()
//                .formLogin()
//                .loginPage("/to/login")
//                .defaultSuccessUrl("/index.html")
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                .rememberMe()
                .userDetailsService(userDetailsService)
                .tokenRepository(persistentTokenRepository)
                .tokenValiditySeconds(3600)//设置token过期时间
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                .and()
                .authorizeRequests()
                .antMatchers("/druid/**", "/to/register","/do/register","/swagger-ui.html","/jwt/login",
                        "/webjars/**","/v2/**","/swagger-resources/**")
                .permitAll()
//                .hasAnyRole("USER")
//                .antMatchers("/**")
//                .hasAnyAuthority("USER")
                .and()
                .authorizeRequests()
                .anyRequest()
//                .hasAnyRole("USER")
//                .permitAll()
                .authenticated()
                .and()
                //JwtLoginFilter过滤器加在UsernamePasswordAuthenticationFilter前面
                .addFilterBefore(new JwtLoginFilter("/jwt/login",authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                //添加解析token的过滤器,加在UsernamePasswordAuthenticationFilter前面
                .addFilterBefore(new JwtFilter(),JwtLoginFilter.class)
                .csrf()
                .disable();
//        http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();

        //禁用缓存
        http.headers().cacheControl();

    }
}
