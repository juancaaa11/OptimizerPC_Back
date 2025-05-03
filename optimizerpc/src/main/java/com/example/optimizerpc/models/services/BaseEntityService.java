package com.example.optimizerpc.models.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface BaseEntityService<T> {

    T save(T clazz);

    List<T> save(List<T> clazz);

    T findById(String id);

    List<T> findAll();

    List<T> findAll(Specification<T> specification);

    Page<T> findAll(Specification<T> specification, Pageable pageable);

    void delete(T clazz);

}
