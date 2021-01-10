package com.problemfighter.pfspring.jwt.processor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "pf.jwt")
public class JwtConfig {

    private String secretKey;
    private String algorithm;
    private Integer validityMinutes = 4321;

    public JwtConfig() {}

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}
