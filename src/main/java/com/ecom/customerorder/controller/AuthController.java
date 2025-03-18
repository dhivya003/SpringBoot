package com.ecom.customerorder.controller;

import com.ecom.customerorder.dto.Login;
import com.ecom.customerorder.dto.Register;
import com.ecom.customerorder.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Register register){
        return  ResponseEntity.ok(authService.register(register));
    }

    @PostMapping("/login")
    public  ResponseEntity<String> login(@RequestBody Login login){
        return  ResponseEntity.ok(authService.login(login));
    }
}
