package com.problemfighter.pfspring.jwt.processor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;

public class JwtProcessor {

    private final JWTCreator.Builder tokenBuilder;
    private final String secretKey;
    private final String algorithm;
    private Integer expiration = 100;

    public JwtProcessor(String secretKey, String algorithm) {
        this.tokenBuilder = JWT.create();
        this.secretKey = secretKey;
        this.algorithm = algorithm;
    }

    private Algorithm getHMACAlgo() {
        if (this.algorithm == null || this.secretKey == null) {
            throw new JWTException("JWT Algorithm or Secret Key Should not be Null");
        }
        switch (algorithm) {
            case "HMAC256":
                return Algorithm.HMAC256(this.secretKey);
            case "HMAC384":
                return Algorithm.HMAC384(this.secretKey);
            case "HMAC512":
                return Algorithm.HMAC512(this.secretKey);
        }
        throw new JWTException("Invalid Algorithm Selected");
    }

    private String getSignToken() {
        tokenBuilder.withExpiresAt(DateHelper.instance().adjustCurrentDateWithMinute(this.expiration));
        return tokenBuilder.sign(getHMACAlgo());
    }

    public JWTCreator.Builder setProps() {
        return this.tokenBuilder;
    }

    public JwtProcessor setClaim(String name, Map<String, ?> map) {
        tokenBuilder.withClaim(name, map);
        return this;
    }

    public JwtProcessor setExpiration(Integer minutes) {
        this.expiration = minutes;
        return this;
    }

    public String getToken() {
        return this.getSignToken();
    }

    public String getToken(String issuer) {
        tokenBuilder.withIssuer(issuer);
        return this.getSignToken();
    }

    public String getToken(String issuer, String subject) {
        tokenBuilder.withIssuer(issuer).withSubject(subject);
        return this.getSignToken();
    }

    public DecodedJWT validateToken(String token) {
        try {
            JWTVerifier.BaseVerification verification = (JWTVerifier.BaseVerification) JWT.require(getHMACAlgo());
            JWTVerifier verifier = verification.build(new JwtCustomClock());
            return verifier.verify(token);
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
            throw new JWTException(exception.getMessage());
        }
    }

}
