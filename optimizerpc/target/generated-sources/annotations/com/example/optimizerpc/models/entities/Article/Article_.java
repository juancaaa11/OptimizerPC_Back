package com.example.optimizerpc.models.entities.Article;

import com.example.optimizerpc.models.entities.Category.Category;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Article.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Article_ {

	
	/**
	 * @see com.example.optimizerpc.models.entities.Article.Article#image
	 **/
	public static volatile SingularAttribute<Article, String> image;
	
	/**
	 * @see com.example.optimizerpc.models.entities.Article.Article#price
	 **/
	public static volatile SingularAttribute<Article, Double> price;
	
	/**
	 * @see com.example.optimizerpc.models.entities.Article.Article#name
	 **/
	public static volatile SingularAttribute<Article, String> name;
	
	/**
	 * @see com.example.optimizerpc.models.entities.Article.Article#id
	 **/
	public static volatile SingularAttribute<Article, String> id;
	
	/**
	 * @see com.example.optimizerpc.models.entities.Article.Article#category
	 **/
	public static volatile SingularAttribute<Article, Category> category;
	
	/**
	 * @see com.example.optimizerpc.models.entities.Article.Article
	 **/
	public static volatile EntityType<Article> class_;

	public static final String IMAGE = "image";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String CATEGORY = "category";

}

