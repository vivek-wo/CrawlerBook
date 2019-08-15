package com.vivek.wo.crawlerbook.security.config;

import com.vivek.wo.crawlerbook.security.CBAuthenctiationFailureHandler;
import com.vivek.wo.crawlerbook.security.CBAuthenctiationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowerSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private CBAuthenctiationSuccessHandler cbAuthenctiationSuccessHandler;

    @Autowired
    private CBAuthenctiationFailureHandler cbAuthenctiationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
                .loginPage("/login.html")           // 设置登录页面
                .loginProcessingUrl("/user/login")  // 自定义的登录接口
                .successHandler(cbAuthenctiationSuccessHandler) // 自定义登录成功处理
                .failureHandler(cbAuthenctiationFailureHandler) // 自定义登录失败处理
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/login.html").permitAll()     // 设置所有人都可以访问登录页面
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated()
                .and()
                .csrf().disable();          // 关闭csrf防护
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
