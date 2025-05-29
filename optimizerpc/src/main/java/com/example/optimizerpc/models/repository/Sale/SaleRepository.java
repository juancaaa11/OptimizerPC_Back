package com.example.optimizerpc.models.repository.Sale;

import com.example.optimizerpc.models.entities.Sale.Sale;
import com.example.optimizerpc.models.repository.BaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends BaseEntityRepository <Sale, String>{

}
