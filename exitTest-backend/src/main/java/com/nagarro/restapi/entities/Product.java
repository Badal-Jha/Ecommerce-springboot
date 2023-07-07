package com.nagarro.restapi.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Product {
    
	@Id
	private String productCode;
	@OneToMany(mappedBy = "product",fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
	private List<Review> reviews = new ArrayList<Review>();
	private String productName;
	private String productBrand;
	private int price;
	private String imgUrl;
	private String productDesc;
	
	
	public Product() {
		super();
	}
	
	public Product(String productCode, List<Review> reviews, String productName, String productBrand, int price,String imgUrl,String productDesc) {
		super();
		this.productCode = productCode;
		this.reviews = reviews;
		this.productName = productName;
		this.productBrand = productBrand;
		this.price = price;
		this.imgUrl=imgUrl;
		this.productDesc=productDesc;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	
  
}
