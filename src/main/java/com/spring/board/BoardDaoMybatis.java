package com.spring.board;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Board;
import com.spring.logger.LoggerInterceptor;

@Repository
public class BoardDaoMybatis implements BoardDao{
	protected Logger log = Logger.getLogger(LoggerInterceptor.class.getName());
	
	@Autowired SqlSessionTemplate sqlSessionTemplate;
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()){
			log.debug("\t QueryId  \t:  " + queryId);
		}
	}
	
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

	@Override
	public void insertBoard(Map<String, Object> map) {
		sqlSessionTemplate.insert("board.insertBoard", map);
		
	}

	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("board.selectBoardList", map);
	}

	@Override
	public void updateHitCnt(Map<String, Object> map) {
		sqlSessionTemplate.update("board.updateHitCnt", map);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) {
	return (Map<String, Object>) sqlSessionTemplate.selectOne("board.selectBoardDetail", map);
	}

	@Override
	public void updateBoard(Map<String, Object> map) {
		sqlSessionTemplate.update("board.updateBoard",map);
		
	}

	@Override
	public void deleteBoard(Map<String, Object> map) {
		sqlSessionTemplate.delete("board.deleteBoard", map);
		
	}

	@Override
	public void insertFile(Map<String, Object> map) {
		sqlSessionTemplate.insert("board.insertFile", map);
		
	}

	@Override
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("board.selectFileList",map);
	}

	@Override
	public void deleteFileList(Map<String, Object> map) {
		sqlSessionTemplate.update("deleteFileList", map);
		
	}
	
	@Override
	public void updateFile(Map<String, Object> map) {
		sqlSessionTemplate.update("updateFile", map);
		
	}
	
	
	
}
