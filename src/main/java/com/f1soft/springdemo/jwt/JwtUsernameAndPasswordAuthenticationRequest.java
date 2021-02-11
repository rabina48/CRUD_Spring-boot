package com.f1soft.springdemo.jwt;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class JwtUsernameAndPasswordAuthenticationRequest implements Serializable {
    private String username;
    private  String  password;



}
