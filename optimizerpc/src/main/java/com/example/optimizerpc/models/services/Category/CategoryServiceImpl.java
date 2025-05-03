package com.example.optimizerpc.models.services.Category;

import com.example.optimizerpc.exceptions.ResourceNotFoundException;
import com.example.optimizerpc.models.entities.Category.Category;
import com.example.optimizerpc.models.repository.Category.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category save(Category clazz) {
        return repository.save(clazz);
    }

    @Override
    public List<Category> save(List<Category> clazz) {
        return repository.saveAll(clazz);
    }

    @Override
    public Category findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The Category", "id",
                id));
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Category> findAll(Specification<Category> specification) {
        return repository.findAll(specification);
    }

    @Override
    public Page<Category> findAll(Specification<Category> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }

    @Override
    public void delete(Category clazz) {
        repository.delete(clazz);
    }
}
