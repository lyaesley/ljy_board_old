package com.spring.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Board;

@Repository
public class BoardDaoMybatis implements BoardDao{
	
	@Autowired SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void add(Board board) {
		sqlSessionTemplate.insert("board.add", board);
	}

	@Override
	public void update(Board board) {
		sqlSessionTemplate.update("board.update", board);
	}

	@Override
	public Board get(int num) {
		return sqlSessionTemplate.selectOne("board.get", num);
	}

	@Override
	public List<Board> list() {
		return sqlSessionTemplate.selectList("board.list");
	}

	@Override
	public void delete(int num) {
		sqlSessionTemplate.delete("board.delete", num);
		
	}

	
}
