package com.example.blogApp;

import com.example.blogApp.Services.CategoryService;
import com.example.blogApp.Services.PostService;
import com.example.blogApp.entities.Post;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final CategoryService categoryService;
    private final PostService postService;
    Logger logger = (Logger) LoggerFactory.getLogger(Controller.class);
    @PostMapping("/posts")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        logger.info("This is to test the post controller");
        Category category1 = this.categoryService.createCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.CREATED);
    }
    @GetMapping("/get-currentPost")
    public ResponseEntity<List<Post>>  getPostCreatedAnHourAgo(){
        logger.warning("Validating the to see the current endpoint");
        List<Post> post =  this.postService.getCurrentPost();
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
    @PutMapping("/update/{postId}")

    public ResponseEntity<Post> editPost(@PathVariable("postId") String postId, Post currentPost){
       Post post = this.postService.updatePost(postId, currentPost);
       return new ResponseEntity<>(post, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> deletePostById(@PathVariable("postId") String postId){
        this.postService.deletePost(postId);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/getPostwith/{key}/{value}")
    public ResponseEntity<List<Post>> getPostWitValue(@PathVariable("key") String key, @PathVariable("value") String value){
        return new ResponseEntity<>(this.postService.findByKeyValue(key, value), HttpStatus.OK);

    }
}
