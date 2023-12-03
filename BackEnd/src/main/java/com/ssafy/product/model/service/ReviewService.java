package com.ssafy.product.model.service;

import java.util.List;

import com.ssafy.product.model.dto.Review;

public interface ReviewService {
		
	// 물품 리뷰 가져와
	List<Review> getProductReview(int id);
	
	// 사용자 리뷰 가져와
	List<Review> getUserReview(String id);
	
	// 리뷰 써
	void writeReview(Review review);
	
	// 리뷰 삭제
	void removeReview(int id);
	
	// 리뷰 수정
	void modifyReview(Review review);
	
	// 리뷰 한개 가져오기
	Review getOneReview(int id);
	
}
