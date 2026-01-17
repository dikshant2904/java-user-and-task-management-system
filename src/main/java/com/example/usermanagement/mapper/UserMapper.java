package com.example.usermanagement.mapper;

import com.example.usermanagement.dto.user.UserRequestDto;
import com.example.usermanagement.dto.user.UserResponseDto;
import com.example.usermanagement.entity.Role;
import com.example.usermanagement.entity.User;

public class UserMapper {

    public static User toEntity(UserRequestDto dto, String encodedPassword) {
        return new User(dto.name(), dto.email(), encodedPassword, Role.USER);
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
