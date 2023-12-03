package com.ssafy.product.model.dao;

import java.util.List;

import com.ssafy.product.model.dto.Cart;
import com.ssafy.product.model.dto.Order;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.ProductCondition;

public interface OrderDao {
	// 주문 가져오기
	public List<Order> selectOne(String id);
	
	// 주문 삭제
	public void deleteOrder(String id);
	
	// 결제하기  장바구니 삭제
	public void deleteOrder1(String id);
		
	// 주문 수정
	public void updateOrder(Order order);
	public void updateOrder1(Order order);
	public void updateOrder2(Order order);
}
