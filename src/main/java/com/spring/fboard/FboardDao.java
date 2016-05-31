package com.spring.fboard;

import java.util.List;

import com.spring.domain.Fboard;

public interface FboardDao {

	void add(Fboard fboard);
	
	void update(Fboard fboard);
	
	Fboard get(int num);
	
	List<Fboard> list();
	
	void delete(int num);

	
}
