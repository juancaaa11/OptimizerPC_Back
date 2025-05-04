package com.example.optimizerpc.models.adapters.Category;

import com.example.optimizerpc.models.dtos.Category.CategoryCreateDTO;
import com.example.optimizerpc.models.entities.Category.Category;
import com.example.optimizerpc.models.mappers.Category.CategoryMapper;
import com.example.optimizerpc.models.services.Category.ICategoryService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryAdapter {

    private final CategoryMapper mapper;
    private final ICategoryService categoryService;

    public CategoryAdapter(CategoryMapper mapper, ICategoryService categoryService) {
        this.mapper = mapper;
        this.categoryService = categoryService;
    }

    @Transactional
    public Category create(CategoryCreateDTO request) {

        Category category = Category.builder()
                .name(request.getName())
                .type(request.getType())
                .build();

        return categoryService.save(category);
    }
}
