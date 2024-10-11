package com.example.blogApp.Repository;

import com.example.blogApp.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PostRepository extends MongoRepository<Post, String> {
}
