package com.ssafy.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.product.model.dto.Cart;
import com.ssafy.product.model.dto.Order;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.service.CartService;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api-cart")
@Api(tags="장바구니 컨트롤")
@CrossOrigin("*")
public class CartRestController {
	
	@Autowired
	private CartService cartService;
	
	// 1. 유저 아이디에 해당하는 장바구니 아이템들 가져오기
	@GetMapping("/cart/{id}")
	public ResponseEntity<?> list(@PathVariable String id) {
		List<Cart> list = cartService.getCart(id);
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Cart>>(list, HttpStatus.OK);
	}
	
	// 2. 장바구니 아이템 저장하기
	@PostMapping("/cart")
	public ResponseEntity<Void> save(@RequestBody Cart cart) {
		cartService.storeCart(cart);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 3. 장바구니 아이템 삭제하기
	@DeleteMapping("/cart/{id}/{pid}")
	public ResponseEntity<Void> delete(@PathVariable String id, @PathVariable int pid) {
		cartService.removeCart(pid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 4. 장바구니 수량 버튼마다 업데이트
	@ApiIgnore
	@PutMapping("/cart") 
	public ResponseEntity<Void> update(@RequestBody Cart cart){
		cartService.modifyCart(cart);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 주문하기 눌렀을 때 작동
	@PostMapping("/order")
	public ResponseEntity<Void> order(@RequestBody Order order) {
		cartService.placeOrder(order);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
