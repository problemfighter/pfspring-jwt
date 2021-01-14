package com.problemfighter.pfspring.jwt.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.problemfighter.pfspring.jwt.processor.JwtConfig;
import com.problemfighter.pfspring.jwt.processor.JwtProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final IJwtCallback iJwtCallback;
    private final JwtConfig jwtConfig;
    private final JwtProcessor jwtProcessor;

    @Autowired
    public JwtService(IJwtCallback iJwtCallback, JwtConfig jwtConfig) {
        this.iJwtCallback = iJwtCallback;
        this.jwtConfig = jwtConfig;
        this.jwtProcessor = new JwtProcessor(this.jwtConfig.secretKey, this.jwtConfig.algorithm).setExpiration(this.jwtConfig.validityMinutes);
    }

    public JwtProcessor getJwtProcessor() {
        return this.jwtProcessor;
    }

    public String getToken(String issuer) {
        iJwtCallback.onCreate(jwtProcessor);
        return this.jwtProcessor.getToken(issuer);
    }

    public String getToken(String issuer, String subject) {
        iJwtCallback.onCreate(jwtProcessor);
        return this.jwtProcessor.getToken(issuer, subject);
    }

    public DecodedJWT validate(String token) {
        iJwtCallback.preValidate(this.jwtProcessor);
        return jwtProcessor.validateToken(token);
    }
}
