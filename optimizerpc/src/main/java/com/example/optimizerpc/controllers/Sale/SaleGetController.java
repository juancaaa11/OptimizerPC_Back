package com.example.optimizerpc.controllers.Sale;

import com.example.optimizerpc.models.adapters.Sale.SaleAdapter;
import com.example.optimizerpc.models.dtos.Sale.SaleDTO;
import com.example.optimizerpc.models.mappers.Sale.SaleMapper;
import com.example.optimizerpc.models.services.Sales.ISaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Tag(name = "Sale API")
@RequestMapping("/v0")
public class SaleGetController {

    private final ISaleService saleService;
    private final SaleAdapter saleAdapter;
    private final SaleMapper mapper;

    public SaleGetController(ISaleService saleService, SaleAdapter saleAdapter, SaleMapper mapper) {
        this.saleService = saleService;
        this.saleAdapter = saleAdapter;
        this.mapper = mapper;
    }

    @GetMapping("/sale/{id}")
    @Operation(summary = "Get a sale", description = "Get a sale by its id")
    public ResponseEntity<SaleDTO> get(@PathVariable("id")String id){

        SaleDTO saleDTO = mapper.mapDTO(saleService.findById(id));

        return new ResponseEntity<>(saleDTO, HttpStatus.OK);
    }

    @GetMapping("/s/sale")
    @Operation(summary = "Get all saleS", description = "Get all saleS")
    public ResponseEntity<List<SaleDTO>> getAll(){

        List<SaleDTO> saleList = saleService.findAll().stream().map(mapper::mapDTO).toList();

        return new ResponseEntity<>(saleList, HttpStatus.OK);
    }
}
