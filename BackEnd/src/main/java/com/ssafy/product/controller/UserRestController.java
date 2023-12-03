package com.ssafy.product.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.product.model.dto.Cart;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.User;
import com.ssafy.product.model.service.UserService;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@RestController
@RequestMapping("/api-user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("users")
	public List<User> userList() {
		return userService.getUserList();
	}

	// 유저 등록
	@PostMapping("signup")
	public ResponseEntity<Integer> signup(@RequestBody User user) {
		int result = userService.signup(user);
		if (result == 1) {
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	// 로그인
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
		User tmp = userService.login(user);
		if (tmp == null)
			return new ResponseEntity<Void>(HttpStatus.OK);

		session.setAttribute("loginUser", tmp.getName());
		return new ResponseEntity<User>(tmp, HttpStatus.OK);
	}

	// 로그아웃
	@GetMapping("logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 해당 아이디 가져온다
	@GetMapping("/{id}")
	public ResponseEntity<?> list(@PathVariable String id) {
		List<User> list = userService.getUser(id);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	// 수정
	@PutMapping("/update") 
	public ResponseEntity<Void> update(@RequestBody User user) {
		userService.modifyUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}