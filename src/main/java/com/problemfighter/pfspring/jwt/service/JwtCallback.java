package com.problemfighter.pfspring.jwt.service;

import com.problemfighter.pfspring.jwt.processor.JwtProcessor;
import org.springframework.stereotype.Service;

@Service
public class JwtCallback implements IJwtCallback {

    @Override
    public void onCreate(JwtProcessor jwtProcessor) {

    }

    @Override
    public void preValidate(JwtProcessor jwtProcessor) {

    }
}
