package com.ssafy.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.product.model.dao.UserDao;
import com.ssafy.product.model.dto.Cart;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	
	@Override
	public int signup(User user) {
		
		if(userDao.getId(user.getId()) == null) {
			userDao.insertUser(user);
			return 1;
		}
		return 0;
	}


	@Override
	public User login(User user) {
		//DB 해당 ID만 넘겨서 데이터를 가지고 오고 가지고온 User 데이터와 내가 현재 가지고 있는 user의 비밀번호를 확인하면
		User tmp = userDao.selectOne(user.getId());
		//tmp가 실제 User 정보 일수도 있고 / null 넘어왔다.
		if(tmp != null && tmp.getPassword().equals(user.getPassword()))
			return tmp;
		return null;
	}


	@Override
	public List<User> getUser(String id) {
		// TODO Auto-generated method stub
		return userDao.select1(id);
	}

	@Transactional
	@Override
	public void modifyUser(User user) {
		userDao.updateUser(user);
	}

}
