package com.ssafy.product.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.product.model.dto.Cart;
import com.ssafy.product.model.dto.Order;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.ProductCondition;
import com.ssafy.product.model.service.CartService;
import com.ssafy.product.model.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
@Api(tags="주문 컨트롤")
//@CrossOrigin("*")
public class OrderRestController {

	@Autowired
	private OrderService orderService;
	
	// 1. 유저 아이디에 해당하는 주문 아이템들 가져오기
	@GetMapping("/order/{id}")
	public ResponseEntity<?> list(@PathVariable String id) {
		List<Order> list = orderService.getOrder(id);
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
		
	// 2. 주문 아이템 삭제하기
	@DeleteMapping("/order/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		orderService.removeOrder(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 3. 결제하기 눌렀을 때 장바구니 삭제
	@DeleteMapping("/order1/{id}")
	public ResponseEntity<Void> delete1(@PathVariable String id) {
		orderService.removeOrder1(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 4.단일 주문 취소
	// 4-1. order_product 삭제
	@ApiIgnore
	@PutMapping("/order") 
	public ResponseEntity<Void> update(@RequestBody Order order){
		orderService.modifyOrder(order);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	// 4-2. product 수량 증가
	@PutMapping("/order1") 
	public ResponseEntity<Void> update1(@RequestBody Order order){
		orderService.modifyOrder1(order);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	// 4-3. order_product가 비어있을 시 order 삭제
	@PutMapping("/order2") 
	public ResponseEntity<Void> update2(@RequestBody Order order){
		orderService.modifyOrder2(order);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
