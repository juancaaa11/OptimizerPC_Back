package com.example.optimizerpc.models.repository.Article;

import com.example.optimizerpc.models.entities.Article.Article;
import com.example.optimizerpc.models.repository.BaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends BaseEntityRepository <Article, String> {
}
