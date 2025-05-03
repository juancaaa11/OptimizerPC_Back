package com.example.optimizerpc.models.services.Article;

import com.example.optimizerpc.exceptions.ResourceNotFoundException;
import com.example.optimizerpc.models.entities.Article.Article;
import com.example.optimizerpc.models.repository.Article.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    private final ArticleRepository repository;

    public ArticleServiceImpl(ArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Article save(Article clazz) {
        return repository.save(clazz);
    }

    @Override
    public List<Article> save(List<Article> clazz) {
        return repository.saveAll(clazz);
    }

    @Override
    public Article findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The Article", "id",
                id));
    }

    @Override
    public List<Article> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Article> findAll(Specification<Article> specification) {
        return repository.findAll(specification);
    }

    @Override
    public Page<Article> findAll(Specification<Article> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }

    @Override
    public void delete(Article clazz) {
        repository.delete(clazz);
    }
}
