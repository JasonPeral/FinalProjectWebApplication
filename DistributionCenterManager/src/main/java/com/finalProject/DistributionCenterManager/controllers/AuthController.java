package com.finalProject.DistributionCenterManager.controllers;


import com.finalProject.DistributionCenterManager.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;


    public AuthController(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @PostMapping
    public String authenticate(Authentication authentication){
        LOG.debug("Token requested for user: {}", authentication.getName());
        String token = tokenService.generateToen(authentication);
        LOG.debug("Token granted {}", token);
        return token;

    }
}
