package com.spring.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.CommonDAO;

@Service
public class CommonServiceImpl implements CommonService {
	Logger log = Logger.getLogger(CommonServiceImpl.class.getName());
	
	@Autowired
	CommonDAO commonDAO;

	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return commonDAO.selectFileInof(map);
	}
	
		
}
