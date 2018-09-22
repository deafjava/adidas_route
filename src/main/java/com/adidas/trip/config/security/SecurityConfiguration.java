package com.adidas.trip.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${auth.user}")
    private String user;

    @Value("${auth.password}")
    private String password;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        String encodedPassword = passwordEncoder().encode(password);

        auth
                .inMemoryAuthentication()
                .withUser(user).password(encodedPassword)
                .roles("USER");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/**")
                .hasRole("USER")
                .and()
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}