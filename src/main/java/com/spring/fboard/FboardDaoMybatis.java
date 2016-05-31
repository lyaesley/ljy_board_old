package com.spring.fboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Fboard;

@Repository
public class FboardDaoMybatis implements FboardDao{
	
	@Autowired SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void add(Fboard fboard) {
		sqlSessionTemplate.insert("Fboard.add", fboard);
	}

	@Override
	public void update(Fboard fboard) {
		sqlSessionTemplate.update("Fboard.update", fboard);
	}

	@Override
	public Fboard get(int num) {
		return sqlSessionTemplate.selectOne("Fboard.get", num);
	}

	@Override
	public List<Fboard> list() {
		return sqlSessionTemplate.selectList("Fboard.list");
	}

	@Override
	public void delete(int num) {
		sqlSessionTemplate.delete("Fboard.delete", num);
		
	}

	
}
