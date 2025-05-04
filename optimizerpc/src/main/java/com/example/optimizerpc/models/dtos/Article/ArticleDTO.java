package com.example.optimizerpc.models.dtos.Article;

import com.example.optimizerpc.models.entities.Category.Category;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {

    private String id ;

    private String name;

    private String image;

    private Category category;

    private Double price = 0.0;
}
