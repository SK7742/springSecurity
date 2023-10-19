package com.spring.security.example.SpringSecurityExample.config;

import com.spring.security.example.SpringSecurityExample.jwt.JwtAuthentiationEntryPoint;
import com.spring.security.example.SpringSecurityExample.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class JwtSecurityConfig {
    private final JwtAuthentiationEntryPoint jwtAuthentiationEntryPoint;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request-> request.requestMatchers("/test")
                        .authenticated().requestMatchers("/auth/login").permitAll()
                        .anyRequest().authenticated()).exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthentiationEntryPoint))
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
