package com.example.optimizerpc.models.entities.Sale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.ksuid.Ksuid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales")
public class Sale {

    @Id
    @Builder.Default
    @Column(nullable = false, updatable = false, unique = true, length = 60)
    private String id = "sale_" + Ksuid.newKsuid().toString();

    @NotNull
    @Builder.Default
    private Double price = 0.0;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
