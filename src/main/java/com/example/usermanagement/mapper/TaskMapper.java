package com.example.usermanagement.mapper;

import com.example.usermanagement.dto.task.TaskResponseDto;
import com.example.usermanagement.entity.Task;


public class TaskMapper {

    public static TaskResponseDto toDto(Task task) {
        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name()
        );
    }
}

