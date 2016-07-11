package com.spring.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.User;

@Repository
public class UserDaoMybatis implements UserDao{
	@Autowired SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void add(User user) {
		sqlSessionTemplate.insert("User.add", user);
	}

	@Override
	public void update(User user) {
		sqlSessionTemplate.update("User.update", user);
	}

	@Override
	public User get(int num) {
		return sqlSessionTemplate.selectOne("User.get", num);
	}

	@Override
	public List<User> list() {
		return sqlSessionTemplate.selectList("User.list");
	}

	@Override
	public void delete(int num) {
		sqlSessionTemplate.delete("User.delete", num);
		
	}

	@Override
	public User findByUserIdAndPassword(String id, String password) {

		Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("id", id);
        paramMap.put("password", password);

        return sqlSessionTemplate.selectOne("User.selectLoginUser", paramMap);
	}
	
}
