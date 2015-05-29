package com.eventer.connection;

import com.eventer.objects.User;

public class Connection {

	private User u = new User("test");

	public void printData() {
		u.printName();
	}
	
	public void print(){
		System.out.println(u.getUser());
	}
}
