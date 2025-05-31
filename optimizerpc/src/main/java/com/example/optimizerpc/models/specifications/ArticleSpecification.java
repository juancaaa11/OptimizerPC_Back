package com.example.optimizerpc.models.specifications;

import com.example.optimizerpc.models.entities.Article.Article;
import com.example.optimizerpc.models.entities.Article.Article_;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSpecification implements Specification<Article> {

    private String search;

    @Override
    public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        query.orderBy(criteriaBuilder.desc(root.get(Article_.ID)));

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(search)) {
            Expression<String> articleNameToLowerCase = criteriaBuilder.lower(root.get(Article_.NAME));
            Predicate articleNameLikePredicate = criteriaBuilder.like(articleNameToLowerCase, "%".concat(search.toLowerCase()).concat("%"));
            predicates.add(articleNameLikePredicate);
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
