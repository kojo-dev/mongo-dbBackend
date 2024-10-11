package com.example.blogApp.Services;

import com.example.blogApp.Category;
import com.example.blogApp.Repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private CategoryRepo categoryRepo;
    public Category createCategory(Category category){
        Category category1 = Category.builder()
                .name("This is the brand under development")
                .description("This is the the full description of the product")

                .build();
        categoryRepo.insert(category1);
        return category1;
    }
}
