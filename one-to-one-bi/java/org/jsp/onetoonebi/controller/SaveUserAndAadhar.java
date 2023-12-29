package org.jsp.onetoonebi.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetoonebi.dto.AadharCard;
import org.jsp.onetoonebi.dto.User;

public class SaveUserAndAadhar {
	public static void main(String[] args) {
		User user=new User();
		user.setPhone(9876543210L);
		user.setName("ABC");
		
		AadharCard card=new AadharCard();
		card.setNumber(123412341234L);
		card.setDob(LocalDate.parse("1999-01-01"));
		card.setAddress("Bengaluru");
		
		user.setCard(card); // Assigning AadharCard for User
		card.setUser(user); // Assigning User for AadharCard
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(user);
		transaction.begin();
		transaction.commit();
	}
}
