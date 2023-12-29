package org.jsp.userapp.controller;

import java.util.Scanner;
import org.jsp.userapp.dao.UserDao;
import org.jsp.userapp.dto.User;

public class UserController {
	static Scanner s = new Scanner(System.in);
	static UserDao dao = new UserDao();

	public static void main(String[] args) {
		System.out.println("1. Save User");
		switch (s.nextInt()) {
		case 1: {
			save();
			break;
		}
		default: {
			System.err.println("Invalid Choice");
		}
		}
	}

	public static void save() {
		System.out.println("Enter the name, phone, email, age, gender and password to save user");
		User u = new User();
		u.setName(s.next());
		u.setPhone(s.nextLong());
		u.setEmail(s.next());
		u.setAge(s.nextInt());
		u.setGender(s.next());
		u.setPassword(s.next());
		u=dao.saveUser(u);
		System.out.println("User saved with id: "+u.getId());
	}
}
