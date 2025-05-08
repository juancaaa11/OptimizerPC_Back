package com.example.optimizerpc.models.entities.User;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class User_ {

	
	/**
	 * @see com.example.optimizerpc.models.entities.User.User#password
	 **/
	public static volatile SingularAttribute<User, String> password;
	
	/**
	 * @see com.example.optimizerpc.models.entities.User.User#address
	 **/
	public static volatile SingularAttribute<User, String> address;
	
	/**
	 * @see com.example.optimizerpc.models.entities.User.User#phone
	 **/
	public static volatile SingularAttribute<User, String> phone;
	
	/**
	 * @see com.example.optimizerpc.models.entities.User.User#name
	 **/
	public static volatile SingularAttribute<User, String> name;
	
	/**
	 * @see com.example.optimizerpc.models.entities.User.User#id
	 **/
	public static volatile SingularAttribute<User, String> id;
	
	/**
	 * @see com.example.optimizerpc.models.entities.User.User
	 **/
	public static volatile EntityType<User> class_;
	
	/**
	 * @see com.example.optimizerpc.models.entities.User.User#email
	 **/
	public static volatile SingularAttribute<User, String> email;
	
	/**
	 * @see com.example.optimizerpc.models.entities.User.User#username
	 **/
	public static volatile SingularAttribute<User, String> username;

	public static final String PASSWORD = "password";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";

}

