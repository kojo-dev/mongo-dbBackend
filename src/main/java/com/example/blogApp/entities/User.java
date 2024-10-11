package com.example.blogApp.entities;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Builder
@Data
public class User {
    @Id
    private String id;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    @DBRef
    private List<Post> post;

}
