package org.jsp.userapp.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jsp.userapp.dto.User;

public class UserDao {
	Session s=new Configuration().configure().buildSessionFactory().openSession();
	
	public User saveUser(User user) {
		Transaction t=s.beginTransaction();
		s.save(user);
		t.commit();
		return user;
		
	}
}
