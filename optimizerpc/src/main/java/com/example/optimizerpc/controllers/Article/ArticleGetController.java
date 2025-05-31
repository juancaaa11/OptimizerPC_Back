package com.example.optimizerpc.controllers.Article;

import com.example.optimizerpc.models.adapters.Article.ArticleAdapter;
import com.example.optimizerpc.models.dtos.Article.ArticleDTO;
import com.example.optimizerpc.models.mappers.Article.ArticleMapper;
import com.example.optimizerpc.models.services.Article.IArticleService;
import com.example.optimizerpc.models.specifications.ArticleSpecification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v0")
@Tag(name = "Article API")
public class ArticleGetController {

    private final IArticleService articleService;
    private final ArticleAdapter articleAdapter;
    private final ArticleMapper mapper;

    public ArticleGetController(IArticleService articleService, ArticleAdapter articleAdapter, ArticleMapper mapper) {
        this.articleService = articleService;
        this.articleAdapter = articleAdapter;
        this.mapper = mapper;
    }

    @GetMapping("/article/{id}")
    @Operation(summary = "Get a Article", description = "Get a Article by its id")
    public ResponseEntity<ArticleDTO> get(@PathVariable("id")String id){

        ArticleDTO articleDTO = mapper.mapDTO(articleService.findById(id));

        return new ResponseEntity<>(articleDTO, HttpStatus.OK);
    }

    @GetMapping("/s/article")
    @Operation(summary = "Get all articles", description = "Get all articles")
    public ResponseEntity<List<ArticleDTO>> getAll(@RequestParam(value = "search", required = false) String search){

        ArticleSpecification specification = new ArticleSpecification(search);

        List<ArticleDTO> articlesList = articleService.findAll(specification).stream().map(mapper::mapDTO).toList();

        return new ResponseEntity<>(articlesList, HttpStatus.OK);
    }
}
