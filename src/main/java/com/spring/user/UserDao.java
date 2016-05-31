package com.spring.user;

import java.util.List;

import com.spring.domain.User;

public interface UserDao {

	void add(User user);
	
	void update(User user);
	
	User get(int num);
	
	List<User> list();
	
	void delete(int num);

	public User findByUserIdAndPassword(String id, String password);
	
}
