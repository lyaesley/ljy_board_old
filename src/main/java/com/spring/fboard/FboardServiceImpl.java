package com.spring.fboard;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.Fboard;

@Service
@Transactional
public class FboardServiceImpl implements FboardService{

	@Autowired FboardDao dao;

	@Override
	public void add(Fboard fboard) {
		fboard.setRegister(new Date());
		dao.add(fboard);		
	}

	@Override
	public void update(Fboard fboard) {
		fboard.setRegister(new Date());
		dao.update(fboard);
	}

	@Override
	public Fboard get(int num) {
		return dao.get(num);
	}

	@Override
	public List<Fboard> list() {
		return dao.list();
	}

	@Override
	public void delete(int num) {
		dao.delete(num);
	}
	
}
