package com.task1foralabs.Task1ForAlabs.config;

import com.task1foralabs.Task1ForAlabs.service.imp.UserServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(proxyTargetClass = true,prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {
    @Bean
    public UserDetailsService userService(){
        return new UserServiceImp();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        AuthenticationManagerBuilder authenticationManagerBuilder =httpSecurity.
                getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService()).passwordEncoder(passwordEncoder());
        httpSecurity.exceptionHandling().accessDeniedPage("/forbidden");
        httpSecurity.authorizeRequests().antMatchers("/css/**", "/js/**").permitAll();

        httpSecurity.formLogin()
                .loginProcessingUrl("/auth").permitAll()
                .defaultSuccessUrl("/")
                .failureUrl("/login?error").permitAll()
                .usernameParameter("user_email")
                .passwordParameter("user_password")
                .loginPage("/login").permitAll();

        httpSecurity.logout()
                .logoutSuccessUrl("/login")
                .logoutUrl("/signout");

        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }
}
