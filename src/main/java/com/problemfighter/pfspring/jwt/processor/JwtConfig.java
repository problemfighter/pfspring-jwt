package com.problemfighter.pfspring.jwt.processor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties("pf.jwt")
public class JwtConfig {

    public String secretKey = "ProblemFighterSpringBootJWT";
    public String algorithm = "HMAC256";
    public String refreshTokenKey = "refreshTokenKey";
    public String accessTokenKey = "accessTokenKey";
    public Integer accessTokenValidityMinutes = 4320;
    public Integer refreshTokenValidityMinutes = 4500;

    public JwtConfig() {}

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getRefreshTokenKey() {
        return refreshTokenKey;
    }

    public void setRefreshTokenKey(String refreshTokenKey) {
        this.refreshTokenKey = refreshTokenKey;
    }

    public String getAccessTokenKey() {
        return accessTokenKey;
    }

    public void setAccessTokenKey(String accessTokenKey) {
        this.accessTokenKey = accessTokenKey;
    }

    public Integer getAccessTokenValidityMinutes() {
        return accessTokenValidityMinutes;
    }

    public void setAccessTokenValidityMinutes(Integer accessTokenValidityMinutes) {
        this.accessTokenValidityMinutes = accessTokenValidityMinutes;
    }

    public Integer getRefreshTokenValidityMinutes() {
        return refreshTokenValidityMinutes;
    }

    public void setRefreshTokenValidityMinutes(Integer refreshTokenValidityMinutes) {
        this.refreshTokenValidityMinutes = refreshTokenValidityMinutes;
    }
}
