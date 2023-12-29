package org.jsp.jpademo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Product;

public class FindProductByName {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Product name to display details");
		String name = s.next();
		String jpql = "select p from Product p where p.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(jpql);
		q.setParameter(1, name);
		List<Product> products = q.getResultList();
		if (products.size() > 0) {
			for(Product p: products) {
				System.out.println("Product Id: "+p.getId());
				System.out.println("Product Name: "+p.getName());
				System.out.println("Brand: "+p.getBrand());
				System.out.println("Category: "+p.getCategory());
				System.out.println("Cost: "+p.getCost());
				System.out.println("----------------------------");
			}
		} else {
			System.err.println("No Produts with entered Name");
		}
		s.close();
	}
}
