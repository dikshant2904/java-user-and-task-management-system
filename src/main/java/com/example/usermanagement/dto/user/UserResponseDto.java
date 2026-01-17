package com.example.usermanagement.dto.user;

public record UserResponseDto(
        Long id,
        String name,
        String email
) {}

