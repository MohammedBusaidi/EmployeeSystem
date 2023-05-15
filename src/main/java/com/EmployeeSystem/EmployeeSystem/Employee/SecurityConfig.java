package com.EmployeeSystem.EmployeeSystem.Employee;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig extends SecurityConfigurerAdapter {
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
    }
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("root").roles("USER").and()
                .withUser("admin").password("root").roles("ADMIN");
    }
}
