package com.example.ecommerce.controller;

import com.example.ecommerce.dto.LoginRequest;
import com.example.ecommerce.dto.LoginResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req) {

        if ("admin".equals(req.getUsername()) &&
                "admin".equals(req.getPassword())) {
            return new LoginResponse(true, "fake-jwt-token-123");
        }

        return new LoginResponse(false, null);
    }
}
