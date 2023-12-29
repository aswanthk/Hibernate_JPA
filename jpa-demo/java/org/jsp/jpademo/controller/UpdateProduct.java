package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Product;

public class UpdateProduct {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		System.out.println("Enter the product Id to update");
		int id=sc.nextInt();
		Product p=manager.find(Product.class, id); // Persistence state
		if(p!=null) {
			System.out.println("Enter the name, brand, category and cost to update");
			p.setName(sc.next());
			p.setBrand(sc.next());
			p.setCategory(sc.next());
			p.setCost(sc.nextDouble());
			transaction.begin();
			transaction.commit();
		}
		else {
			System.err.println("Cannot update the Product as Id is invalid");
		}
		sc.close();
	}
}
