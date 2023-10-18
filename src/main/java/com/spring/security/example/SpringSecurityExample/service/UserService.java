package com.spring.security.example.SpringSecurityExample.service;

import com.spring.security.example.SpringSecurityExample.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Getter
@Setter
@AllArgsConstructor
@Slf4j
public class UserService {
    List<User> userList = new ArrayList<>();
    public UserService(){
        log.info("User Service is initiating some default users");
        User userOne = new User(UUID.randomUUID().toString(), "Shivam", "Life is struggle.");
        log.info("user is created : {}" + userOne.toString());
        User userTwo = new User(UUID.randomUUID().toString(), "Satyam", "Life should be joyfull.");
        log.info("user is created : {}" + userTwo.toString());
        User userThree = new User(UUID.randomUUID().toString(), "Sundram", "Explore the world.");
        log.info("user is created : {}" + userThree.toString());
        userList = List.of(userOne, userTwo, userThree);
    }
}
