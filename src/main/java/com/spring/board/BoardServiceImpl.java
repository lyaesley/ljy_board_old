package com.spring.board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.common.CommandMap;
import com.spring.domain.Board;
import com.spring.util.FileUtils;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	Logger log = Logger.getLogger(BoardServiceImpl.class.getName());
	
	@Autowired BoardDao dao;
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
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

	@Override
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		dao.insertBoard(map);
		
		List<Map<String,Object>> list = fileUtils.parseInsertFileInof(map, request);
		for(int i=0, size=list.size(); i<size; i++){
			dao.insertFile(list.get(i));
		}
		/*
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		while(iterator.hasNext()){
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false){
				log.debug("------------- file start -------------");
	            log.debug("name : "+multipartFile.getName());
	            log.debug("filename : "+multipartFile.getOriginalFilename());
	            log.debug("size : "+multipartFile.getSize());
	            log.debug("-------------- file end --------------\n");
			}
		}
		*/
	}

	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		
		return dao.selectBoardList(map);	
	}

	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		dao.updateHitCnt(map);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> tempMap = dao.selectBoardDetail(map);
		resultMap.put("map", tempMap);
		
		List<Map<String,Object>> list = dao.selectFileList(map);
		resultMap.put("list", list);
		
		return resultMap;
	}

	@Override
	public void updateBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		dao.updateBoard(map);
		
		dao.deleteFileList(map);
		List<Map<String,Object>> list = fileUtils.parseInsertFileInof(map, request);
		Map<String,Object> tempMap = null;
		for(int i=0, size=list.size(); i<size; i++){
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")){
				dao.insertFile(tempMap);
			}
			else{
				dao.updateFile(tempMap);
			}
		}
	}

	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
		dao.deleteBoard(map);
		
	}

	
}
