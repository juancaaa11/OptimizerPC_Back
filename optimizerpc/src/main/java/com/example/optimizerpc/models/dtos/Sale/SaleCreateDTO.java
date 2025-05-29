package com.example.optimizerpc.models.dtos.Sale;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleCreateDTO {

    @NotNull
    private Double price;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
