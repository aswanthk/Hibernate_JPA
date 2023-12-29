package org.jsp.onetooneuni.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetooneuni.dto.PanCard;
import org.jsp.onetooneuni.dto.Person;

public class SavePersonAndCard {
	public static void main(String[] args) {
		Person p=new Person(); // Transient state
		p.setName("ABC");
		p.setPhone(9876543210L);
		p.setEmail("abc@gmail.com");
		
		PanCard card=new PanCard();
		card.setNumber("ABCDE1234F");
		card.setPinCode(560078);
		card.setDob(LocalDate.parse("1947-08-15"));
		
		p.setCard(card); // Assigning PanCard for Person
		
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(p);
		manager.persist(card);
		transaction.begin();
		transaction.commit();
	}
}
