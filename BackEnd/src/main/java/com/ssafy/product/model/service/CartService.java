package com.ssafy.product.model.service;

import java.util.List;

import com.ssafy.product.model.dto.Cart;
import com.ssafy.product.model.dto.Order;
import com.ssafy.product.model.dto.Product;

public interface CartService {
	
	//장바구니 가져오기
	List<Cart> getCart(String id);
	
	//장바구니 등록
	void storeCart(Cart cart);
	
	//장바구니 삭제
	void removeCart(int id);
	
	//장바구니 수정
	void modifyCart(Cart cart);
	
	// 주문하기
	void placeOrder(Order order);
}
