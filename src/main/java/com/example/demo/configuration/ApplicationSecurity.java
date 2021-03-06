package com.example.demo.configuration;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/main/**").hasAnyRole("ADMIN")
//                .anyRequest().permitAll()
//                .and()
//                .formLogin("/login/")
//                .logout().permitAll();
        http.authorizeRequests()
//                .antMatchers("/", "/home").hasRole("ROLE_USER")
//                .antMatchers("*/edit*/*").hasRole("ADMIN")
                .antMatchers("/", "/main").permitAll()
                .antMatchers("/", "/main/edit*/*","/main/allUsers/", "/main/allUsers", "/main/allEmployees","/main/allEmployees/","/main/allTypes/", "/main/allTypes").hasRole("ADMIN")
                .and()
                // some more method calls
                .formLogin()
                .defaultSuccessUrl("/main/", true);


    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
}
