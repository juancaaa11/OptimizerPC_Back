package com.example.optimizerpc.models.mappers.Category;

import com.example.optimizerpc.models.dtos.Category.CategoryDTO;
import com.example.optimizerpc.models.entities.Category.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

    private final ModelMapper modelMapper;

    public CategoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CategoryDTO mapDTO(Category entity) {
        return modelMapper.map(entity, CategoryDTO.class);
    }
}
