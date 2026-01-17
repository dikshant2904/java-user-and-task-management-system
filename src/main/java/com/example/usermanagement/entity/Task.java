package com.example.usermanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Getter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Task(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.user = user;
    }

    public void markDone() {
        this.status = TaskStatus.DONE;
    }
}

