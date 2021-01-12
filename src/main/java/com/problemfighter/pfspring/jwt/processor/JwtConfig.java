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
    public Integer validityMinutes = 4321;

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

    public Integer getValidityMinutes() {
        return validityMinutes;
    }

    public void setValidityMinutes(Integer validityMinutes) {
        this.validityMinutes = validityMinutes;
    }
}
