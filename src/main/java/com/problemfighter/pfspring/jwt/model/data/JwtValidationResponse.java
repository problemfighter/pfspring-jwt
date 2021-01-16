package com.problemfighter.pfspring.jwt.model.data;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class JwtValidationResponse {

    private DecodedJWT actualResponse;

    public JwtValidationResponse set(DecodedJWT actualResponse) {
        this.actualResponse = actualResponse;
        return this;
    }

    public static JwtValidationResponse instance() {
        return new JwtValidationResponse();
    }


    public String getToken() {
        return this.actualResponse.getToken();
    }


    public String getHeader() {
        return this.actualResponse.getHeader();
    }


    public String getPayload() {
        return this.actualResponse.getPayload();
    }


    public String getSignature() {
        return this.actualResponse.getSignature();
    }


    public String getAlgorithm() {
        return this.actualResponse.getAlgorithm();
    }


    public String getType() {
        return this.actualResponse.getType();
    }


    public String getContentType() {
        return this.actualResponse.getContentType();
    }


    public String getKeyId() {
        return this.actualResponse.getKeyId();
    }


    public Claim getHeaderClaim(String name) {
        return this.actualResponse.getHeaderClaim(name);
    }


    public String getIssuer() {
        return this.actualResponse.getIssuer();
    }


    public String getSubject() {
        return this.actualResponse.getSubject();
    }


    public List<String> getAudience() {
        return this.actualResponse.getAudience();
    }


    public Date getExpiresAt() {
        return this.actualResponse.getExpiresAt();
    }


    public Date getNotBefore() {
        return this.actualResponse.getNotBefore();
    }


    public Date getIssuedAt() {
        return this.actualResponse.getIssuedAt();
    }


    public String getId() {
        return this.actualResponse.getId();
    }


    public Claim getClaim(String name) {
        return this.actualResponse.getClaim(name);
    }


    public Map<String, Claim> getClaims() {
        return this.actualResponse.getClaims();
    }
}
