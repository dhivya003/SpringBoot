package com.ecom.customerorder.dto;

import com.ecom.customerorder.model.Users;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class Login {

    private String email;
    private  String password;

    @Enumerated(EnumType.STRING)
    private Users.UserRole role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users.UserRole getRole() {
        return role;
    }

    public void setRole(Users.UserRole role) {
        this.role = role;
    }
}
