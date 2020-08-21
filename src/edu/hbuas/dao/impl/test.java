package edu.hbuas.dao.impl;

import java.util.List;

import edu.hbuas.dao.UsersDao;
import edu.hbuas.entity.Users;
import edu.hbuas.service.UsersService;
import edu.hbuas.service.impl.UsersServiceImpl;

public class test {
	public static void main(String[] args) {
		UsersDao ud=new UsersDaoImpl();
		List<Users> users=ud.getuser("z");
		for(Users u:users) {
			System.out.println("you");
			System.out.println(u.toString());
		}
		UsersService us = new UsersServiceImpl();
		String name = us.getuser("z");
		System.out.println(name);
	}

}
