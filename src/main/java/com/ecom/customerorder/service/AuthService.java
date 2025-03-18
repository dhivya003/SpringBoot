package com.ecom.customerorder.service;

import com.ecom.customerorder.config.JwtUtils;
import com.ecom.customerorder.dto.Login;
import com.ecom.customerorder.dto.Register;
import com.ecom.customerorder.model.Users;
import com.ecom.customerorder.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    public  String register(Register register){
        if(userRepo.existsByEmail(register.getEmail())){
            throw  new RuntimeException("Email already exists");
        }
        Users user = new Users();
        user.setName(register.getName());
        user.setEmail(register.getEmail());
        user.setPassword(passwordEncoder.encode(register.getPassword()));
        user.setRole(register.getRole() != null ? register.getRole() :Users.UserRole.CUSTOMER);

        userRepo.save(user);
        return jwtUtils.generateToken(user);
    }

    public  String login(Login login){
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));

        Users user = userRepo.findByEmail(login.getEmail())
                .orElseThrow(()->new  RuntimeException("User Not found"));

        return jwtUtils.generateToken(user);
    }
}
