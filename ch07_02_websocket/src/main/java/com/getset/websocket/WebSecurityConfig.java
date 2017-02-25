package com.getset.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security配置类。
 * Created by Kang on 2017/2/25.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login").permitAll() // 不拦截“/“和”/login“路径
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")                                // 设置登录界面地址
                .defaultSuccessUrl("/chat")                         // 登录成功转向“/chat”
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    // 配置用户
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("get").password("get").roles("USER")
                .and()
                .withUser("set").password("set").roles("USER");
    }

    // 配置静态资源不拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
