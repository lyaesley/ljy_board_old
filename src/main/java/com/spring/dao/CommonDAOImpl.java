package com.spring.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAOImpl implements CommonDAO{
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Map<String, Object> selectFileInof(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("common.selectFileInfo", map);
	}
	

}

