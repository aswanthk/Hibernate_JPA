package org.jsp.onetooneuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetooneuni.dto.Person;

public class FindPersonByPancardId {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Pan card id to display person details");
		int card_id=s.nextInt();
		String jpql="select p from Person p where p.card.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery(jpql);
		q.setParameter(1, card_id);
		
		try {
			Person p=(Person) q.getSingleResult();
			System.out.println("Person Id: "+p.getId());
			System.out.println("Name: "+p.getName());
			System.out.println("Phone Number: "+p.getPhone());
			System.out.println("Email Id: "+p.getEmail());
		}
		catch(NoResultException e) {
			System.err.println("You have entered an invalid Pan card id");
		}
		s.close();
	}
}
