package com.letsconnecot.controller;

import com.letsconnecot.dto.LoginDto;
import com.letsconnecot.dto.LoginResponseDto;
import com.letsconnecot.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController<T> {

    @Autowired
    private LoginService loginService;

    private final static Logger log = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public T login(@RequestBody LoginDto loginDto) {

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        log.info("loginController::login===START ");
        loginResponseDto = (LoginResponseDto) loginService.login(loginDto);
        log.info("loginController::login===END ");
        return (T) loginResponseDto;
    }
}