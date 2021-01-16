package com.problemfighter.pfspring.jwt.service;

import org.springframework.stereotype.Service;

@Service
public class JwtCallback implements IJwtCallback {


    @Override
    public void onCreate(JwtService jwtService) {

    }

    @Override
    public void onRefreshTokenCreate(JwtService jwtService) {

    }

    @Override
    public void preValidate(JwtService jwtService) {

    }

    @Override
    public void refreshTokenPreValidate(JwtService jwtService) {

    }
}
