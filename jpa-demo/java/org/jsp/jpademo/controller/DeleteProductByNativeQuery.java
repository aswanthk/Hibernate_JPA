package org.jsp.jpademo.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteProductByNativeQuery {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNativeQuery("delete from product where brand=?");
		q.setParameter(1, "Oppo");
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		int r = q.executeUpdate();
		transaction.commit();
		System.out.println(r + " rows deleted");
	}
}
