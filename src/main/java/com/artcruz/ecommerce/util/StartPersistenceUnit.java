package com.artcruz.ecommerce.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.artcruz.ecommerce.model.Produto;

public class StartPersistenceUnit {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("ECOMMERCE-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		System.out.println(entityManager.find(Produto.class, 1));
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
