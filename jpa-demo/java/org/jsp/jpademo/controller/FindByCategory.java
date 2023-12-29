package org.jsp.jpademo.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Product;

// Using @NamedQuery
public class FindByCategory {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("Enter the category to display Products");
		String category=sc.nextLine();
		Query q=manager.createNamedQuery("FindByCategory");
		q.setParameter(1, category);
		List<Product> products=q.getResultList();
		if(products.size()>0) {
			for(Product p: products) {
				System.out.println("Product Id: "+p.getId());
				System.out.println("Product Name: "+p.getName());
				System.out.println("Brand: "+p.getBrand());
				System.out.println("Category: "+p.getCategory());
				System.out.println("Cost: "+p.getCost());
				System.out.println("----------------------------");
			}
		}
		else {
			System.err.println("No product with entered Category");
		}
		sc.close();
	}
}
