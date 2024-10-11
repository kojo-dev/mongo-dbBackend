package com.example.blogApp;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Category {
    private String id;
    private String name;
    private String description;
}
