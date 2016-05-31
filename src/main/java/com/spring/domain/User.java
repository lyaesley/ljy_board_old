package com.spring.domain;

import java.util.Date;

public class User {
	
	int num;
	String id;
	String password;
	String name;
	Date register;
	
	public User(){}
	
	public User(int num, String id, String password, String name, Date register){
		this.id = id;
		this.password = password;
		this.name = name;
		this.register = register;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegister() {
		return register;
	}
	public void setRegister(Date register) {
		this.register = register;
	}
	
}
