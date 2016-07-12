package com.spring.board;

import java.text.SimpleDateFormat;
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
		board.setReg_dtm(getDateNow());
		dao.add(board);		
	}

	@Override
	public void update(Board board) {
		
		board.setReg_dtm(getDateNow());
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
	
	private String getDateNow(){
		Date from = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = transFormat.format(from);
		return now;
		
	}
}
