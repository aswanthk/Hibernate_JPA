package org.jsp.jpademo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Product;

public class FindAllProducts {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String jpql="select p from Product p";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery(jpql);
		List<Product> products=q.getResultList();
		for(Product p: products) {
			System.out.println("Product Id: "+p.getId());
			System.out.println("Product Name: "+p.getName());
			System.out.println("Brand: "+p.getBrand());
			System.out.println("Category: "+p.getCategory());
			System.out.println("Cost: "+p.getCost());
			System.out.println("----------------------------");
		}
		
	}
}
