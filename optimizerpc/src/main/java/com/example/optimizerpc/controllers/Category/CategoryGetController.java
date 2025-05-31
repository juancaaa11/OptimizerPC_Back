package com.example.optimizerpc.controllers.Category;

import com.example.optimizerpc.models.adapters.Category.CategoryAdapter;
import com.example.optimizerpc.models.dtos.Category.CategoryDTO;
import com.example.optimizerpc.models.mappers.Category.CategoryMapper;
import com.example.optimizerpc.models.services.Category.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Tag(name = "Category API")
@RequestMapping("/v0")
public class CategoryGetController {

    private final CategoryAdapter categoryAdapter;
    private final ICategoryService categoryService;
    private final CategoryMapper mapper;

    public CategoryGetController(CategoryAdapter categoryAdapter, ICategoryService categoryService, CategoryMapper mapper) {
        this.categoryAdapter = categoryAdapter;
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    @GetMapping("/category/{id}")
    @Operation(summary = "Get a Category", description = "Get a Category by its id")
    public ResponseEntity<CategoryDTO> get(@PathVariable("id")String id){

        CategoryDTO categoryDTO = mapper.mapDTO(categoryService.findById(id));

        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @GetMapping("/s/categories")
    @Operation(summary = "Get all category", description = "Get all category")
    public ResponseEntity<List<CategoryDTO>> getAll(){

        List<CategoryDTO> categoryList = categoryService.findAll().stream().map(mapper::mapDTO).toList();

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
