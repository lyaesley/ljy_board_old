package com.spring.board;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.Board;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{

	@Autowired BoardDao dao;

	@Override
	public void add(Board board) {
		board.setReg_dtm(new Date());
		dao.add(board);		
	}

	@Override
	public void update(Board board) {
		board.setReg_dtm(new Date());
		dao.update(board);
	}

	@Override
	public Board get(int num) {
		return dao.get(num);
	}

	@Override
	public List<Board> list() {
		return dao.list();
	}

	@Override
	public void delete(int num) {
		dao.delete(num);
	}
	
}
