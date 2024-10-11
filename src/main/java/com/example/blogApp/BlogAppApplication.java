package com.example.blogApp;

import com.example.blogApp.Repository.CategoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(BlogAppApplication.class, args);
	}

	@Bean

	public CommandLineRunner commandLineRunner(CategoryRepo categoryRepo){
		return args -> {
			Category category = Category.builder().
			name("Bring brands live")
					.description("This is the description opf  the brand").
					build();


			categoryRepo.insert(category);

		};
	}


}
