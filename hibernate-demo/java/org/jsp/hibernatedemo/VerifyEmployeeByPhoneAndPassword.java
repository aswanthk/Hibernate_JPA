package org.jsp.hibernatedemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyEmployeeByPhoneAndPassword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		System.out.println("Enter the Employee Phone Number and Password to verify employee");
		long phone = sc.nextLong();
		sc.nextLine();
		String password = sc.nextLine();
		String hql = "select emp from Employee emp where emp.phone=?1 and emp.password=?2";
		@SuppressWarnings("unchecked")
		Query<Employee> q = s.createQuery(hql);
		q.setParameter(1, phone);
		q.setParameter(2, password);

		try {
			Employee e = q.getSingleResult();
			System.out.println(e);
			System.out.println("Verification Sussessful");
		} catch (NoResultException ex) {
			System.err.println("Invalid Phone number or Password");
		}
		sc.close();
	}
}
