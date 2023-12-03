package com.ssafy.product.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value="상품 바구니", description = "상품 정보")
public class Product {
	private int id;
	private String itemNm;
	private int price;
	private String category;
	private int purchaseCnt;
	private int totalPrice;
	private String userId;
	private int stockNumber;
	private String itemDetail;
	private int viewCnt;
	private String regTime;
	private String updateTime;
	private String img;
	private String orgImg;
	private int orderId;
	private int productCnt;
	private double avgRating;
	

	public double getAvgRating() {
		return avgRating;
	}




	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}




	public int getProductCnt() {
		return productCnt;
	}




	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}




	public int getOrderId() {
		return orderId;
	}




	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}




	public int getTotalPrice() {
		return totalPrice;
	}




	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public String getImg() {
		return img;
	}




	public void setImg(String img) {
		this.img = img;
	}




	public String getOrgImg() {
		return orgImg;
	}




	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}




	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPurchaseCnt() {
		return purchaseCnt;
	}

	public void setPurchaseCnt(int purchaseCnt) {
		this.purchaseCnt = purchaseCnt;
	}

	
	public Product(String itemNm, int price, int stockNumber, String itemDetail) {
		super();
		this.itemDetail = itemDetail;
		this.itemNm = itemNm;
		this.price = price;
		this.stockNumber = stockNumber;
	}
	
	public Product(int id, String itemNm, int price, int stockNumber, String itemDetail, int viewCnt, String regTime, String updateTime, int purchaseCnt, String category) {
		this.id = id;
		this.itemDetail = itemDetail;
		this.itemNm = itemNm;
		this.price = price;
		this.stockNumber = stockNumber;
		this.viewCnt = viewCnt;
		this.regTime = regTime;
		this.updateTime = updateTime;
		this.purchaseCnt = purchaseCnt;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemNm() {
		return itemNm;
	}

	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemNm=" + itemNm + ", price=" + price + ", stockNumber=" + stockNumber
				+ ", itemDetail=" + itemDetail + ", viewCnt=" + viewCnt + ", regTime=" + regTime + ", updateTime="
				+ updateTime + "]";
	}
	

}
