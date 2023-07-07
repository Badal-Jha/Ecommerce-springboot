package com.nagarro.restapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	@JsonIgnore
	private Product product;
	private String review;
	private String date;
	private String username;
	private double rating;
	private boolean isApproved=false;
	private String productCode;
	
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	
	
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", product=" + product + ", review=" + review + ", date=" + date
				+ ", username=" + username + ", rating=" + rating +"isApproved="+isApproved+"]";
	}

	public Review() {
		super();
	}
	
	public Review(int reviewId, Product product, String review, String date, String username, double rating) {
		super();
		this.reviewId = reviewId;
		this.product = product;
		this.review = review;
		this.date = date;
		this.username = username;
		this.rating = rating;
		
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	
}
