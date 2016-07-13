package com.spring.board;

import java.util.List;
import java.util.Map;

import com.spring.domain.Board;

public interface BoardDao {
	
	void add(Board board);
	
	void update(Board board);
	
	Board get(int num);
	
	List<Board> list();
	
	void delete(int num);

	void insertBoard(Map<String, Object> map);

	List<Map<String, Object>> selectBoardList(Map<String, Object> map);

	void updateHitCnt(Map<String, Object> map);

	Map<String, Object> selectBoardDetail(Map<String, Object> map);

	
}
