package com.problemfighter.pfspring.jwt.service;


import com.problemfighter.pfspring.jwt.processor.JwtProcessor;

public interface IJwtCallback {
    public void onCreate(JwtService jwtService);
    public void onRefreshTokenCreate(JwtService jwtService);
    public void preValidate(JwtService jwtService);
    public void refreshTokenPreValidate(JwtService jwtService);
}
