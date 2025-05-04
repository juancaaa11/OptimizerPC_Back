package com.example.optimizerpc.controllers.Category;

import com.example.optimizerpc.models.adapters.Category.CategoryAdapter;
import com.example.optimizerpc.models.dtos.Category.CategoryCreateDTO;
import com.example.optimizerpc.models.dtos.Category.CategoryDTO;
import com.example.optimizerpc.models.entities.Category.Category;
import com.example.optimizerpc.models.mappers.Category.CategoryMapper;
import com.example.optimizerpc.models.services.Category.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@Tag(name = "Category API")
@RequestMapping("/v0")
public class CategoryCommandController {

    private final ICategoryService categoryService;
    private final CategoryAdapter categoryAdapter;
    private final CategoryMapper mapper;

    public CategoryCommandController(ICategoryService categoryService, CategoryAdapter categoryAdapter, CategoryMapper mapper) {
        this.categoryService = categoryService;
        this.categoryAdapter = categoryAdapter;
        this.mapper = mapper;
    }

    @PostMapping("/category")
    @Operation(summary = "Create a new category.", description = "Create a new category.")
    public ResponseEntity<CategoryDTO> create(@RequestBody @Valid CategoryCreateDTO request){

        CategoryDTO category = mapper.mapDTO(categoryAdapter.create(request));

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/category/{id}")
    @Operation(summary = "Delete an category.", description = "Delete an category.")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id")String id){

        Category category = categoryService.findById(id);

        categoryService.delete(category);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Category deleted successfully.");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
