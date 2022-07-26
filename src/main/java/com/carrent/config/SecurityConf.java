package com.carrent.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSec) throws Exception {
        httpSec
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/")
                .permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/newCar").hasRole("ADMIN")
                .antMatchers("/updateCar").hasRole("ADMIN")
                .and()
                .formLogin()
                .permitAll();
    }
}
