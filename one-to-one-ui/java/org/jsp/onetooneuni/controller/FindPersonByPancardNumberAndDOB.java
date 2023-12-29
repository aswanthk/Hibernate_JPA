package org.jsp.onetooneuni.controller;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetooneuni.dto.Person;

public class FindPersonByPancardNumberAndDOB {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your Pan card number and DOB (YYY-MM-DD) to display person details");
		String number=s.next();
		LocalDate dob=LocalDate.parse(s.next());
		String jpql="select p from Person p where p.card.number=?1 and p.card.dob=?2";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery(jpql);
		q.setParameter(1, number);
		q.setParameter(2, dob);
		
		try {
			Person p=(Person) q.getSingleResult();
			System.out.println("Person Id: "+p.getId());
			System.out.println("Name: "+p.getName());
			System.out.println("Phone Number: "+p.getPhone());
			System.out.println("Email Id: "+p.getEmail());
		}
		catch(NoResultException e) {
			System.err.println("Pan card number and DOB are not matching");
		}
		s.close();
	}
}
