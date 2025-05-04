package com.example.optimizerpc.models.entities.Article;

import com.example.optimizerpc.models.entities.Category.Category;
import com.github.ksuid.Ksuid;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "articles")
public class Article {

    @Id
    @Builder.Default
    @Column(nullable = false, updatable = false, unique = true, length = 60)
    private String id = "art_" + Ksuid.newKsuid().toString();

    @NotNull
    @Builder.Default
    private String name = "";

    @Builder.Default
    private String image = "";

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Builder.Default
    @NotNull
    private Double price = 0.0;
}
