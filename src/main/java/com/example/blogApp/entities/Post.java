package com.example.blogApp.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@Builder
public class Post {
    @Id
    private String id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    @DBRef
    private User user;
}
