package org.jsp.jpademo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Product;

public class SaveProduct {
	public static void main(String[] args) {
		Product p=new Product();
		p.setBrand("Samsung");
		p.setName("Smartphone");
		p.setCategory("Electronics");
		p.setCost(15000);
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(p);
		transaction.commit();
		System.out.println("Product added with Id: "+p.getId());
		
	}
}
