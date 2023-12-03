package com.ssafy.product.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.product.model.dto.Cart;
import com.ssafy.product.model.dto.Order;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.ProductCondition;

//사용자 친화적으로 작성
public interface OrderService {
	//주문 가져오기
	List<Order> getOrder(String id);
		
	//주문 삭제
	void removeOrder(String id);
		
	//결제하기 장바구니 삭제
	void removeOrder1(String id);
		
	//주문 수정
	void modifyOrder(Order order);
	void modifyOrder1(Order order);
	void modifyOrder2(Order order);
}
