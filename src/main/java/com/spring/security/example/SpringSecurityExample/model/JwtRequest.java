package com.spring.security.example.SpringSecurityExample.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtRequest {
    private String username;
    private String password;
}
