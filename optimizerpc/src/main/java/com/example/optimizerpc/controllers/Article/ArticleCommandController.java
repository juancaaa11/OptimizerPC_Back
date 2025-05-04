package com.example.optimizerpc.controllers.Article;

import com.example.optimizerpc.models.adapters.Article.ArticleAdapter;
import com.example.optimizerpc.models.dtos.Article.ArticleCreateDTO;
import com.example.optimizerpc.models.dtos.Article.ArticleDTO;
import com.example.optimizerpc.models.entities.Article.Article;
import com.example.optimizerpc.models.mappers.Article.ArticleMapper;
import com.example.optimizerpc.models.services.Article.IArticleService;
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
@Tag(name = "Article API")
@RequestMapping("/v0")
public class ArticleCommandController {

    private final IArticleService articleService;
    private final ArticleAdapter articleAdapter;
    private final ArticleMapper mapper;

    public ArticleCommandController(IArticleService articleService, ArticleAdapter articleAdapter, ArticleMapper mapper) {
        this.articleService = articleService;
        this.articleAdapter = articleAdapter;
        this.mapper = mapper;
    }

    @PostMapping("/article")
    @Operation(summary = "Create a new article.", description = "Create a new article.")
    public ResponseEntity<ArticleDTO> create(@RequestBody @Valid ArticleCreateDTO request,
                                             @RequestParam(value = "category", required = false) String categoryId){

        ArticleDTO article = mapper.mapDTO(articleAdapter.create(request, categoryId));

        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    @DeleteMapping("/article/{id}")
    @Operation(summary = "Delete an article.", description = "Delete an article.")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id")String id){

        Article article = articleService.findById(id);

        articleService.delete(article);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Article deleted successfully.");

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
