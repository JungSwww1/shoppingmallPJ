package com.ssafy.product.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.model.dao.ReviewDao;
import com.ssafy.product.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	
	// 물품 리뷰 가져오기
	@Override
	public List<Review> getProductReview(int id) {
		return reviewDao.selectProduct(id);
	}
	
	// 사용자 리뷰 가져오기
	@Override
	public List<Review> getUserReview(String id) {
		return reviewDao.selectUser(id);
	}
	
	// 리뷰 업데이트
	@Override
	public void modifyReview(Review review) {
		reviewDao.updateReview(review);
	}
	
	// 리뷰 삭제하기
	@Override
	public void removeReview(int id) {
		reviewDao.removeReview(id);
		
	}
	
	// 리뷰 작성하기
	@Override
	public void writeReview(Review review) {
		reviewDao.insertReview(review);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("productId", review.getProductId());
		map.put("orderId", review.getOrderId());
		
		double result = reviewDao.getAvgRating(review.getProductId());
		map.put("avgRating", result);
		reviewDao.updateOrderProduct(map);
		
		reviewDao.updateProductRating(map);
	}
	
	// 리뷰 1개 쓰기
	@Override
	public Review getOneReview(int id) {
		return reviewDao.selectOne(id);
	}
	
}
