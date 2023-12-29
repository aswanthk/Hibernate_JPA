package org.jsp.hibernatedemo;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployee {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Employee e=new Employee();
		
		System.out.println("Enter the Name, Phone, Designation, Salary, and Password");
		e.setName(sc.nextLine());
		e.setPhone(sc.nextLong());
		sc.nextLine();
		e.setDesg(sc.nextLine());
		e.setSalary(sc.nextDouble());
		sc.nextLine();
		e.setPassword(sc.nextLine());
		
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Transaction t=s.beginTransaction();
		int i=(Integer)s.save(e);
		t.commit();
		System.out.println("Record inserted successfully with Id: "+i);
		sc.close();
	}
}
