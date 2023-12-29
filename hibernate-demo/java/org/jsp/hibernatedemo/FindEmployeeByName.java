package org.jsp.hibernatedemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		System.out.println("Enter the Employee name to display details");
		String name = sc.nextLine();
		String hql = "select emp from Employee emp where emp.name=?1";
		@SuppressWarnings("unchecked")
		Query<Employee> q = s.createQuery(hql);
		q.setParameter(1, name);
		List<Employee> emps = q.getResultList();
		if (emps.size() > 0) {
			for (Employee e : emps) {
				System.out.println("Employee Id: " + e.getId());
				System.out.println("Employee Name: " + e.getName());
				System.out.println("Phone Number: " + e.getPhone());
				System.out.println("Designation: " + e.getDesg());
				System.out.println("Salary: " + e.getSalary());
				System.out.println("-------------------------------");
			}
		} else {
			System.err.println("No Employee with the name: " + name);
		}
		sc.close();
	}
}
