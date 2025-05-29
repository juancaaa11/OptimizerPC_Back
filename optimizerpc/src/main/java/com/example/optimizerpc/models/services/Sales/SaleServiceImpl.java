package com.example.optimizerpc.models.services.Sales;

import com.example.optimizerpc.exceptions.ResourceNotFoundException;
import com.example.optimizerpc.models.entities.Sale.Sale;
import com.example.optimizerpc.models.repository.Sale.SaleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService {

    private final SaleRepository repository;

    public SaleServiceImpl(SaleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Sale save(Sale clazz) {
        return repository.save(clazz);
    }

    @Override
    public List<Sale> save(List<Sale> clazz) {
        return repository.saveAll(clazz);
    }

    @Override
    public Sale findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The sale", "id",
                id));
    }

    @Override
    public List<Sale> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Sale> findAll(Specification<Sale> specification) {
        return repository.findAll(specification);
    }

    @Override
    public Page<Sale> findAll(Specification<Sale> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }

    @Override
    public void delete(Sale clazz) {
        repository.delete(clazz);
    }
}
