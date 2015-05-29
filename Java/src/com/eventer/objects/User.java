package com.eventer.objects;

public class User {

	
	private String user = "Emil";
	
	public User(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void printName(){
		System.out.println(user);
	}
}
