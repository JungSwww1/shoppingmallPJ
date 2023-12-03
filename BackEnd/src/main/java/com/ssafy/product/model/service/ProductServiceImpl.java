package com.ssafy.product.model.service;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.product.model.dao.ProductDao;
import com.ssafy.product.model.dto.Product;
import com.ssafy.product.model.dto.ProductCondition;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	private ProductDao productDao;
	
	@Autowired
	ResourceLoader resLoader;
	
	@Autowired
	public void setBoardDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	
	@Override
	public List<Product> getList(ProductCondition productCondition) {
		return productDao.select(productCondition);
	}

	@Transactional
	@Override
	public void registerProduct(Product product, MultipartFile file) throws IllegalStateException, IOException {
		
		// 파일을 저장할 폴더 지정
		
		Resource res = resLoader.getResource("resources/upload");
		logger.debug("res: {}", res.getFile().getCanonicalPath());
		if (file != null && file.getSize() > 0) {
			// prefix를 포함한 전체 이름
			if(!res.getFile().exists()) {
		 		res.getFile().mkdirs();
		 	}
			
			product.setImg(System.currentTimeMillis() + "_" + file.getOriginalFilename());
			product.setOrgImg(file.getOriginalFilename());

			// 변경된 파일 이름이 적용된 Car을 CarService를 통해 DB에 저장한다.

			file.transferTo(new File(res.getFile().getCanonicalPath() + "/" + product.getImg()));
		}
		
		productDao.insertProduct(product);
	}

	@Override
	public Product getProduct(int id) {	
		productDao.updateViewCnt(id);
		return productDao.selectOne(id);
	}

	@Transactional
	@Override
	public void modifyProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Transactional
	@Override
	public void removeProduct(int id) {
		System.out.println(id+"번 글을 삭제 했습니다.");
		productDao.deleteProduct(id);
	}

	@Override
	public List<Product> getPurProduct() {
		return productDao.selectPurList();
	}
	
	@Override
	public List<Product> getStockProduct() {
		return productDao.selectStockList();
	}
	
	@Override
	public List<Product> getNewProduct() {
		return productDao.selectNewList();
	}


	@Transactional
	@Override
	public void orderProduct(Product product) {
		productDao.updateOrder(product);
	}
}
