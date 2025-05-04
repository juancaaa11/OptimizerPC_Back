package com.example.optimizerpc.models.adapters.Article;

import com.example.optimizerpc.models.dtos.Article.ArticleCreateDTO;
import com.example.optimizerpc.models.entities.Article.Article;
import com.example.optimizerpc.models.entities.Category.Category;
import com.example.optimizerpc.models.mappers.Article.ArticleMapper;
import com.example.optimizerpc.models.services.Article.IArticleService;
import com.example.optimizerpc.models.services.Category.ICategoryService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ArticleAdapter {

        private final IArticleService articleService;
        private final ArticleMapper mapper;
        private final ICategoryService categoryService;


    public ArticleAdapter(IArticleService articleService, ArticleMapper mapper, ICategoryService categoryService) {
        this.articleService = articleService;
        this.mapper = mapper;
        this.categoryService = categoryService;
    }

    @Transactional
    public Article create(ArticleCreateDTO request, String categoryId){

        Category category = categoryService.findById(categoryId);

        Article article = Article.builder()
                .name(request.getName())
                .image(request.getImage())
                .price(request.getPrice())
                .category(category)
                .build();

        return articleService.save(article);
    }
}
