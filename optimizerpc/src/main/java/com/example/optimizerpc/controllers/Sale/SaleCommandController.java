package com.example.optimizerpc.controllers.Sale;

import com.example.optimizerpc.models.adapters.Sale.SaleAdapter;
import com.example.optimizerpc.models.dtos.Sale.SaleDTO;
import com.example.optimizerpc.models.mappers.Sale.SaleMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Tag(name = "Sale API")
@RequestMapping("/v0")
public class SaleCommandController {

    private final SaleAdapter saleAdapter;
    private final SaleMapper mapper;

    public SaleCommandController(SaleAdapter saleAdapter, SaleMapper mapper) {
        this.saleAdapter = saleAdapter;
        this.mapper = mapper;
    }

    @PostMapping("/sale")
    @Operation(summary = "Create a new sale" , description = "Create a new sale")
    public ResponseEntity<SaleDTO> create(@RequestParam ("price") Double price){

        SaleDTO sale = mapper.mapDTO(saleAdapter.create(price));

        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }
}
