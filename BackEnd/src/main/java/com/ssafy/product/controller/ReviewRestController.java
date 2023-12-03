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

import com.ssafy.product.model.dto.Review;
import com.ssafy.product.model.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
@Api(tags = "리뷰 컨트롤러")
//@CrossOrigin("*")
public class ReviewRestController {

	@Autowired
	private ReviewService reviewService;

	// 1. 물품에 해당하는 리뷰 다 보기
	@GetMapping("/review/product/{id}")
	public ResponseEntity<?> detailProduct(@PathVariable int id) {
		List<Review> list = reviewService.getProductReview(id);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}

	// 2. 사용자에 해당하는 리뷰 다 보기
	@GetMapping("/review/user/{id}")
	public ResponseEntity<?> detailUser(@PathVariable String id) {
		List<Review> list = reviewService.getUserReview(id);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}

	// 2-2. 리뷰 한 개 보기
	@GetMapping("/review/{id}")
	public ResponseEntity<?> detailReview(@PathVariable int id) {
		Review review = reviewService.getOneReview(id);
		if (review == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

	// 3. 등록
	@PostMapping("/review")
	public ResponseEntity<Void> write(@RequestBody Review review) {
		reviewService.writeReview(review);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// 4. 삭제
	@DeleteMapping("/review/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		reviewService.removeReview(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 5. 수정
	@PutMapping("/review")
	public ResponseEntity<Void> update(@RequestBody Review review) {
		reviewService.modifyReview(review);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
