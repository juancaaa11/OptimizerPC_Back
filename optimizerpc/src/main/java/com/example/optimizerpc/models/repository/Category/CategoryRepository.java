package com.example.optimizerpc.models.repository.Category;

import com.example.optimizerpc.models.entities.Category.Category;
import com.example.optimizerpc.models.repository.BaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseEntityRepository<Category, String> {
}
