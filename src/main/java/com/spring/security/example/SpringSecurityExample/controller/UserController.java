package com.spring.security.example.SpringSecurityExample.controller;

import com.spring.security.example.SpringSecurityExample.model.User;
import com.spring.security.example.SpringSecurityExample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/user/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("fetchAll")
    public List<User> fetchAllUsers(){
        return userService.getUserList();
    }

    @GetMapping("/getActiveSessionUser")
    public String getSessionUser(Principal principal){
        return principal.getName();
    }
}
