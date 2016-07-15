package com.spring.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.spring.domain.Board;

public interface BoardService {
	
	void add(Board board);
	
	void update(Board board);
	
	Board get(int num);
	
	List<Board> list();
	
	void delete(int num);

	void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception;

	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;

	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;

	void updateBoard(Map<String, Object> map) throws Exception;

	void deleteBoard(Map<String, Object> map) throws Exception;
	
}
