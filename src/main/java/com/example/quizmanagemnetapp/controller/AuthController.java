package com.example.quizmanagemnetapp.controller;

import com.example.quizmanagemnetapp.Util.JwtUtil;
import com.example.quizmanagemnetapp.dto.AuthRequestDto;
import com.example.quizmanagemnetapp.entities.User;
import com.example.quizmanagemnetapp.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtUtil jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody User userInfo) {
        return userService.addUser(userInfo);
    }

    @PostMapping(value="/signing", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequestDto authRequestDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getName(), authRequestDto.getPassword()));
        if (authentication.isAuthenticated()) {
            Map<String, String> response = new HashMap<>();
            response.put("token", jwtService.generateToken(authRequestDto.getName()));
            return ResponseEntity.ok(response);
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
