package com.example.optimizerpc.models.dtos.Article;

import com.example.optimizerpc.models.entities.Category.Category;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {

    @Builder.Default
    private String id = "";

    @Builder.Default
    private String name = "";

    @Builder.Default
    private String image = "";

    @Builder.Default
    private Category category = new Category();

    @Builder.Default


    private Double price = 0.0;
}
