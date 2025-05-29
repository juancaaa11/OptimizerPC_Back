package com.example.optimizerpc.models.dtos.Sale;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class SaleDTO {

    @Builder.Default
    private String id = "";

    @Builder.Default
    private Double price = 0.0;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Builder.Default
    private Date date = new Date();
}
