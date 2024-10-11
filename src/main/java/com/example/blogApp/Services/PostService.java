package com.example.blogApp.Services;

import com.example.blogApp.Repository.PostRepository;
import com.example.blogApp.entities.Post;
import com.example.blogApp.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private MongoTemplate mongoTemplate;
    private final PostRepository postRepository;
//    @Service
//    public class UserService {
//
//        @Autowired
//        private MongoTemplate mongoTemplate;
//
//        public List<User> findAllUsersWithPosts() {
//            Query query = new Query();
//            return mongoTemplate.find(query, User.class);
//        }
//    }

    public List<User> findAllUsersWithPost(){
        Query query = new Query();

      List<User>  users =  mongoTemplate.find(query, User.class);
      for(User user1: users){
          if(user1.getCreatedAt().isBefore(LocalDateTime.now())){
              user1.setCreatedAt(LocalDateTime.now());
          }
      }
      return users;
    }
    public void createPost(Post post){
        if(post.getUser().getId() == null){
            throw new RuntimeException("User id can't be null");
        }
        Post post1 = Post.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(LocalDateTime.now())
                .user(post.getUser())
                .build();
    }

    public void deletePost(String postId){
        Post post = mongoTemplate.findById(postId, Post.class);
        if(post == null){
            throw new RuntimeException("Post cannot be null");
        }
        this.postRepository.delete(post);


    }
    public Post updatePost(String  postId,Post post){
        Post postById = mongoTemplate.findById(postId, Post.class);
        if(postById == null){
            throw new RuntimeException("Post cannot be null");
        }
       return  mongoTemplate.save(post);

    }

    public List<Post> findByKeyValue(String key, String value){
        Query query = new Query(Criteria.where(key).is(value));

        return mongoTemplate.find(query, Post.class);

    }
    // this method is used to get current post by a user
    public List<Post>  getCurrentPost(){
        Query query  = new Query(Criteria.where("createdAt").is(LocalDateTime.now().getHour()));
        return mongoTemplate.find(query, Post.class);


    }


}
