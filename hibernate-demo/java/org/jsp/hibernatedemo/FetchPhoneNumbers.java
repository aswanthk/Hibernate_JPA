package org.jsp.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchPhoneNumbers {
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		String hql = "select emp.phone from Employee emp";
		@SuppressWarnings("unchecked")
		Query<Long> q = s.createQuery(hql);
		List<Long> phones=q.getResultList();
		for(Long phone: phones) {
			System.out.println(phone);
		}
	}
}
