package org.jsp.jpademo.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Product;

public class FindProductById {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		System.out.println("Enter the product Id to display details");
		int pid=sc.nextInt();
		Product p=manager.find(Product.class, pid);
		if(p!=null) {
			System.out.println("Product Id: "+p.getId());
			System.out.println("Product Name: "+p.getName());
			System.out.println("Brand: "+p.getBrand());
			System.out.println("Category: "+p.getCategory());
			System.out.println("Cost: "+p.getCost());
		}
		else {
			System.err.println("Invalid Product Id");
		}
		sc.close();
	}
}
