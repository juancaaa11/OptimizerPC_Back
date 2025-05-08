package com.example.optimizerpc.models.entities.Category;

import com.example.optimizerpc.models.enums.Category.CategoryType;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Category.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Category_ {

	
	/**
	 * @see com.example.optimizerpc.models.entities.Category.Category#name
	 **/
	public static volatile SingularAttribute<Category, String> name;
	
	/**
	 * @see com.example.optimizerpc.models.entities.Category.Category#id
	 **/
	public static volatile SingularAttribute<Category, String> id;
	
	/**
	 * @see com.example.optimizerpc.models.entities.Category.Category#type
	 **/
	public static volatile SingularAttribute<Category, CategoryType> type;
	
	/**
	 * @see com.example.optimizerpc.models.entities.Category.Category
	 **/
	public static volatile EntityType<Category> class_;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TYPE = "type";

}

