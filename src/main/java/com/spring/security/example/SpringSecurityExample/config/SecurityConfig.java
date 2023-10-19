package com.spring.security.example.SpringSecurityExample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userOne = User.builder()
                .username("shivam")
                .password(passwordEncoder().encode("test"))
                .roles("ADMIN").build();

        UserDetails userTwo = User.builder()
                .username("satyam")
                .password(passwordEncoder().encode("test"))
                .roles("ADMIN").build();

        UserDetails userThree = User.builder()
                .username("sundram")
                .password(passwordEncoder().encode("test"))
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(userOne, userTwo, userThree);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
