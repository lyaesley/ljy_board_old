package com.spring.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired UserDao dao;

	@Override
	public void add(User user) {
		user.setRegister(new Date());
		dao.add(user);		
	}

	@Override
	public void update(User user) {
		user.setRegister(new Date());
		dao.update(user);
	}

	@Override
	public User get(int num) {
		return dao.get(num);
	}

	@Override
	public List<User> list() {
		return dao.list();
	}

	@Override
	public void delete(int num) {
		dao.delete(num);
	}

	@Override
	public User findByUserIdAndPassword(String id, String password) {
		return dao.findByUserIdAndPassword(id, password);
	}
	
}
