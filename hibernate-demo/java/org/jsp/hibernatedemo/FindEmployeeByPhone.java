package org.jsp.hibernatedemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeByPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		System.out.println("Enter the Employee Phone Number to display details");
		long phone = sc.nextLong();
		String hql = "select emp from Employee emp where emp.phone=:ph";
		@SuppressWarnings("unchecked")
		Query<Employee> q = s.createQuery(hql);
		q.setParameter("ph", phone);

		try {
			Employee e = q.getSingleResult();
			System.out.println("Employee Id: " + e.getId());
			System.out.println("Employee Name: " + e.getName());
			System.out.println("Phone Number: " + e.getPhone());
			System.out.println("Designation: " + e.getDesg());
			System.out.println("Salary: " + e.getSalary());
		} catch (NoResultException ex) {
			System.err.println("No Employee with the phone number: " + phone);
		}
		sc.close();
	}
}
