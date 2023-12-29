package org.jsp.hibernatedemo;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindEmployee {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		System.out.println("Enter the employee id to display the details");
		Employee e;
		try {
			int eid=sc.nextInt();
			e=s.load(Employee.class, eid);
			System.out.println("Employee Id: "+e.getId());
			System.out.println("Employee Name: "+e.getName());
			System.out.println("Phone Number: "+e.getPhone());
			System.out.println("Designation: "+e.getDesg());
			System.out.println("Salary: "+e.getSalary());
		} catch(ObjectNotFoundException ex) {
			System.err.println("Id doesn't exist");
		} catch(InputMismatchException ex) {
			System.err.println("Invalid Id ");
		}
		sc.close();
	}
}
