package com.problemfighter.pfspring.jwt.config;

import com.problemfighter.pfspring.jwt.service.JwtCallbackInterface;
import com.problemfighter.pfspring.jwt.service.JwtCallbackService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class JwtConfiguration {

    @Bean
    @Lazy
    public JwtCallbackInterface jwtCallbackInterface(){
        return new JwtCallbackService();
    }
}
