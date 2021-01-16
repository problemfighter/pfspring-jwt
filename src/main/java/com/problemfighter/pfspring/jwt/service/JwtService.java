package com.problemfighter.pfspring.jwt.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.problemfighter.pfspring.jwt.processor.JWTException;
import com.problemfighter.pfspring.jwt.processor.JwtConfig;
import com.problemfighter.pfspring.jwt.processor.JwtProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JwtService {

    private final IJwtCallback iJwtCallback;
    private final JwtConfig jwtConfig;
    private final JwtProcessor jwtProcessor;
    private final String vKey = "vKey";

    @Autowired
    public JwtService(IJwtCallback iJwtCallback, JwtConfig jwtConfig) {
        this.iJwtCallback = iJwtCallback;
        this.jwtConfig = jwtConfig;
        this.jwtProcessor = new JwtProcessor(this.jwtConfig.secretKey, this.jwtConfig.algorithm);
    }

    public JwtProcessor getJwtProcessor() {
        return this.jwtProcessor;
    }

    public JwtService setIssuer(String issuer) {
        this.jwtProcessor.setProps().withIssuer(issuer);
        return this;
    }

    public JwtService setSubject(String subject) {
        this.jwtProcessor.setProps().withSubject(subject);
        return this;
    }

    public JwtService setClaim(String name, String object) {
        this.jwtProcessor.setProps().withClaim(name, object);
        return this;
    }

    public JwtService setClaim(String name, Map<String, ?> map) {
        this.jwtProcessor.setProps().withClaim(name, map);
        return this;
    }

    public String getRefreshToken() {
        iJwtCallback.onRefreshTokenCreate(this);
        setClaim(vKey, jwtConfig.refreshTokenKey);
        jwtProcessor.setExpiration(jwtConfig.refreshTokenValidityMinutes);
        return this.jwtProcessor.getToken();
    }

    public String getAccessToken() {
        iJwtCallback.onCreate(this);
        setClaim(vKey, jwtConfig.accessTokenKey);
        jwtProcessor.setExpiration(jwtConfig.accessTokenValidityMinutes);
        return this.jwtProcessor.getToken();
    }

    private DecodedJWT validateAccessRefreshToken(String token, String message, String pVKey) {
        DecodedJWT decodedJWT = validate(token);
        if (decodedJWT == null) {
            throw new JWTException(message);
        } else if (decodedJWT.getClaim(vKey) == null || !decodedJWT.getClaim(vKey).equals(pVKey)) {
            throw new JWTException(message);
        }
        return decodedJWT;
    }

    public DecodedJWT validateRefreshToken(String token) {
        iJwtCallback.refreshTokenPreValidate(this);
        String message = "Invalid Refresh Token";
        return validateAccessRefreshToken(token, message, jwtConfig.refreshTokenKey);
    }

    public DecodedJWT validateAccessToken(String token) {
        iJwtCallback.preValidate(this);
        String message = "Invalid Access Token";
        return validateAccessRefreshToken(token, message, jwtConfig.accessTokenKey);
    }

    public DecodedJWT validate(String token) {
        return jwtProcessor.validateToken(token);
    }
}
