package com.example.usermanagement.dto.task;

public record TaskResponseDto(
        Long id,
        String title,
        String description,
        String status
) {}

