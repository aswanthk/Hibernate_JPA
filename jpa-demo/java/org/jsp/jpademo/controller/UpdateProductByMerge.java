package org.jsp.jpademo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Product;

public class UpdateProductByMerge {
	public static void main(String[] args) {
		Product p=new Product();
		p.setId(170);
		p.setName("Smartphone");
		p.setCategory("Electronics");
		p.setBrand("Oppo");
		p.setCost(18000);
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		manager.merge(p);
		transaction.begin();
		transaction.commit();
		
	}
}
