package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		
		Employee e=new Employee(); // Transient State
		System.out.println("Enter Id, Name, Phone, Designation, Salary, Password to update");
		e.setId(sc.nextInt());
		sc.nextLine();
		e.setName(sc.nextLine());
		e.setPhone(sc.nextLong());
		sc.nextLine();
		e.setDesg(sc.nextLine());
		e.setSalary(sc.nextDouble());
		sc.nextLine();
		e.setPassword(sc.nextLine());
		
		s.saveOrUpdate(e); // s.update(e);
		Transaction t=s.beginTransaction();
		t.commit();
		System.out.println("Employee details updated successfully");
		sc.close();
	}
}
