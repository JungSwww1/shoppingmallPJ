package com.ssafy.product.model.dao;

import java.util.List;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.User;

public interface UserDao {

	List<User> selectAll();

	int insertUser(User user);
	
	User selectOne(String id);
	
	List<User> select1(String id);
	
	String getId(String id);
	
	// 수정
	void updateUser(User user);

}