package com.ssafy.product.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.ProductCondition;

//사용자 친화적으로 작성
public interface ProductService {
	// 상품 조회
	List<Product> getList(ProductCondition productCondition);

	// 상품 등록
	void registerProduct(Product product, MultipartFile file) throws IllegalStateException, IOException;

	// 상품 상세 조회
	Product getProduct(int id);

	// 상품 수정
	void modifyProduct(Product product);
	
	// 결제하기 
	void orderProduct(Product product);
		
	// 상품 삭제
	void removeProduct(int id);
	
	//구매 많은 상품들 가져오기
	List<Product> getPurProduct();
		
	//판매 임박 상품들 가져오기
	List<Product> getStockProduct();
		
	// 신상품들 가져오기
	List<Product> getNewProduct();
}
