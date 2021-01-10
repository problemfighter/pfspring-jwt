package com.problemfighter.pfspring.jwt.service;

import com.problemfighter.pfspring.jwt.processor.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final IJwtCallback iJwtCallback;
    private final JwtConfig jwtConfig;

    @Autowired
    public JwtService(IJwtCallback iJwtCallback, JwtConfig jwtConfig) {
        this.iJwtCallback = iJwtCallback;
        this.jwtConfig = jwtConfig;
    }
}
