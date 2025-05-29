package com.example.optimizerpc.controllers.Sale;

import com.example.optimizerpc.models.adapters.Sale.SaleAdapter;
import com.example.optimizerpc.models.dtos.Sale.SaleDTO;
import com.example.optimizerpc.models.entities.User.User;
import com.example.optimizerpc.models.mappers.Sale.SaleMapper;
import com.example.optimizerpc.models.services.User.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "Sale API")
@RequestMapping("/v0")
public class SaleCommandController {

    private final SaleAdapter saleAdapter;
    private final SaleMapper mapper;
    private final IUserService userService;

    public SaleCommandController(SaleAdapter saleAdapter, SaleMapper mapper, IUserService userService) {
        this.saleAdapter = saleAdapter;
        this.mapper = mapper;
        this.userService = userService;
    }

    @PostMapping("/sale")
    @Operation(summary = "Create a new sale" , description = "Create a new sale")
    public ResponseEntity<SaleDTO> create(@RequestParam ("price") Double price,
                                          @RequestParam ("userId") String userId){

        User user = userService.findById(userId);

        SaleDTO sale = mapper.mapDTO(saleAdapter.create(price, user));

        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }
}
