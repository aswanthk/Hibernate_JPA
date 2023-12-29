package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.jpademo.dto.Product;

public class FindProductByIdUsingJPQL {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Product Id to display details");
		int pid = s.nextInt();
		String jpql = "select p from Product p where p.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(jpql);
		q.setParameter(1, pid);
		try {
			Product p = (Product) q.getSingleResult();
			System.out.println("Product Id: " + p.getId());
			System.out.println("Product Name: " + p.getName());
			System.out.println("Brand: " + p.getBrand());
			System.out.println("Category: " + p.getCategory());
			System.out.println("Cost: " + p.getCost());
		} catch (NoResultException e) {
			System.err.println("Invalid Product Id");
		}
		s.close();
	}
}
