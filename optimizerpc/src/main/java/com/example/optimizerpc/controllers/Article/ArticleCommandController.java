package com.example.optimizerpc.controllers.Article;

import com.example.optimizerpc.models.services.Article.IArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

@Slf4j
@RestController
@Tag(name = "Article API")
@RequestMapping("/optimizerpc")
public class ArticleCommandController {

    @Autowired
    private IArticleService articleService;



}
