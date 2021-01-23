package com.problemfighter.pfspring.jwt.service;

public interface JwtCallbackInterface {
     void onCreate(JwtService jwtService);
     void onRefreshTokenCreate(JwtService jwtService);
     void preValidate(JwtService jwtService);
     void refreshTokenPreValidate(JwtService jwtService);
}
