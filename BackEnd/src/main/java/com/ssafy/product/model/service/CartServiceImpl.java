package com.ssafy.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.model.dao.CartDao;
import com.ssafy.product.model.dto.Cart;
import com.ssafy.product.model.dto.Order;
import com.ssafy.product.model.dto.Product;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;
	
	//장바구니 가져오기
	@Override
	public List<Cart> getCart(String id) {
		// TODO Auto-generated method stub
		return cartDao.selectOne(id);
	}
	
	//장바구니 등록
	@Override
	public void storeCart(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.insertCart(cart);
	}

	//장바구니 삭제
	@Override
	public void removeCart(int id) {
		cartDao.deleteCart(id);
	}

	@Override
	public void modifyCart(Cart cart) {
		// TODO Auto-generated method stub
		cartDao.updateCart(cart);
	}

	@Override
	public void placeOrder(Order order) {
		// TODO Auto-generated method stub
		// 먼저 order 테이블에 order 관련 정보 넣기 => 테이블에 추가가 되면 order_id가 생김
		// order DTO 에 order_id가 없는 상태
		System.out.println(order.getOrderId());
		cartDao.insertOrder(order); // MyBatis에서 insert 후 select key로 생성된 id를 가져올 수 있음
		System.out.println(order.getOrderId());
		// order DTO 에 order_id가 생김(MyBatis가 넣어줌)
		for(Product p : order.getProducts()) {
			p.setOrderId(order.getOrderId());
			cartDao.insertOrderProduct(p);
		}
		
		
	}


}
