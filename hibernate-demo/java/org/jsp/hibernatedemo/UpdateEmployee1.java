package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		System.out.println("Enter the employee id to update details");
		int eid=sc.nextInt();
		Employee e=s.get(Employee.class, eid); // Persistent State
		if(e!=null) {
			System.out.println("Enter new Name, Phone, Designation, Salary, Password to update");
			sc.nextLine();
			e.setName(sc.nextLine());
			e.setPhone(sc.nextLong());
			sc.nextLine();
			e.setDesg(sc.nextLine());
			e.setSalary(sc.nextDouble());
			sc.nextLine();
			e.setPassword(sc.nextLine());
			Transaction t=s.beginTransaction();
			t.commit();
			System.out.println("Employee details updated successfully");
		}
		else {
			System.out.println("Cannot update the employee details as id is invalid");
		}
		sc.close();
	}
}
