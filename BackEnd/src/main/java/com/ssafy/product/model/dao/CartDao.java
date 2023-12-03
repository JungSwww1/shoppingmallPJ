package com.ssafy.product.model.dao;

import java.util.List;

import com.ssafy.product.model.dto.Cart;
import com.ssafy.product.model.dto.Order;
import com.ssafy.product.model.dto.Product;

public interface CartDao {
	
	// 장바구니 가져오기
	public List<Cart> selectOne(String id);
	
	// 장바구니 등록
	public void insertCart(Cart cart);
	
	// 장바구니 삭제
	public void deleteCart(int id);
	
	// 장바구니 수정
	public void updateCart(Cart cart);
	
	// 주문에 관련된 정보만 order 테이블에 넣고, 생성된 id를 가져와서 dto에 추가
	public void insertOrder(Order order);
	
	// 해당 주문(order_id)에 관련된 모든 상품들을 추가
	public void insertOrderProduct(Product p);

}
