package com.example.optimizerpc.models.adapters.Sale;

import com.example.optimizerpc.models.entities.Sale.Sale;
import com.example.optimizerpc.models.entities.User.User;
import com.example.optimizerpc.models.services.Sales.ISaleService;
import com.example.optimizerpc.models.services.User.IUserService;
import com.example.optimizerpc.models.services.utils.EmailService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaleAdapter {

    private final ISaleService saleService;
    private final EmailService emailService;

    public SaleAdapter(ISaleService saleService, EmailService emailService) {
        this.saleService = saleService;
        this.emailService = emailService;
    }

    @Transactional
    public Sale create(Double price, User user) {
        Date now = new Date();

        if (price == null || price <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        }

        Sale sale = Sale.builder()
                .price(price)
                .date(now)
                .user(user)
                .build();

        emailService.sendPurchaseConfirmation(user.getEmail(), user.getUsername(), sale.getId(), now, price);

        return saleService.save(sale);
    }
}
