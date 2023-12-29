package org.jsp.onetooneuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetooneuni.dto.PanCard;

public class FindPancardByPersonId {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the person id to display pancard details");
		int person_id = s.nextInt();
		String jpql = "select p.card from Person p where p.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(jpql);
		q.setParameter(1, person_id);

		try {
			PanCard card = (PanCard) q.getSingleResult();
			System.out.println("PanCard Id: " + card.getId());
			System.out.println("Number: " + card.getNumber());
			System.out.println("DOB: " + card.getDob());
			System.out.println("PinCode: " + card.getPinCode());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid Person Id");
		}
		s.close();
	}
}
