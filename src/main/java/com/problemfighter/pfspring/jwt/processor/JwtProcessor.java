package com.problemfighter.pfspring.jwt.processor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;

public class JwtProcessor {

    private JWTCreator.Builder tokenBuilder = null;
    private String token;
    private String algorithm;

    public JwtProcessor(String token, String algorithm) {
        this.tokenBuilder = JWT.create();
        this.token = token;
        this.algorithm = algorithm;
    }

    public JwtProcessor setClaim(String name, Map<String, ?> map) {
        return this;
    }

    public JwtProcessor setExpiration(Integer minutes) {
        return this;
    }

    public String getToken() {
        return null;
    }

    public String getToken(String issuer) {
        return null;
    }

    public String getToken(String issuer, String subject) {
        return null;
    }

    public DecodedJWT validateToken(String token){
        return null;
    }

}
