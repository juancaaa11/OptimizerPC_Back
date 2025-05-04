package com.example.optimizerpc.models.dtos.Article;

import com.example.optimizerpc.models.entities.Category.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCreateDTO {

    @NotNull
    @NotBlank
    private String name;

    private String image;

    @NotNull
    @NotBlank
    private Double price;
}
