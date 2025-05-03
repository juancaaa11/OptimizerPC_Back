package com.example.optimizerpc.models.mappers.Article;

import com.example.optimizerpc.models.dtos.Article.ArticleDTO;
import com.example.optimizerpc.models.entities.Article.Article;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ArticleMapper {

    private final ModelMapper modelMapper;

    public ArticleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ArticleDTO mapDTO(Article entity) {
        return modelMapper.map(entity, ArticleDTO.class);
    }

}
