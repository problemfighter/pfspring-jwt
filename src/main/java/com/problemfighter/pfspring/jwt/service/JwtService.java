package com.problemfighter.pfspring.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private IJwtCallback iJwtCallback;


}
