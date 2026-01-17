package com.example.usermanagement.controller;

import com.example.usermanagement.dto.user.UserRequestDto;
import com.example.usermanagement.dto.user.UserResponseDto;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createUser(dto));
    }
}
