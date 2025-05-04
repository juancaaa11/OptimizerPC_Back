package com.example.optimizerpc.models.dtos.Category;

import com.example.optimizerpc.models.enums.Category.CategoryType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateDTO {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private CategoryType type;
}
