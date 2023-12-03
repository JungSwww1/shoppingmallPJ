package com.ssafy.product.model.dao;

import java.util.List;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.ProductCondition;

public interface ProductDao {
	// 전체 상품을 가져온다.
	public List<Product> select(ProductCondition productCondition);

	// ID에 해당하는 상품 하나 가져오기
	public Product selectOne(int id);

	// 상품 등록
	public void insertProduct(Product product);

	// 상품 삭제
	public void deleteProduct(int id);

	// 상품 수정
	public void updateProduct(Product product);
	
	// 결제하기
	public void updateOrder(Product product);
	
	// 조회수 증가
	public void updateViewCnt(int id);

	// 구매 많은 상품들 가져오기
	public List<Product> selectPurList();
		
	// 판매 임박 상품들 가져오기
	public List<Product> selectStockList();
		
	// 신상품들 가져오기
	public List<Product> selectNewList();
}
