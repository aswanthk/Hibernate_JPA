package org.jsp.userapp.dto;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class TestCfg {

	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		System.out.println(s);
	}

}
