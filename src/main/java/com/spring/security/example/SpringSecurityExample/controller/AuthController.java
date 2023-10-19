package com.spring.security.example.SpringSecurityExample.controller;

import com.spring.security.example.SpringSecurityExample.jwt.JwtHelper;
import com.spring.security.example.SpringSecurityExample.model.JwtReponse;
import com.spring.security.example.SpringSecurityExample.model.JwtRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;

    @PostMapping("/login")
    public ResponseEntity<JwtReponse> login(@RequestBody JwtRequest jwtRequest){
        this.doAuthenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtHelper.generateToken(userDetails);
        JwtReponse jwtReponse = JwtReponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(jwtReponse, HttpStatus.OK);
    }
    private void doAuthenticate(String username, String password){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try{
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid credentials!!!");
        }
    }
    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler(){
        return "Bad Credentials!!";
    }

}
