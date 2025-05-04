package com.example.optimizerpc.models.dtos.Category;

import com.example.optimizerpc.models.enums.Category.CategoryType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private String id;

    private String name;

    private CategoryType type;
}
