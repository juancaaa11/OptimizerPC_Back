package com.example.optimizerpc.models.mappers.Sale;

import com.example.optimizerpc.models.dtos.Sale.SaleDTO;
import com.example.optimizerpc.models.entities.Sale.Sale;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SaleMapper {

    private final ModelMapper modelMapper;

    public SaleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SaleDTO mapDTO(Sale entity) {
        return modelMapper.map(entity, SaleDTO.class);
    }
}
