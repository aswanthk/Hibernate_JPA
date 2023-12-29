package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class GetLoadEmployee {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		System.out.println("Enter the employee id to fetch");
		int eid=sc.nextInt();
//		Employee e=s.get(Employee.class, eid);
		Employee e=s.load(Employee.class, eid);
//		System.out.println(e);
		System.out.println(e.getId());
		
		sc.close();
	}
}
