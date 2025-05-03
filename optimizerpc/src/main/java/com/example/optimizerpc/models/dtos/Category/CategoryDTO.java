package com.example.optimizerpc.models.dtos.Category;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    @Builder.Default
    private String id = "";

    @Builder.Default
    private String name = "";
}
