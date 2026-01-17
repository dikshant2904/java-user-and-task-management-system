package com.example.usermanagement.controller;

import com.example.usermanagement.dto.task.TaskRequestDto;
import com.example.usermanagement.dto.task.TaskResponseDto;
import com.example.usermanagement.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<TaskResponseDto> create(
            @PathVariable Long userId,
            @RequestBody TaskRequestDto dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createTask(userId, dto));
    }

    @GetMapping("/user/{userId}")
    public List<TaskResponseDto> getTasks(@PathVariable Long userId) {
        return service.getTasks(userId);
    }

    @DeleteMapping("/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long taskId) {
        service.deleteTask(taskId);
    }
}

