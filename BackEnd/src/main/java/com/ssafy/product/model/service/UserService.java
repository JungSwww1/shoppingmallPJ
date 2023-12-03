package com.ssafy.product.model.service;

import java.util.List;

import com.ssafy.product.model.dto.Cart;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.User;

public interface UserService {

//	public abstract List<User> getUserList(); //아래와 동일
	List<User> getUserList();

	int signup(User user);

	User login(User user);
	
	List<User> getUser(String id);
	
	// 수정
	void modifyUser(User user);
}