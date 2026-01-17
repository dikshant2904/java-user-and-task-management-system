package com.example.usermanagement.service;

import com.example.usermanagement.dto.task.TaskRequestDto;
import com.example.usermanagement.dto.task.TaskResponseDto;
import com.example.usermanagement.entity.Task;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.exception.TaskNotFoundException;
import com.example.usermanagement.mapper.TaskMapper;
import com.example.usermanagement.repository.TaskRepository;
import jakarta.transaction.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public TaskResponseDto createTask(Long userId, TaskRequestDto dto) {

        User user = userService.getUserEntity(userId);
        Task task = new Task(dto.title(), dto.description(), user);

        return TaskMapper.toDto(taskRepository.save(task));
    }

    public List<TaskResponseDto> getTasks(Long userId) {
        return taskRepository.findByUser_Id(userId)
                .stream()
                .map(TaskMapper::toDto)
                .toList();
    }

    public void deleteTask(Long taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new TaskNotFoundException(taskId);
        }
        taskRepository.deleteById(taskId);
    }
}

