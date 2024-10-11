package com.example.blogApp.Services;

import com.example.blogApp.Repository.UserRepository;
import com.example.blogApp.UserDTO;
import com.example.blogApp.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void createUser(UserDTO userDTO){
        User user = User.builder()
                .username(userDTO.getUsername())
                .createdAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();
        userRepository.insert(user);

    }
}
