package com.spring.board;

import java.util.List;

import com.spring.domain.Board;

public interface BoardService {
	
	void add(Board board);
	
	void update(Board board);
	
	Board get(int num);
	
	List<Board> list();
	
	void delete(int num);
	
}
