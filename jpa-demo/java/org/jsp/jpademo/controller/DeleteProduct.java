package org.jsp.jpademo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Product;

public class DeleteProduct {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Product p = manager.find(Product.class, 1);
		if (p != null) {
			manager.remove(p);
			transaction.begin();
			transaction.commit();
		} else {
			System.err.println("Invalid Id");
		}
	}

}
