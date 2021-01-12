package com.problemfighter.pfspring.jwt.service;


import com.problemfighter.pfspring.jwt.processor.JwtProcessor;

public interface IJwtCallback {
    public void onCreate(JwtProcessor jwtProcessor);
    public void preValidate(JwtProcessor jwtProcessor);
}
