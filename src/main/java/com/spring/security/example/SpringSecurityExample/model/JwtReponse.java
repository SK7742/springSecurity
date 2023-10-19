package com.spring.security.example.SpringSecurityExample.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtReponse {
    private String jwtToken;
    private String username;
}
