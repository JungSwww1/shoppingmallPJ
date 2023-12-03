package com.ssafy.product.model.service;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.product.model.dao.CartDao;
import com.ssafy.product.model.dao.OrderDao;
import com.ssafy.product.model.dao.ProductDao;
import com.ssafy.product.model.dto.Cart;
import com.ssafy.product.model.dto.Order;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.ProductCondition;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	// 주문 가져오기
	@Override
	public List<Order> getOrder(String id) {
		// TODO Auto-generated method stub
		return orderDao.selectOne(id);
	}

	@Override
	public void removeOrder(String id) {
		// TODO Auto-generated method stub
		orderDao.deleteOrder(id);
	}

	@Override
	public void removeOrder1(String id) {
		// TODO Auto-generated method stub
		orderDao.deleteOrder1(id);
	}
	
	@Override
	public void modifyOrder(Order order) {
		// TODO Auto-generated method stub
		orderDao.updateOrder(order);
	}
	@Override
	public void modifyOrder1(Order order) {
		// TODO Auto-generated method stub
		orderDao.updateOrder1(order);
	}
	@Override
	public void modifyOrder2(Order order) {
		// TODO Auto-generated method stub
		orderDao.updateOrder2(order);
	}
}
