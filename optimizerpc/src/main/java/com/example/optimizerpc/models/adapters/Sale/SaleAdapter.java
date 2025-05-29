package com.example.optimizerpc.models.adapters.Sale;

import com.example.optimizerpc.models.entities.Sale.Sale;
import com.example.optimizerpc.models.services.Sales.ISaleService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaleAdapter {

    private final ISaleService saleService;

    public SaleAdapter(ISaleService saleService) {
        this.saleService = saleService;
    }

    @Transactional
    public Sale create(Double price) {
        Date now = new Date();

        if (price == null || price <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        }

        Sale sale = Sale.builder()
                .price(price)
                .date(now)
                .build();

        return saleService.save(sale);
    }
}
