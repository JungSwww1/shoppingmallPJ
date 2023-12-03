package com.ssafy.product.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.product.model.dto.Review;

public interface ReviewDao {
	
	// 물품에 해당하는 리뷰 가져오기
	List<Review> selectProduct(int id);
	
	// 유저가 작성한 리뷰 가져오기
	List<Review> selectUser(String id);
	
	// 리뷰 작성
	// 1. 리뷰 넣기
	void insertReview(Review review);
	
	// 2. 상품에 해당하는 리뷰 평균 가져오기
	Double getAvgRating(int id);
	
	// 3. 주문물품 리뷰 했다고 처리
	void updateOrderProduct(HashMap<String, Object> map);
	
	// 4. 상품 리뷰 평균 업데이트
	void updateProductRating(HashMap<String, Object> map);
	
	// 내가 쓴 리뷰 삭제
	void removeReview(int id);
	
	// 리뷰 수정
	void updateReview(Review review);
	
	// 리뷰 1개 가져오기
	Review selectOne(int id);
	
}
