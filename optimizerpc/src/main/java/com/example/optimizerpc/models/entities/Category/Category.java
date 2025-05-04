package com.example.optimizerpc.models.entities.Category;

import com.example.optimizerpc.models.enums.Category.CategoryType;
import com.github.ksuid.Ksuid;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category {

    @Id
    @Builder.Default
    @Column(nullable = false, updatable = false, unique = true, length = 60)
    private String id = "cat_" + Ksuid.newKsuid().toString();

    @Builder.Default
    @NotNull
    private String name = "";

    @Builder.Default
    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoryType type = CategoryType.OPTIMIZATION;
}
